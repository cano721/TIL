#include <stdio.h>
void printArr(int*);
void printallArr(int*, int);
int main_arrfuntest01() {
	int myarr[5] = { 10,20,30,40,50 };
	int myarr2[7] = { 10,20,30,40,50,60,70 };
	printArr(myarr);

	printallArr(myarr, 5);
	printallArr(myarr2,sizeof(myarr2)/sizeof(type(myarr2)));
	return 0;
}

//배열의 값을 출력하는 함수 5개 요소로 구성된 배열만 출력
void printArr(int* pmyarr) {//매개변수로 포인터변수 선언
	for (int i = 0; i < 5; i++) {
		printf("%d\n", pmyarr[i]);
	}
}

void printallArr(int* pmyarr,int size) {//배열의 크기가 다른 배열을 모두 출력하기
	for (int i = 0; i < size; i++) {
		printf("%d\n", pmyarr[i]);
	}
}