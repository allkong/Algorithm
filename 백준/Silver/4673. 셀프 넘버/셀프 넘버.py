num = list(range(1, 10001))
for i in range(1, 10001):
    tmp = 0
    for j in str(i):
        tmp += int(j)
    s = i + tmp
    if s in num:
        num.remove(s)
print(*num, sep='\n')
