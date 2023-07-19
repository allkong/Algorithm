n, m = map(int, input().split())
array = list(map(int, input().split()))
ans = 0

def binary_search(start, end):
    global ans
    total = 0
    if start > end:
        return ans
    mid = (start + end) // 2
    for a in array:
        if a > mid:
            total += a - mid
    if total < m:
        return binary_search(start, mid - 1)
    else:
        ans = mid
        return binary_search(mid + 1, end)

print(binary_search(0, max(array)))