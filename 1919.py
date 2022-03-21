str1 = input()
str2 = input()
for s1 in str1:
    for s2 in str2:
        if s1 == s2:
            str1 = str1.replace(s1, ' ', 1)
            str2 = str2.replace(s2, ' ', 1)
            break
cnt = 0
for s1 in str1:
    if s1 != ' ':
        cnt += 1
for s2 in str2:
    if s2 != ' ':
        cnt += 1
print(cnt)