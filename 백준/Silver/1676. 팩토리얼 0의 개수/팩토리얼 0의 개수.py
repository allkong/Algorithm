import sys
input = sys.stdin.readline

def factorial(n):
    if n == 1 or n == 0:
        return 1
    return n * factorial(n-1)

n = int(input())
num = str(factorial(n))
cnt = 0
for i in range(len(num)-1, -1, -1):
    if num[i] == '0':
        cnt += 1
    else:
        break

print(cnt)