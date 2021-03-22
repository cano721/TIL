#include <stdio.h>
int main_artest01() {
	//1. 배열은 첫 번째 요소의 주소
	//2. 배열명은 주소상수
	int myarr[5] = { 10,20,30,40,50 };
	int* pmyarr = myarr;

	//pmyarr + 1;//기준주소 + 정수 -> 옵셋의 의미(상대주소개념)
	*(pmyarr + 1) = 5;
	pmyarr[1] = 6;

	printf("%p\n", myarr);
	printf("%p\n", myarr + 1);
	printf("%p\n", &myarr[1] );
	return 0;
}