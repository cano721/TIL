#include <stdio.h>

//간단한 관리프로그램을 작성하기 위한 스킬
// UI+로직
//메뉴구성
//int printMenu_eef(void) {
//	int inputValue = 0; //선택한 메뉴의 값을 저장
//	system("cls"); //화면클리어
//	printf("**************학사관리시스템**************\n");
//	printf("1. 새로작성\t2. 조회\t3. 항목검색\t4. 종료\t\n");
//	scanf_s("%d", &inputValue);
//	return inputValue;
//}
//
//
//int main_menufunc() {
//	//메뉴 이벤트 루프
//	//사용자의 선택에 따라 반복해서 실행하는 구조를 이벤트 루프라고 부른다.
//	//사용자가 입력한 값에 따라 특정 기능을 반복해서 수행하도록 구현
//	//4번을 입력하면 종료, 나머지는 작업
//	int menuIndex = 0;
//	while ((menuIndex = printMenu())!=4) {
//		switch (menuIndex) {
//		case 1: //1. 새로작성을 선택
//			//1번 기능에 알맞은 함수를 호출해서 작업
//			printf("1. 새로작성\n");
//			break;
//		case 2: //1. 새로작성을 선택
//		//1번 기능에 알맞은 함수를 호출해서 작업
//			printf("2. 조회\n");
//			break;
//		case 3: //1. 새로작성을 선택
//		//1번 기능에 알맞은 함수를 호출해서 작업
//			printf("3. 항목검색\n");
//			break;
//		default:
//			printf("잘못선택");
//		}
//
//	}
//	return 0;
//}