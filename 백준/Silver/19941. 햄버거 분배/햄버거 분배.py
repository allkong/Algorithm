import sys
input = sys.stdin.readline

n, k = map(int, input().split())
li = input()
h_li = []
p_li = []
cnt = 0
for i in range(n):
    if li[i] == 'H':
        h_li.append(i)
    else:
        p_li.append(i)

for h in h_li:
    for p in p_li:
        if abs(p - h) <= k:
            cnt += 1
            p_li.remove(p)
            break

print(cnt)