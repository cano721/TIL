#include <stdio.h>
void printArr(int*);
void printallArr(int*, int);
int main_arrfuntest01() {
	int myarr[5] = { 10,20,30,40,50 };
	int myarr2[7] = { 10,20,30,40,50,60,70 };
	printArr(myarr);

	printallArr(myarr, 5);
	printallArr(myarr2,sizeof(myarr2)/sizeof(type(myarr2)));
	return 0;
}

//�迭�� ���� ����ϴ� �Լ� 5�� ��ҷ� ������ �迭�� ���
void printArr(int* pmyarr) {//�Ű������� �����ͺ��� ����
	for (int i = 0; i < 5; i++) {
		printf("%d\n", pmyarr[i]);
	}
}

void printallArr(int* pmyarr,int size) {//�迭�� ũ�Ⱑ �ٸ� �迭�� ��� ����ϱ�
	for (int i = 0; i < size; i++) {
		printf("%d\n", pmyarr[i]);
	}
}