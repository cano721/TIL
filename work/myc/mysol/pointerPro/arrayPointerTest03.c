#include <stdio.h>
int main_arrtest03() {
	int arr[3] = { 0 }; //�迭����
	int* parr = arr;//�����Ϳ� �迭��(ù��° ����ּ�)����

	*parr = 10; //arr�� ù ��° ��ҿ� 10 ����
	*(parr + 1) = 20;
	parr[2] = 30; //[]�� �̿��ϸ� �迭��ó�� ����� �� �ִ�.
	for (int i = 0; i < 5; i++) {
		printf("%d\n", parr[i]);
	}
	//������
	printf("%d\n", sizeof(arr));
	printf("%d\n", sizeof(parr));
	return 0;
}