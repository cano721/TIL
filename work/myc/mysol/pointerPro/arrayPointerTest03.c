#include <stdio.h>
int main_arrtest03() {
	int arr[3] = { 0 }; //배열선언
	int* parr = arr;//포인터에 배열명(첫번째 요소주소)저장

	*parr = 10; //arr의 첫 번째 요소에 10 대입
	*(parr + 1) = 20;
	parr[2] = 30; //[]를 이용하면 배열명처럼 사용할 수 있다.
	for (int i = 0; i < 5; i++) {
		printf("%d\n", parr[i]);
	}
	//차이점
	printf("%d\n", sizeof(arr));
	printf("%d\n", sizeof(parr));
	return 0;
}