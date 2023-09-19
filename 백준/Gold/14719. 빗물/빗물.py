import sys
input = sys.stdin.readline

h, w = map(int, input().split())
blocks = list(map(int, input().split()))
water = 0

for i in range(1, w-1):
    block = blocks[i]
    l = max(blocks[:i])
    r = max(blocks[i+1:])
    m = min(l, r)
    if m > blocks[i]:
        water += m - block

print(water)