#오답코드
an1 = list(input())
an2 = list(input())
ans = count = 0
for i in range(len(an1)):
    for j in range(len(an2)):
        if an1[i] != an2[j]:
            ans += 1
            if ans == len(an2):
                ans = 0
                count += 1
    ans = 0
print(count * 2)