a = int(input())
b = int(input())
c = int(input())

# 풀이1
ans = str(a * b * c)
num = "0123456789"
for n in num:
    cnt = 0
    for a in ans:
        if a == n:
            cnt += 1
    print(cnt)

# 풀이2
res = list(str(a*b*c))
for i in range(10):
    print(res.count(str(i)))