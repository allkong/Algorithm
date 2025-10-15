import sys
import math
input = sys.stdin.readline

k = int(input())
log = math.log2(k)
if 2**(int(log)) == k:
    print(k,0)
    exit()
    
min_size = 2**math.ceil(log)
res = min_size // 2

i = min_size // 2
cnt = 1
while res != k:
    if res + i > k:
        i //= 2
        cnt += 1
    else:
        res += i
        if res + i > k:
            continue
        res += i

print(min_size, cnt)