import sys
input = sys.stdin.readline

n, x = map(int, input().split())
hits = list(map(int, input().split()))

if max(hits) == 0:
    print("SAD")

else:
    window = sum(hits[:x])
    res = window
    cnt = 1
    for i in range(x, n):
        window += hits[i] - hits[i-x]
        if res < window:
            res = window
            cnt = 1
        elif res == window:
            cnt += 1

    print(res)
    print(cnt)