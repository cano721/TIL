#include <stdio.h>
double calc(int, int, char);

int main_exam4() {
	int a = 0, b = 0;
	double result = 0;
	char c = 0;
	printf("�̴ϰ���\n");
	printf("ex)2+3\n");
	scanf_s("%d %c %d", &a, &c, 1, &b);
	//�Լ��� ȣ��
	result = calc(a, b, c);
	printf("�����:%f", result);
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
		printf("�߸��Է��ϼ̽��ϴ�.");
	}
	return result;
}