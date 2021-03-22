//******** 주차관리시스템**********
//
//1. 주차
//
//2. 출차
//
//3. 주차현황 출력
//
//4. 층별 빈 주차 공간 확인하기
//
//0. 종료

#include <stdio.h>
#include <stdlib.h>
void parking(int** p_area);
void exit_car(int** p_area);
void printall(int** p_area);
void printone(int** p_area, int a);
void park_check_area(int** p_area);

int main() {
	//동적배열 선언
	int** p_area = malloc(sizeof(int*) * 3);
	for (int i = 0; i < 3; i++)
	{
		p_area[i] = malloc(sizeof(int) * 10);
	}
	//배열 초기값
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
		//주차가능공간 구하기
		
		printf("**********주차 관리시스템**********\n");
		printf("1. 주차\n");
		printf("2. 출차\n");
		printf("3. 주차현황 출력\n");
		printf("4. 층별 빈 주차 공간 확인하기\n");
		printf("0. 종료\n");
		printf("**********************************\n");
		scanf_s("%d", &num);
		switch (num)
		{
			case 1:
				park_check_area(p_area); //주차가능공간 출력
				parking(p_area);
				break;
			case 2:
				exit_car(p_area);
				break;
			case 3:
				printall(p_area);
				break;
			case 4:
				printf("확인할 층 수를 입력해주세요(1,2,3)\n");
				scanf_s("%d", &floor);
				printone(p_area,floor);
				break;
			case 0:
				printf("시스템 종료합니다..\n");
				check = 0;
				break;
			default:
				printf("잘못입력하셨습니다.\n");
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
			printf("최대층입니다.\n");
			printf("주차할 위치번호 입력(1층으로 0, 취소 -1):");
			scanf_s("%d", &num);
		}
		else {
			printf("주차할 위치번호 입력(다른층 0, 취소 -1):");
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
			printf("취소되었습니다.\n");
			break;
		}
		else if (num == 10 || num % 10 > 0) {
			if(p_area[p_floor - 1][num - 1]>0){
				printf("주차된 차량이 존재합니다.\n 다시 해주십시오.\n");
			}
			else {
				printf("차량번호 입력:");
				scanf_s("%d", &p_area[p_floor - 1][num - 1]);
				printf("주차되었습니다!\n");
				break;
			}
		}
		else {
			printf("잘못 입력하셨습니다..");
		}
	}
}

void exit_car(int** p_area) {
	int car_num = 0;
	int check = 0;
	printf("출차하실 차량번호를 입력해주세요:");
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
		printf("차량번호가 없습니다. 다시 시도해주세요\n");
	}
}

void printall(int** p_area) {
	for (int i = 0; i < 3; i++) {
		printf("[b%d층]==============\n",i+1);
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
	printf("[b%d층]==============\n", a);
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
	printf("주차가능공간:B1층[%d대],B2층[%d대],B3층[%d대]\n",park_area[0], park_area[1], park_area[2]);
}