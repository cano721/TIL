#include <stdio.h>
//전역변수와 함수의 원형선언
//이런 함수의 원형들이 선언되어있는 파일이 헤더파일 - xxx.h
int add2(int, int); // 함수의 원형선언 - 컴파일러한테 알려주는 작업

int main_test03() {
	int result = add2(10, 20);
	printf("%d", result);
	return 0;
}

int add2(int num1, int num2) {
	int result = 0;
	result = num1 + num2;
	return result;
}