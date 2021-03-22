#include <stdio.h>
int main() {
	//int형 myarr[6][6]배열을 선언하고 1부터 25까지 값을 할당하기
	//할당된 배열의 값을 출력하기
	// 1 2 3 4 5 15
	// 6 7 8 9 10 40
	// ....

	int myarr[6][6] = {0};
	int col[6] = { 0 };
	int row[6] = { 0 };
	int sum = 0;
	int cnt = 0;
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			cnt++;
			myarr[i][j] = cnt;
			col[i] += myarr[i][j];
			row[j] += myarr[i][j];
		}
	}
	for (int i = 0; i < 6; i++) {
		myarr[i][5] = col[i];
	}
	for (int i = 0; i < 6; i++) {
		myarr[5][i] = row[i];
		sum += row[i];
	} 
	myarr[5][5] = sum;
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			printf("%d\t", myarr[i][j]);
		}
		printf("\n");
	}
	return 0;
}