#include <stdio.h>
//�����͸� ����ϴ� ���� �����͸� ������� �ʴ� ��츦 ��
void display(int);
void change(int);
void pointerChange(int*);
int main_fptest01() {
	int main_num = 100;
	printf("**************changeȣ����**************\n");
	display(main_num);
	change(main_num);
	printf("**************changeȣ����**************\n");
	display(main_num);
	pointerChange(&main_num);
	printf("**************pointerChangeȣ����**************\n");
	display(main_num);
	return 0;
}

void display(int num) { //num�̶�� �Ű������� display���ο� ����� ��������
	printf("����:%d\n", num);
}

void change(int num) {//num�̶�� �Ű������� change���ο� ����� ��������
	num = 200;
}

void pointerChange(int* num) {//call by reference
	*num = 200;
}