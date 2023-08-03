import sys
input = sys.stdin.readline

n, m = map(int, input().split())
house = []
chicken = []
ans = 1e9

for i in range(n):
    tmp = list(map(int, input().split()))
    for j in range(n):
        if tmp[j] == 1:
            house.append((i, j))
        elif tmp[j] == 2:
            chicken.append((i, j))

def distance():
    global ans
    total = 0
    for hx, hy in house:
        d = 2 * n
        for idx in check:
            cx, cy = chicken[idx]
            d = min(d, abs(hx - cx) + abs(hy - cy))
        total += d
    ans = min(ans, total)

def out_chicken(idx, cnt):
    if idx > len(chicken):
        return 
    
    if cnt == m:
        distance()
        return

    check.append(idx)
    out_chicken(idx + 1, cnt + 1)
    check.pop()
    out_chicken(idx + 1, cnt)

check = []
out_chicken(0, 0)
print(ans)