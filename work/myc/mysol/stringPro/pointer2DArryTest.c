#include <stdio.h>

int main_p2at() {
	int myarr1[3] = { 10,20,30 };
	int myarr2[4] = { 40,50,60,70 };
	int myarr3[5] = { 80,90,100,110,120 };
	//int형 주소를 참조하는 포인터배열 3개
	int* p_arr[3] = {myarr1,myarr2,myarr3};
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 4; j++) {
			printf("%d\t", p_arr[i][j]);
		}
		printf("\n");
	}
	return 0;
}