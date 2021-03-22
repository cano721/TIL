#include <stdio.h>
void swap(int*, int*);

int main_swap() {
	int a = 1, b = 2;
	printf("변경전 a=%d, b=%d\n", a, b);
	swap(&a, &b);
	printf("변경후 a=%d, b=%d\n", a, b);
}

void swap(int* num1,int* num2) {
	int temp = *num1;
	*num1 = *num2;
	*num2 = temp;
}