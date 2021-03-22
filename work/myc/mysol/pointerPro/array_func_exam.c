#include <stdio.h>
void inputArray(double*);
double getMax(double* myarr, int size);
int main() {
	double myarr[5];
	inputArray(myarr);
	double max = getMax(myarr, sizeof(myarr) / sizeof(myarr[0]));
	printf("최대값:%.2lf\n", max);
}

void inputArray(double* myarr) {
	printf("실수 5개 입력:\n");
	scanf_s("%lf %lf %lf %lf %lf", myarr, myarr+1, myarr+2, myarr+3, myarr+4);
}

double getMax(double* myarr,int size) {
	double max = myarr[0];
	for (int i = 1; i < size; i++) {
		if (max < myarr[i]) {
			max = myarr[i];
		}
	}
	return max;
}