#include <stdio.h>

int std[50][5];
int idx = 0;
int avers[5];
int stdAvers[50];
int printMenu(void) {
	int inputValue = 0;
	printf("**************학사관리시스템**************\n");
	printf("1. 학생등록\t2. 전체학생조회\t3. 학생검색\t4. 과목별 평균점수\t5. 학생별 평균\t6. 종료\n");
	scanf_s("%d", &inputValue);
	return inputValue;
}

void res() {
	printf("**************학생을 등록하세요**************\n");
	printf("학생명:");
	scanf_s(" %c",&std[idx][0],1);
	printf("Python:");
	scanf_s("%d", &std[idx][1]);
	printf("C:");
	scanf_s("%d", &std[idx][2]);
	printf("Raspberry:");
	scanf_s("%d", &std[idx][3]);
	printf("MongoDb:");
	scanf_s("%d", &std[idx][4]);
	idx++;
}

void searchall(){
	for (int i = 0; i < 50; i++) {
		if (std[i][0] != '\0') {
			printf("학생명:%c\t", std[i][0]);
			printf("Python:%d\t", std[i][1]);
			printf("C:%d\t", std[i][2]);
			printf("Raspberry:%d\t", std[i][3]);
			printf("MongoDb:%d\t\n", std[i][4]);
		}
	}
}
void searchone() {
	printf("찾으실 학생명을 입력해주세요\n");
	char stdName = '0';
	scanf_s(" %c",&stdName,1);
	for (int i = 0; i < 50; i++) {
		if (std[i][0] == stdName) {
			printf("학생명:%c\t", std[i][0]);
			printf("Python:%d\t", std[i][1]);
			printf("C:%d\t", std[i][2]);
			printf("Raspberry:%d\t", std[i][3]);
			printf("MongoDb:%d\t\n", std[i][4]);
		}
	}
}

void aver() {
	for (int i = 0; i < idx; i++) {
		avers[0] += std[i][1];
		avers[1] += std[i][2];
		avers[2] += std[i][3];
		avers[3] += std[i][4];
	}
	printf("Python평균점수:%d\t", avers[0] / idx);
	printf("C평균점수:%d\t", avers[1] / idx);
	printf("Raspberry평균점수:%d\t", avers[2] / idx);
	printf("MongoDb평균점수:%d\t\n", avers[3] / idx);
}

void stdAver() {
	for (int i = 0; i < idx; i++) {
		for (int j = 1; j < 5; j++){
			stdAvers[i] += std[i][j];
		}
	}
	for (int i = 0; i < idx; i++) {
		printf("%c학생의 평균점수:%d\n", std[i][0], stdAvers[i] / 4);
	}
}


int main() {
	int menuIndex = 0;
	while ((menuIndex = printMenu()) != 6)
	{
		switch (menuIndex) {
		case 1:
			res();
			break;
		case 2:
			searchall();
			break;
		case 3:
			searchone();
			break;
		case 4:
			aver();
			break;
		case 5:
			stdAver();
			break;
		default:
			printf("잘못선택");
		}
	}
	printf("프로그램을 종료합니다...");
	return 0;
}