#include <stdio.h>

int* inputdata() {
		int myarr[4] = { 0 };
		printf("���� 4�� �Է�:\n");
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
	//int�� �ּҸ� �����ϴ� �����͹迭 3��
	int* p_arr[10] = { 0 };
	for (int i = 0; i < 10; i++) {
		p_arr[i] = inputdata();
	}
	printdata(p_arr);
	return 0;
}

