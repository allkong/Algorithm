n = int(input())
for i in range(1, n+1):
    s = i + sum(map(int, str(i)))
    if s == n:
        print(i)
        break
    if i == n:
        print(0)