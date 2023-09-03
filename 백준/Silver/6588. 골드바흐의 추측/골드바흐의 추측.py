import sys
input = sys.stdin.readline

arr = [0] * 1_000_000
def prime_number(x):
    if x == 1:
        return False
    for i in range(2, int(x ** 0.5) + 1):
        if x % i == 0:
            return False
    return True

for i in range(1_000_000):
    if prime_number(i):
        arr[i] = 1

while True:
    n = int(input())
    if n == 0:
        break

    a, b = 3, n - 3
    while True:
        if arr[a] and arr[b]:
            print(n, '=', a, '+', b)
            break

        if a > n // 2:
            print("Goldbach's conjecture is wrong.")
            break
        
        a += 1
        b -= 1