#include <stdio.h>

int main_exam1() {
	int num = 10;
	int *pdata = &num;
	

	printf("%d\n", *pdata);
	*pdata = 100;
	printf("%d", *pdata);
}