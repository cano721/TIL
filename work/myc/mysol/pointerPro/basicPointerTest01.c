#include <stdio.h>
//다양한 타입의 포인터 변수
int main_bp() {
	char chdata; //1byte
	int indata; //4
	double doubledata; //8

	char* pchardata = &chdata;
	int* pintdata = &indata;
	double* pdoubledata = &doubledata;

	printf("char*변수의 크기:%d\n", sizeof(pchardata));
	printf("int*변수의 크기:%d\n", sizeof(pintdata));
	printf("double*변수의 크기:%d\n", sizeof(pdoubledata));
	printf("**********************************\n");
	printf("char*포인터가 가리키는 주소값 크기:%d\n", sizeof(*pchardata));
	printf("int*포인터가 가리키는 주소값 크기:%d\n", sizeof(*pintdata));
	printf("double*포인터가 가리키는 주소값 크기:%d\n", sizeof(*pdoubledata));
	printf("**********************************\n");
	printf("char변수의 크기:%d\n", sizeof(chdata));
	printf("int변수의 크기:%d\n", sizeof(indata));
	printf("double변수의 크기:%d\n", sizeof(doubledata));
	return 0;
}