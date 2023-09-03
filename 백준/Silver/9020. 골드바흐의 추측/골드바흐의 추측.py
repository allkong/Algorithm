import sys
input = sys.stdin.readline

t = int(input())

def prime_number(x):
    if x == 1:
        return False
    for i in range(2, int(x ** 0.5) + 1):
        if x % i == 0:
            return False
    return True

for _ in range(t):
    n = int(input())
    a, b = 0, n
    for i in range(2, n // 2 + 1):
        if prime_number(i) and prime_number(n - i):
            if b - a > n - i * 2:
                a, b = i, n - i

    print(a, b)