n = int(input())
cnt = 0
for i in range(1, n + 1):
    if i < 100:
        cnt += 1
    else:
        seq = list(map(int, str(i)))
        if seq[1] - seq[0] == seq[2] - seq[1]:
            cnt += 1
print(cnt)