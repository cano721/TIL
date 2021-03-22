#include <stdio.h>
getMax(int,int,int);
int a, b, c;
int main_examfun() {
	printf("숫자 3개를 입력하세요\n");
	scanf_s("%d %d %d", &a, &b, &c);
	//%c - 문자, %d %i - 10진수, %f - float,double , %ld - long
	//%s - 문자열, %lf - long double, %p - 주소(포인터의 주소:16진수로)
	int result = getMax(a, b, c);
	printf("최대값:%d", result);

}

getMax(int a, int b, int c) {
	int max = a;
	if (max <b) {
		max = b;
	}
	if (max < c) {
		max = c;
	}
	return max;
}