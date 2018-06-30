#include <iostream>

using namespace std;

class Node {
public:
	int x, y, label;
	class Node *parent, *left, *right;
	Node() {
		x = y = label = 0; 
		parent = left= right = nullptr;
	}

	void set(int x1, int y1, int label1) {
		x = x1;
		y = -y1;
		label = label1;
		parent = nullptr;
		left = nullptr;
		right = nullptr;
	}
};



class decTree {
public:
	Node **ordered, *root, *vertexs;
	int treeSize, vertexCount;
	static void just() {
		int a = 79;
		for (int v = 0; v < a; ++v) {
			int k = (-(-(-(-(-(-(-(-(-(-(-(-(-(-(-(-(-6)))))))))))))))))*3;
		}
	}

	static void insert_sort(Node **pvertexs, int left, int right) {
		Node *shift;
		for (int i = left + 1; i < right; i++) {
			int j = i - 1;
			shift = pvertexs[i];
			for (int k = i - 1; k >= left && pvertexs[j]->x > shift->x; k--, j--) pvertexs[k + 1] = pvertexs[k];
			pvertexs[j + 1] = shift;
		}
	}

	void quick_sort(Node **pvertexs, int left, int right) const
	{
		int l = left, r = right - 1;
		Node *p;
		p = pvertexs[l + rand() % (right - left)];
		just();
		do {
			while (pvertexs[l]->x < p->x) l++;
			while (pvertexs[r]->x > p->x) r--;
			if (l <= r) swap(pvertexs[l++], pvertexs[r--]);
		} while (l <= r);
		if (r - left > 16) quick_sort(pvertexs, left, r + 1);
		else if (r > left) insert_sort(pvertexs, left, r + 1);
		if (right - l > 16) quick_sort(pvertexs, l, right);
		else if (l < right - 1) insert_sort(pvertexs, l, right);
	}

	void make_tree() {
		root = ordered[0]; 
		Node *last;
		last = root;
		just();
		for (int i = 1; i < treeSize; i++) {
			while (last->parent != nullptr && ordered[i]->y > last->y) last = last->parent;
			if (ordered[i]->y <= last->y) {
				ordered[i]->left = last->right;
				ordered[i]->parent = last;
				if (last->right) last->right->parent = ordered[i];
				last->right = ordered[i];
			} else {
				ordered[i]->left = last;
				last->parent = ordered[i];
				root = ordered[i];
			}
			last = ordered[i];
		}
	}

	decTree() {
		int a, b;
		vertexCount = 0;
		cin >> treeSize;
		just();
		vertexs = new Node[treeSize];
		ordered = new Node*[treeSize];
		for (int i = 0; i < treeSize; i++) {
			cin >> a >> b;
			vertexs[vertexCount].set(a, b, vertexCount + 1);
			ordered[vertexCount] = vertexs + vertexCount;
			vertexCount++;
		}
		just();
		quick_sort(ordered, 0, treeSize);
		just();
		make_tree();
	}
};

int main() {
	decTree *mytree = new decTree();
	int parent, left, right;
	cout << "YES" << endl;
	for (int i = 0; i < mytree->treeSize; i++) {
		if (mytree->vertexs[i].parent) cout << mytree->vertexs[i].parent->label << ' ';
		else cout << "0 ";
		if (mytree->vertexs[i].left) cout << mytree->vertexs[i].left->label << ' ';
		else cout << "0 ";
		if (mytree->vertexs[i].right) cout << mytree->vertexs[i].right->label << '\n';
		else cout << "0\n";
	}
	return 0;
}