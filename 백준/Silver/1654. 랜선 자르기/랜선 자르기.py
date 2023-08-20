import sys
input = sys.stdin.readline

k, n = map(int, input().split())
cable = [int(input()) for _ in range(k)]
ans = 0

def binary_search(start, end):
    global ans
    cnt = 0
    if start > end:
        return ans
    mid = (start + end) // 2
    for c in cable:
        while c >= mid:
            cnt += 1
            c -= mid
    if cnt < n:
        return binary_search(start, mid - 1)
    else:
        ans = mid
        return binary_search(mid + 1, end)
    
print(binary_search(1, max(cable)))