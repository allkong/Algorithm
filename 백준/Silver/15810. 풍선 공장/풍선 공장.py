import sys
input = sys.stdin.readline

n, m = map(int, input().split()) # 스태프의 수, 풍선의 개수
time = list(map(int, input().split())) # 각 스태프가 풍선 하나를 만드는데 걸리는 시간
time.sort()

start, end = 0, time[-1] * m
ans = end

while start <= end:
    mid = (start + end) // 2 # 풍선이 다 만들어지는 시간
    cnt = 0 # 풍선 개수

    # 현재 mid 기준 풍선이 만들어지는 개수
    for t in time:
        cnt += mid // t

    # 풍선을 충분히 만들었다면 더 짧은 시간으로 탐색
    if cnt >= m:
        ans = mid
        end = mid - 1

    # 풍선을 다 못만들었다면 더 긴 시간으로 탐색
    else:
        start = mid + 1

print(ans)