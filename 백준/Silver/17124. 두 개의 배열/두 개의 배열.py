import sys
input = sys.stdin.readline

def binary_search(target):
    start, end = 0, m - 1
    close = 10 ** 9 - 1
    idx = m - 1
    
    while start <= end:
        mid = (start + end) // 2

        # 이전보다 절대값 차이가 더 작다면 close 갱신
        compare = abs(target - B[mid])
        if close > compare:
            close = compare
            idx = mid
        
        elif close == compare and idx > mid:
            close = compare
            idx = mid

        # 타겟이 더 작으면 왼쪽 탐색
        if target < B[mid]:
            end = mid - 1

        # 타겟이 더 크면 오른쪽 탐색
        else:
            start = mid + 1
            
    return B[idx]

T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    A = list(map(int, input().split()))
    B = sorted(map(int, input().split()))
    res = 0

    for a in A:
        res += binary_search(a)
    
    print(res)