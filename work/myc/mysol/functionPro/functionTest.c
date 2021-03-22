
#include <stdio.h>

//매개변수로 전달되는 num1과 num2에 대한 유횽성검증은???
// add function안에서 검증
// 리턴값이 있고 매개변수가 있는 함수
int add(int num1, int num2) { // callee
	int result = 0;
	result = num1 + num2;
	return result;
}
// 리턴값이 없고 매개변수가 없는 함수
void display() {
	for (int i = 1; i <= 5; i++) {
		printf("*");
	}
	printf("\n");
}
//리턴값이 없고 매개변수가 있는 함수
void display2(int count) {
	for (int i = 1; i <= count; i++) {
		printf("*");
	}
	printf("\n");
}
int main_test() { //add함수를 호출하는 caller
	//함수의 호출
	//리턴값 o 매개변수 o
	//리턴값이 있는 경우 호출하는 곳에서 리턴타입과 동일한 변수 선언
	int result = add(10, 20);
	printf("%d",result);
	//리턴값 x 매개변수 x
	display();
	//리턴값 x 매개변수 o
	display2(10);
	return 0;
}