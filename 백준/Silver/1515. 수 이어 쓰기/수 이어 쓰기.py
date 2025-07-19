import sys
input = sys.stdin.readline

num = input().rstrip()
n, i = 1, 0
while True:
    for s in str(n):
        if num[i] == s:
            i += 1
            if i == len(num):
                print(n)
                exit()
    n += 1