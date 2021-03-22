#include <stdio.h>
void test_sort(double*, double*, double*);
void swap2(double*, double*);
int main_exam3() {
	double a=0, b=0, c=0;
	printf("�Ǽ� 3�� �Է�\n");
	scanf_s("%lf %lf %lf", &a, &b, &c);
	test_sort(&a, &b, &c);
	printf("���氪: %.2lf %.2lf %.2lf\n", a, b, c);
}

void test_sort(double* a, double* b, double* c) {

	if (*a > *b ) {
		swap2(a, b);
	}
	if (*a > *c) {
		swap2(a, c);
	}
	if (*b > *c) {
		swap2(b, c);
	}
}

void swap2(double* num1, double* num2) {
	double temp = *num1;
	*num1 = *num2;
	*num2 = temp;
}