#include <stdio.h>
void calc(int*, int*);
int main_exam2() {
	int a=0, b=0;
	printf("�� ���� �Է��ϼ���\n");
	scanf_s("%d %d", &a, &b);
	calc(&a, &b);
	printf("��:%d\n", a);
	printf("������:%d\n", b);
}

void calc(int* a,int* b) {
	int temp1 = *a;
	int temp2 = *b;
	*a = temp1 / temp2;
	*b = temp1 % temp2;
}
