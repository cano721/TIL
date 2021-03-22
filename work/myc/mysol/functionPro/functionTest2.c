#include <stdio.h>

//char getGrade(int score) {
//	char grade = 0;
//	if (score > 100 || score < 0) {
//		grade = 'Q';
//	}
//	else {
//		switch (score / 10) {
//		case 10:
//		case 9:
//			grade = 'A';
//			break;
//		case 8:
//			grade = 'B';
//			break;
//		case 7:
//			grade = 'C';
//			break;
//		case 6:
//			grade = 'D';
//			break;
//		default:
//			grade = 'F';
//			break;
//		}
//	}
//	return grade;
//}
//int main() {
//	int score;
//	printf("학점평가\n");
//	printf("점수입력: ");
//	scanf_s("%d", &score);
//	char grade = getGrade(score);
//	if (grade == 'Q') {
//		printf("잘못입력");
//	}
//	else {
//		printf("학점은 %c입니다.", grade);
//	}
//	return 0;
//}