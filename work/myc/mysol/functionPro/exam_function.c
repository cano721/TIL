#include <stdio.h>
getMax(int,int,int);
int a, b, c;
int main_examfun() {
	printf("���� 3���� �Է��ϼ���\n");
	scanf_s("%d %d %d", &a, &b, &c);
	//%c - ����, %d %i - 10����, %f - float,double , %ld - long
	//%s - ���ڿ�, %lf - long double, %p - �ּ�(�������� �ּ�:16������)
	int result = getMax(a, b, c);
	printf("�ִ밪:%d", result);

}

getMax(int a, int b, int c) {
	int max = a;
	if (max <b) {
		max = b;
	}
	if (max < c) {
		max = c;
	}
	return max;
}