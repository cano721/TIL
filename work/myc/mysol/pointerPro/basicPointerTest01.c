#include <stdio.h>
//�پ��� Ÿ���� ������ ����
int main_bp() {
	char chdata; //1byte
	int indata; //4
	double doubledata; //8

	char* pchardata = &chdata;
	int* pintdata = &indata;
	double* pdoubledata = &doubledata;

	printf("char*������ ũ��:%d\n", sizeof(pchardata));
	printf("int*������ ũ��:%d\n", sizeof(pintdata));
	printf("double*������ ũ��:%d\n", sizeof(pdoubledata));
	printf("**********************************\n");
	printf("char*�����Ͱ� ����Ű�� �ּҰ� ũ��:%d\n", sizeof(*pchardata));
	printf("int*�����Ͱ� ����Ű�� �ּҰ� ũ��:%d\n", sizeof(*pintdata));
	printf("double*�����Ͱ� ����Ű�� �ּҰ� ũ��:%d\n", sizeof(*pdoubledata));
	printf("**********************************\n");
	printf("char������ ũ��:%d\n", sizeof(chdata));
	printf("int������ ũ��:%d\n", sizeof(indata));
	printf("double������ ũ��:%d\n", sizeof(doubledata));
	return 0;
}