import sys
input = sys.stdin.readline

a, b, c = map(int, input().split())

def cal(a, n):
    if n == 1:
        return a % c
    else:
        d = cal(a, n//2)
        if n % 2 == 0:
            return (d * d) % c
        else:
            return (d * d * a) % c

print(cal(a, b))