#include <stdio.h>

int main_pointer2() {
	int a = 0;
	int b = 0;
	printf("두 수를 입력해주세요\n");
	scanf_s("%d %d", &a, &b);
	int c = a + b;
	double d = c / 2.0;

	int *pdata1 = &a;
	int *pdata2 = &b;
	int *pdata3 = &c;
	double *pdata4 = &d;

	*pdata3 = *pdata1 + *pdata2;
	*pdata4 = *pdata3 / 2.0;
	printf("num1:%d\n", *pdata1);
	printf("num2:%d\n", *pdata2);
	printf("총합:%d\n",*pdata3);
	printf("평균:%f\n",*pdata4);
	
}