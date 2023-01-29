import sys

t = int(input())
num = [0]* 10000

for _ in range(t):
    dex = int(sys.stdin.readline())
    num[dex - 1] += 1

for i in range(10000):
    if num[i] != 0:
        for j in range(num[i]):
            print(i + 1)