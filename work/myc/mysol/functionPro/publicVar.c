#include <stdio.h>
//���������� �Լ� �ۿ��� �����ϴ� ����
//���������� ����� �� �ִ� ������ ����(publicVar.c)
//���������� num1�� �Լ����� �ٱ��� ����Ǿ� �����Ƿ� ��� �Լ����� ����� �� �ִ�.(�б�/����)
//���������� �ʱⰪ�� �������� ������ 0���� �ʱ�ȭ�ȴ�.
//������ ���λ縦 ����  �߰��ؼ� ���
//int -> ���λ� n -> ndata
//long -> 1
//float -> f
//������ -> p
//�������� ->g_
int g_num1;
//int mydata
int mydata[5];
void show_arr()
{
	for (int i = 0; i < 5; i++) {
		printf("�迭�� ����� ��=>%d\n", mydata[i]);
	}
}
void vartest()
{
	printf("vartest���� �����������:%d\n", g_num1);
	g_num1 = 300;
}
int main_public() {
	vartest();
	printf("main���� �����������:%d\n", g_num1);
	g_num1 = 500;
	printf("main���� �����������:%d\n", g_num1);

	show_arr();
	mydata[2] = 200;
	printf("************\n");
	show_arr();
	return 0;
}
