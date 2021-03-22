
#include <stdio.h>

//int main(){
//	int a;
//	a = 3;
//	// int a = 3;
//	//l-value = r-value
//	//left,location = right
//	// int num = a;
//	char ch = 'A';
//	printf("%c\n", ch);
//
//	//%c로 출력했기 때문에 문자로 보이지만 내부에서의 연산은??
//	//ch+1
//	//char(1byte) int(4byte) 연산 시 int로 변환해서 연산
//	//다른 타입끼리 연산을 할 경우 표현범위가 큰 형식에 맞춰진다.
//	printf("%c\n", ch+1);
//	printf("%c\n", ch+2);
//
//	//double(8) int(4)의 연산
//	//double 형식으로 연산하므로 %d는 사용할 수 없다.
//	//연산의 결과가 표현범위가 넓은 형식으로 변환되는 현상을 type promotion이라 한다.
//	printf("%d\n", 5.0+2);
//	printf("%f\n", 5.0+2);
//
//	// 곱셈은 *,나눗셈 /, 나머지연산은 %
//	int num = 10;
//	printf("%d\n", num * 10);
//	printf("%d\n", num * 10.0);
//	printf("%f\n", num * 10.0);
//
//	//int/int => int연산 -> 몫
//	printf("%d\n", num /2);
//	printf("%d\n", num /3);
//
//	//printf("%.1f\n", 5.0 / 0);
//	printf("몫:%d\n", 5 / 2);
//	printf("몫:%d\n", 5 % 2);
//	return 0;
//}