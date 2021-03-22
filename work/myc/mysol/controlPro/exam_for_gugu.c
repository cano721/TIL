#include <stdio.h>

int main_exam_gugu() {
	printf("2~9단까지 구구단 출력\n");
	for (int i = 2; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			printf("%d * %d = %d\n", i, j, i * j);
		}
		printf("\n");
	}
	return 0;
}