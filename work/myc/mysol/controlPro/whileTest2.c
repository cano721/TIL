#define _CRT_SECURE_NO_WARNINGS
# include <stdio.h>
#include <stdbool.h>

int main() {
	int number = 0, sum = 0, idx = 0;
	char buffer[20];
	while (true) {
		printf("���ڸ� �Է��ϼ���.(����� q):\n");
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
				printf("�߸��Է��ϼ̽��ϴ�..");
				continue;
			}
		}
		else
		{
			sum += number;
		}

	}
	printf("�հ��:%d", sum);
	return 0;
}