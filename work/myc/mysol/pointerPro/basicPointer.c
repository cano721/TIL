
#include <stdio.h>
int main_basic() {
	int data = 300;//0x0019FED8
	//&연산자 -> 컴파일 타임 연산자
	//&data -> 변수명이 data인 변수가 할당된 메모리의 주소
	//pdata는 data변수의 주소를 저장
	//0x0019FECC
	//포인터변수는 메모리의 주소를 저장하기 위한 변수이다.
	int *pdata = &data;
	//integer2개만큼 늘어난다는 의미 즉, 8byte만큼 이동된 주소
	pdata = pdata + 2;
	// pdata가 가리키는 주소의 데이터값 변경
	*pdata = 300;


	printf("값:%d", data);
	return 0;
}