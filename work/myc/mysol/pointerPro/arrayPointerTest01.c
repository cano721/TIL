#include <stdio.h>
int main_artest01() {
	//1. �迭�� ù ��° ����� �ּ�
	//2. �迭���� �ּһ��
	int myarr[5] = { 10,20,30,40,50 };
	int* pmyarr = myarr;

	//pmyarr + 1;//�����ּ� + ���� -> �ɼ��� �ǹ�(����ּҰ���)
	*(pmyarr + 1) = 5;
	pmyarr[1] = 6;

	printf("%p\n", myarr);
	printf("%p\n", myarr + 1);
	printf("%p\n", &myarr[1] );
	return 0;
}