#include <stdio.h>
#include <stdlib.h>
int main_dm() {
	int* plist = NULL;
	//malloc���ϰ� - ���� �Ҵ�� �޸𸮿��� �� ù ��° ����Ʈ�� �ּ� void*
	//malloc�Ű����� - ��û�� �޸��� ������(����Ʈ����)
	//�����Ҵ��̹Ƿ� �����Ҷ����� �ּҰ� �ٲ��.
	plist = malloc(sizeof(int) * 3);//12byte �Ҵ�
	plist[0] = 10;
	plist[1] = 20;
	plist[2] = 30;

	*(((char*)plist) + 12) = 'A';
	free(plist);
	return 0;
}