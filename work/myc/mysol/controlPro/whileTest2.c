#define _CRT_SECURE_NO_WARNINGS
# include <stdio.h>
#include <stdbool.h>

int main() {
	int number = 0, sum = 0, idx = 0;
	char buffer[20];
	while (true) {
		printf("숫자를 입력하세요.(종료는 q):\n");
		gets_s(buffer, sizeof(buffer));
		number = 0, idx = 0;
		while (true) 
		{
			if (buffer[idx] >= '0' && buffer[idx] <= '9') {
				number *= 10;
				number += buffer[idx] - '0';
				idx++;
				if (buffer[idx] == '\0') {
					break;
				}
			}
			else {
				idx = -1;
				break;
			}
		}
		if (idx == -1)
		{
			if (buffer[0] == 'q' && buffer[1] == '\0')
			{
				break;
			}
			else
			{
				printf("잘못입력하셨습니다..");
				continue;
			}
		}
		else
		{
			sum += number;
		}

	}
	printf("합계는:%d", sum);
	return 0;
}