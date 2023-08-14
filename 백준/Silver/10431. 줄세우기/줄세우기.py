import sys
input = sys.stdin.readline

p = int(input())
for _ in range(p):
    res = []
    cnt = 0
    t, *students = map(int, input().split())
    for student in students:
        if not res or max(res) < student:
            res.append(student)
        
        for i in range(len(res)):
            if res[i] > student:
                res.insert(i, student)
                cnt += len(res) - i - 1
                break
    
    print(t, cnt)