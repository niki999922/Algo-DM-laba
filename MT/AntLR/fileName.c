#include <stdio.h>
#include <stdbool.h>

int i, j;

int main() {
i = 1;
j = 1;
while(i < 5) {
i = i + 1;
j = 0;
printf("%d\n", i);
while(j < 5) {
j = j + 1;
printf("%d\n", j);
}
}
i = 1;
while(i < 5) {
printf("%d\n", i * 2);
i = i + 1;
}
return 0;
}