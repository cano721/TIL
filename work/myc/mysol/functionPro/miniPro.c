#include <stdio.h>

int std[50][5];
int idx = 0;
int avers[5];
int stdAvers[50];
int printMenu(void) {
	int inputValue = 0;
	printf("**************�л�����ý���**************\n");
	printf("1. �л����\t2. ��ü�л���ȸ\t3. �л��˻�\t4. ���� �������\t5. �л��� ���\t6. ����\n");
	scanf_s("%d", &inputValue);
	return inputValue;
}

void res() {
	printf("**************�л��� ����ϼ���**************\n");
	printf("�л���:");
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
			printf("�л���:%c\t", std[i][0]);
			printf("Python:%d\t", std[i][1]);
			printf("C:%d\t", std[i][2]);
			printf("Raspberry:%d\t", std[i][3]);
			printf("MongoDb:%d\t\n", std[i][4]);
		}
	}
}
void searchone() {
	printf("ã���� �л����� �Է����ּ���\n");
	char stdName = '0';
	scanf_s(" %c",&stdName,1);
	for (int i = 0; i < 50; i++) {
		if (std[i][0] == stdName) {
			printf("�л���:%c\t", std[i][0]);
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
	printf("Python�������:%d\t", avers[0] / idx);
	printf("C�������:%d\t", avers[1] / idx);
	printf("Raspberry�������:%d\t", avers[2] / idx);
	printf("MongoDb�������:%d\t\n", avers[3] / idx);
}

void stdAver() {
	for (int i = 0; i < idx; i++) {
		for (int j = 1; j < 5; j++){
			stdAvers[i] += std[i][j];
		}
	}
	for (int i = 0; i < idx; i++) {
		printf("%c�л��� �������:%d\n", std[i][0], stdAvers[i] / 4);
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
			printf("�߸�����");
		}
	}
	printf("���α׷��� �����մϴ�...");
	return 0;
}