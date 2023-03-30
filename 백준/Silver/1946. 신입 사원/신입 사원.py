import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    rank = [[0, 0]] * n
    for i in range(n):
        rank[i] =  list(map(int, input().split()))
    
    rank.sort()
    
    tmp, cnt = n+1, 0
    for d, i in rank:
        if i < tmp:
            cnt += 1
            tmp = i
    
    print(cnt)