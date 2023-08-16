import sys
input = sys.stdin.readline

n, m = map(int, input().split())
name = set()
res = []
cnt = 0
for _ in range(n):
    name.add(input().rstrip())
for _ in range(m):
    tmp = input().rstrip()
    if tmp in name:
        res.append(tmp)
res.sort()
print(len(res))
print(*res, sep='\n')