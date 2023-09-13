#include <stdio.h>
#include <string.h>

int is_palindrome(char str[]) {
    int len = strlen(str);
    int left = 0, right = len - 1;

    while (left < right) {
        if (str[left++] != str[right--])
            return 0;
    }
    return 1;
}

int main() {
    char str[100];
    printf("Enter a string: ");
    scanf("%s", str);

    if (is_palindrome(str))
        printf("%s is a palindrome.", str);
    else
        printf("%s is not a palindrome.", str);

    return 0;
}
