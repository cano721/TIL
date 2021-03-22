//******** ���������ý���**********
//
//1. ����
//
//2. ����
//
//3. ������Ȳ ���
//
//4. ���� �� ���� ���� Ȯ���ϱ�
//
//0. ����

#include <stdio.h>
#include <stdlib.h>
void parking(int** p_area);
void exit_car(int** p_area);
void printall(int** p_area);
void printone(int** p_area, int a);
void park_check_area(int** p_area);

int main() {
	//�����迭 ����
	int** p_area = malloc(sizeof(int*) * 3);
	for (int i = 0; i < 3; i++)
	{
		p_area[i] = malloc(sizeof(int) * 10);
	}
	//�迭 �ʱⰪ
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 10; j++) {
			p_area[i][j] = 0;
		}
	}
	int check = 1;
	while (check)
	{
		int num = 0;
		int floor = 0;
		//�������ɰ��� ���ϱ�
		
		printf("**********���� �����ý���**********\n");
		printf("1. ����\n");
		printf("2. ����\n");
		printf("3. ������Ȳ ���\n");
		printf("4. ���� �� ���� ���� Ȯ���ϱ�\n");
		printf("0. ����\n");
		printf("**********************************\n");
		scanf_s("%d", &num);
		switch (num)
		{
			case 1:
				park_check_area(p_area); //�������ɰ��� ���
				parking(p_area);
				break;
			case 2:
				exit_car(p_area);
				break;
			case 3:
				printall(p_area);
				break;
			case 4:
				printf("Ȯ���� �� ���� �Է����ּ���(1,2,3)\n");
				scanf_s("%d", &floor);
				printone(p_area,floor);
				break;
			case 0:
				printf("�ý��� �����մϴ�..\n");
				check = 0;
				break;
			default:
				printf("�߸��Է��ϼ̽��ϴ�.\n");
		}
	}
	for (int i =0; i<3; i++)
	{
		free(p_area[i]);
	}
	free(p_area);
}

void parking(int** p_area) {
	int num = 0;
	int p_floor = 1;
	printone(p_area, p_floor);
	while (1) {
		if (p_floor == 3) {
			printf("�ִ����Դϴ�.\n");
			printf("������ ��ġ��ȣ �Է�(1������ 0, ��� -1):");
			scanf_s("%d", &num);
		}
		else {
			printf("������ ��ġ��ȣ �Է�(�ٸ��� 0, ��� -1):");
			scanf_s("%d", &num);
		}
		if (num == 0) {
			if (p_floor == 3) {
				p_floor = 1;
				printone(p_area, p_floor);
			}
			else {
				p_floor += 1;
				printone(p_area, p_floor);
			}
		}
		else if(num == -1) {
			printf("��ҵǾ����ϴ�.\n");
			break;
		}
		else if (num == 10 || num % 10 > 0) {
			if(p_area[p_floor - 1][num - 1]>0){
				printf("������ ������ �����մϴ�.\n �ٽ� ���ֽʽÿ�.\n");
			}
			else {
				printf("������ȣ �Է�:");
				scanf_s("%d", &p_area[p_floor - 1][num - 1]);
				printf("�����Ǿ����ϴ�!\n");
				break;
			}
		}
		else {
			printf("�߸� �Է��ϼ̽��ϴ�..");
		}
	}
}

void exit_car(int** p_area) {
	int car_num = 0;
	int check = 0;
	printf("�����Ͻ� ������ȣ�� �Է����ּ���:");
	scanf_s("%d", &car_num);
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 10; j++) {
			if (car_num == p_area[i][j]) {
				check = 1;
				p_area[i][j] = 0;
			}
		}
	}
	if (check == 0) {
		printf("������ȣ�� �����ϴ�. �ٽ� �õ����ּ���\n");
	}
}

void printall(int** p_area) {
	for (int i = 0; i < 3; i++) {
		printf("[b%d��]==============\n",i+1);
		for (int j = 0; j < 10; j++)
		{
			if (*(p_area[i] + j) == 0) {
			printf("[%d]\t", j+1);
			}
		else {
			printf("[%04d]\t", p_area[i][j]);
			}
		}
		printf("\n");
	}
}

void printone(int** p_area,int a) {
	printf("[b%d��]==============\n", a);
	for (int i = 0; i < 10; i++) {
		if (*(p_area[a - 1] + i) == 0) {
			printf("[%d]\t", i+1);
		}
		else {
			printf("[%04d]\t", p_area[a - 1][i]);
		}
	}
	printf("\n");
}

void park_check_area(int** p_area) {
	int park_area[3] = { 10, 10, 10 };
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 10; j++) {
			if (*(p_area[i] + j) > 0) {
				park_area[i] -= 1;
			}
		}
	}
	printf("�������ɰ���:B1��[%d��],B2��[%d��],B3��[%d��]\n",park_area[0], park_area[1], park_area[2]);
}