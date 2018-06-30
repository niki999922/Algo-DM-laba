#include <iostream>
#include <algorithm>

using namespace std;

const int N = 200000;
int n, res_count, res_x, res_y;

class  Window {
public:
	int x_left = 0;
	int x_right = 0;
	int y_top = 0;
	int y_bot = 0;

	void get_cord() {
		cin >> x_left >> y_top >> x_right >> y_bot;
	}
};
Window window;

class Border {
public:
	int x = 0;
	int y_begin = 0;
	int y_end = 0;
	bool is_open = false;
};
Border borders[N];

class Tree {
public:
	int begin = 0;
	int end = 0;
	int data = 0;
	int toAdd = 0;
	Tree *left_child = nullptr;
	Tree *right_child = nullptr;

	Tree(int begin, int end) {
		this->begin = begin;
		this->end = end;
		if (this->end - this->begin > 1) {
			int mid = (begin + end) / 2;
			left_child = new Tree(begin, mid);
			right_child = new Tree(mid, end);
		}
	}

	void pushing() {
		if (toAdd == 0)
			return;
		data += toAdd;
		left_child->toAdd += toAdd;
		right_child->toAdd += toAdd;
		toAdd = 0;
	}

	int update(int begin, int end, int value) {
		if (begin >= end) {
			return this->data + this->toAdd;;
		}
		else if (begin == this->begin && end == this->end) {
			toAdd += value;
			return this->data + this->toAdd;;
		}
		else {
			pushing();
			return data = max(
				left_child->update(begin, min(left_child->end, end), value),
				right_child->update(max(left_child->end, begin), end, value)
			);
		}
	}

	int get_result() {
		if (left_child == nullptr) {
			return begin;
		}
		else {
			pushing();
			if (left_child->data + left_child->toAdd == data) {
				return left_child->get_result();
			}
			else {
				return right_child->get_result();
			}
		}
	}
};
Tree tree(-N, N + 1);

void set_board(int i) {
	borders[i].y_begin = borders[i + 1].y_begin = window.y_top;
	borders[i].y_end = borders[i + 1].y_end = window.y_bot + 1;
	borders[i].is_open = true;
	borders[i + 1].is_open = false;
	borders[i].x = window.x_left;
	borders[i + 1].x = window.x_right;
}

int main() {
	ios::sync_with_stdio(false);
	cin >> n;
	for (int i = 0; i < 2 * n; i += 2) {
		window.get_cord();
		set_board(i);
	}
	sort(borders, borders + n * 2, [](Border left, Border right) {
		return (left.x < right.x) || (left.x == right.x && (left.is_open || !right.is_open));
	});
	for (int i = 0; i < n * 2; ++i) {
		int add_value;
		if (borders[i].is_open)
			add_value = 1;
		else
			add_value = -1;
		tree.update(borders[i].y_begin, borders[i].y_end, add_value);
		if (tree.data + tree.toAdd > res_count) {
			res_count = tree.data + tree.toAdd;
			res_x = borders[i].x;
			res_y = tree.get_result();
		}
	}
	cout << res_count << '\n' << res_x << ' ' << res_y;
	return 0;
}