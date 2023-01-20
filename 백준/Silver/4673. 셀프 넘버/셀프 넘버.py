num = list(range(1, 10001))
for i in range(1, 10001):
    t = 0
    for j in str(i):
        t += int(j)
    s = i + t
    if s in num:
        num.remove(s)
print(*num, sep='\n')
