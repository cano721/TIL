#include <stdio.h>
void printvalue(char** myarr, int cnt);
int main_pte22() {
	//myarr = {char*,char*,char*}
	char* myarr[] = { "c programming","python","raspberrypi","android" };
	//배열의 요소의 수를 저장( 포인터는 4byte임. 16byte/4byte 4개)
	int count = sizeof(myarr)/sizeof(myarr[0]);
	printvalue(myarr, count);
	return 0;
}

//myarr를 매개변수 받아서 값을 출력 - 이중포인터로 선언 printExam
//문자열 출력
//포인터가 배열을 저장하면 배열처럼 쓸 수 있다.
void printvalue(char** myarr,int cnt)
{
	for (int i = 0; i < cnt; i++) {
		printf("%s\n", myarr[i]);
	}
}