#include <stdio.h>
double calc(int, int, char);

int main_exam4() {
	int a = 0, b = 0;
	double result = 0;
	char c = 0;
	printf("미니계산기\n");
	printf("ex)2+3\n");
	scanf_s("%d %c %d", &a, &c, 1, &b);
	//함수의 호출
	result = calc(a, b, c);
	printf("결과값:%f", result);
	return 0;
}

double calc(int a, int b, char c) {
	double result = 0;
	switch (c) {
	case '+':
		result = a + b;
		break;
	case '-':
		result = a - b;
		break;
	case '*':
		result = a * b;
		break;
	case '/':
		result = a / (double)b;
		break;
	default:
		printf("잘못입력하셨습니다.");
	}
	return result;
}