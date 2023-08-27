n = int(input())
m = int(input())
s = input()

start, end = 0, 0
cnt = 0

while end < m:
    if s[end:end + 3] == 'IOI':
        end += 2
        if end - start == 2 * n:
            cnt += 1
            start += 2
    else:
        end += 1
        start = end

print(cnt)