#include <stdio.h>

int main_pte() {
	int num = 100;//int형 변수
	int* p_num; //포인터변수
	int** p_p_num;//2중포인터 - 포인터변수의 주소를 저장
	
	p_num = &num; //포인터 변수에 int변수의 주소를 저장
	p_p_num = &p_num;//포인터 변수 주소를 이중포인터변수에 저장
	printf("num:%d,num의 주소:%p\n", num, &num); // 00CFF8B0
	printf("p_num에 할당된 주소:%p, p_num에 할당된 주소의 값:%d, p_num의 주소:%p\n", p_num, *p_num,&p_num); // 00CFF8B0
	printf("p_p_num에 할당된 주소:%p, p_p_num에 할당된 주소의 값:%p, p_p_num의 주소:%p\n", p_p_num, *p_p_num,&p_p_num); // 00CFF8B0
	return 0;
}