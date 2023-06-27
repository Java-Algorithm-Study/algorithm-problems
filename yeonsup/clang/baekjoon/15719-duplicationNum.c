#include <stdio.h>

int main()
{
	int num, temp, total = 0, real_total = 0;
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		scanf("%d", &temp);
		total += temp;
		real_total += i;
	}
	printf("%d\n", total - real_total);
	return 0;
}