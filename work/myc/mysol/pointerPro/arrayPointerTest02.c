#include <stdio.h>

int main_arrtest02() {
	int myarr[5] = { 10,20,30,40,50 };
	int* pmyarr = myarr + 1;
	pmyarr[0] = 100; //myarr[]
	printf("%d\n", myarr[0]);
	printf("%d\n", myarr[1]);
	/*for (int i = 0; i < 5; i++) {
		printf("%d\n", myarr[i]);
	}
	printf("======================\n");
	for (int i = 0; i < 5; i++) {
		printf("%d\n", pmyarr[i]);
	}*/
	return 0;
}