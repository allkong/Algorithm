import sys
input = sys.stdin.readline

h, w = map(int, input().split())
blocks = list(map(int, input().split()))

def left_check(block, i):
    for i in range(i-1, -1, -1):
        if block < blocks[i]:
            block = blocks[i]
    return block

def right_check(block, i):
    for i in range(i+1, w):
        if block < blocks[i]:
            block = blocks[i]
    return block

water = 0

for i in range(w):
    block = blocks[i]
    l = left_check(block, i)
    r = right_check(block, i)
    m = min(l, r)
    if m:
        water += m - block

print(water)