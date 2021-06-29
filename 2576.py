li = []
for i in range(7):
    a = int(input())
    if a % 2 != 0:
        li.append(a)
if len(li) == 0:
    print(-1)
else:
    print(sum(li))
    print(min(li))