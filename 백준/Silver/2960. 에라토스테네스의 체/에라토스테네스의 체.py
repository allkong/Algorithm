import sys
input = sys.stdin.readline

n, k = map(int, input().split())
num = [i for i in range(2, n + 1)]

while num:
    p = num.pop(0)
    k -= 1

    if k == 0:
        print(p)
        break

    for i in range(p * 2, n + 1, p):
        if i in num:
            num.pop(num.index(i))
            k -= 1

            if k == 0:
                print(i)
                exit(0)