#include <stdio.h>
void printvalue(char** myarr, int cnt);
int main_pte22() {
	//myarr = {char*,char*,char*}
	char* myarr[] = { "c programming","python","raspberrypi","android" };
	//�迭�� ����� ���� ����( �����ʹ� 4byte��. 16byte/4byte 4��)
	int count = sizeof(myarr)/sizeof(myarr[0]);
	printvalue(myarr, count);
	return 0;
}

//myarr�� �Ű����� �޾Ƽ� ���� ��� - ���������ͷ� ���� printExam
//���ڿ� ���
//�����Ͱ� �迭�� �����ϸ� �迭ó�� �� �� �ִ�.
void printvalue(char** myarr,int cnt)
{
	for (int i = 0; i < cnt; i++) {
		printf("%s\n", myarr[i]);
	}
}