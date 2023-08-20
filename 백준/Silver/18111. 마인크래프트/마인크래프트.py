import sys
input = sys.stdin.readline

n, m, b = map(int, input().split())
land = [list(map(int, input().split())) for _ in range(n)]
ans = sys.maxsize
height = 0

for i in range(257):
    take_block = 0
    use_block = 0
    for x in range(n):
        for y in range(m):
            if land[x][y] > i:
                take_block += land[x][y] - i
            else:
                use_block += i - land[x][y]
            
    if take_block + b >= use_block:
        tmp = take_block * 2 + use_block
        if tmp <= ans:
            ans = tmp
            height = i

print(ans, height)