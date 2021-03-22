#include <stdio.h>

int main_multi() {
	// * * * * *
	// * * * * *
	// * * * * *
	// * * * * *
	// * * * * *
	int i = 0,row=0;
	while (row < 5) {
		i = 0;
		while (i < 5) {
			printf("*\t");
			i++;
		}
		printf("\n");
		row++;
	}
	return 0;
}