#include <stdio.h>

int main_pte() {
	int num = 100;//int�� ����
	int* p_num; //�����ͺ���
	int** p_p_num;//2�������� - �����ͺ����� �ּҸ� ����
	
	p_num = &num; //������ ������ int������ �ּҸ� ����
	p_p_num = &p_num;//������ ���� �ּҸ� ���������ͺ����� ����
	printf("num:%d,num�� �ּ�:%p\n", num, &num); // 00CFF8B0
	printf("p_num�� �Ҵ�� �ּ�:%p, p_num�� �Ҵ�� �ּ��� ��:%d, p_num�� �ּ�:%p\n", p_num, *p_num,&p_num); // 00CFF8B0
	printf("p_p_num�� �Ҵ�� �ּ�:%p, p_p_num�� �Ҵ�� �ּ��� ��:%p, p_p_num�� �ּ�:%p\n", p_p_num, *p_p_num,&p_p_num); // 00CFF8B0
	return 0;
}