
#include <stdio.h>
#include <limits.h>
int main_type2(void) {
	//실수 - 123.0(double), 123.0f(float)
	printf("%f\n", 123.0);
	printf("%f\n", 123.0f);
	printf("%f\n", 2000000000.0f+20);
	printf("%f\n", 2000000000.0f+40);
	printf("%f\n", 2000000000.0f+60);
	
	printf("%f\n", 2000000000.0+20);
	printf("%f\n", 2000000000.0+40);
	printf("%f\n", 2000000000.0+60);

	//char
	char chardata = 'A';
	chardata = chardata + 1;
	printf("%c\n", chardata);
	printf("%d\n", chardata);

	//python -> 튜플,리스트,딕셔너리,Set
	//다른언어에서는 자료를 다루는 기본 구조 배열
	//c에서는 문자열을 다룰때 char배열로 처리를 한다.
	char mystrBuffer[10] = { 'H','i' };
	char mystrBuffer2[10] = { "hello" };
	puts(mystrBuffer);
	puts(mystrBuffer2);
	//gets_s(mystrBuffer2, sizeof(mystrBuffer2));
	return 0;
}