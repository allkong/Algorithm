import sys
input = sys.stdin.readline

n,m,k = map(int,input().split())

sub = dict()
for _ in range(n):
    s,p = input().split()
    sub[s] = int(p)

res = 0
for _ in range(k):
    s = input().strip()
    res += sub[s]
    sub.pop(s)

scores = sorted(list(sub.values()))
gap = m-k

print(res + sum(scores[:gap]), res + sum(scores[::-1][:gap]))