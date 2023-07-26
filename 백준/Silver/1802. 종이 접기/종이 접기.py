import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    paper = input().rstrip()
    n = len(paper)
    flag = True
    while n != 1 and flag:
        for i in range(n//2):
            if i != n-i and paper[i] == paper[n-1-i]:
                print("NO")
                flag = False
                break
        n //= 2
    if flag:
        print("YES")