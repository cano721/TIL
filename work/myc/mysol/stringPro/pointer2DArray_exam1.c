#include <stdio.h>

int* inputdata() {
		int myarr[4] = { 0 };
		printf("정수 4개 입력:\n");
		scanf_s("%d %d %d %d", myarr, myarr+1, myarr+2, myarr+3);
		return myarr;
}

void printdata(int* parr[]) {
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 4; j++) {
			printf("%d\t", parr[i][j]);
		}
		printf("\n");
	}
}

int main_p2ae() {
	//int형 주소를 참조하는 포인터배열 3개
	int* p_arr[10] = { 0 };
	for (int i = 0; i < 10; i++) {
		p_arr[i] = inputdata();
	}
	printdata(p_arr);
	return 0;
}

