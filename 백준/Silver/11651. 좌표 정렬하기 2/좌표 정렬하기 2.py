import sys

n = int(input())
lst = []

for _ in range(n):
    lst.append(list(map(int, sys.stdin.readline().split())))

lst.sort(key = lambda x : (x[1], x[0]))

for ls in lst:
    for l in ls:
        print(l, end=' ')
    print()