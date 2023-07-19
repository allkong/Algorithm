import sys
input = sys.stdin.readline

n = int(input())
n_num = list(map(int, input().split()))
n_num.sort()
m = int(input())
m_num = list(map(int, input().split()))

def binary_search(array, target, start, end):
    if start > end:
        return 0
    mid = (start + end) // 2
    if array[mid] == target:
        return 1
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    else:
        return binary_search(array, target, mid + 1, end)

for num in m_num:
    print(binary_search(n_num, num, 0, n - 1))