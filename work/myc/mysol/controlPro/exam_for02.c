#include <stdio.h>

int main_examfor02() {
	int num = 0;
	printf("����� ������ �Է�:");
	scanf_s("%d", &num);
	for (int i = 1; i <= 9; i++) {
		printf("%d * %d = %d\n", num, i, num * i);
	}
}