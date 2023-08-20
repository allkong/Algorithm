import sys
input = sys.stdin.readline

def roundoff(num):
    return int(num) + (1 if num - int(num) >= 0.5 else 0)

n = int(input())
if not n:
    print(0)
else:
    level = [int(input()) for _ in range(n)]
    level.sort()
    ex = roundoff(n * 0.15)
    ans = sum(level[ex:n - ex])/(n - ex * 2)
    print(roundoff(ans))