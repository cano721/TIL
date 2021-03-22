#include <stdio.h>
void calc(int*, int*);
int main_exam2() {
	int a=0, b=0;
	printf("두 수를 입력하세요\n");
	scanf_s("%d %d", &a, &b);
	calc(&a, &b);
	printf("몫:%d\n", a);
	printf("나머지:%d\n", b);
}

void calc(int* a,int* b) {
	int temp1 = *a;
	int temp2 = *b;
	*a = temp1 / temp2;
	*b = temp1 % temp2;
}
