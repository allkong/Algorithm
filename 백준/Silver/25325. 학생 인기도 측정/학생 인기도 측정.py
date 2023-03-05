n = int(input())
a = input().split()
student = {string : 0 for string in a}

for _ in range(n):
    like = list(input().split())
    for l in like:
        student[l] += 1

res = sorted(student.items(), key=lambda x:x[1], reverse=True)

for key, value in res:
    print(key, value)
