#include <stdio.h>

int main(void)
{
    char str[1000002];
    scanf("%s", str);
    int i = 1, cnt = 0;
    while (str[i] != '\0')
    {
        if (str[i] != str[i - 1])
            cnt++;
        i++;
    }
    printf("%d", (cnt + 1) / 2);
}