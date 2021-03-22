#include <stdio.h>
//전역변수는 함수 밖에서 선언하는 변수
//전역변수를 사용할 수 있는 범위는 파일(publicVar.c)
//전역변수인 num1은 함수범위 바깥에 선언되어 있으므로 모든 함수에서 사용할 수 있다.(읽기/쓰기)
//전역변수는 초기값을 정의하지 않으면 0으로 초기화된다.
//변수명 접두사를 같이  추가해서 사용
//int -> 접두사 n -> ndata
//long -> 1
//float -> f
//포인터 -> p
//전역변수 ->g_
int g_num1;
//int mydata
int mydata[5];
void show_arr()
{
	for (int i = 0; i < 5; i++) {
		printf("배열의 요소의 값=>%d\n", mydata[i]);
	}
}
void vartest()
{
	printf("vartest에서 전역변수사용:%d\n", g_num1);
	g_num1 = 300;
}
int main_public() {
	vartest();
	printf("main에서 전역변수사용:%d\n", g_num1);
	g_num1 = 500;
	printf("main에서 전역변수사용:%d\n", g_num1);

	show_arr();
	mydata[2] = 200;
	printf("************\n");
	show_arr();
	return 0;
}
