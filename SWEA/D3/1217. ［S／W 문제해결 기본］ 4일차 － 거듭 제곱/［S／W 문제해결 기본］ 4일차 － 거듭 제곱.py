def cal(n, m):
    if m == 1:
        return n
    return cal(n, m-1) * n

for _ in range(1, 11):
    t = int(input())
    n, m = map(int, input().split())
    ans = 1
    print(f'#{t}', cal(n, m))