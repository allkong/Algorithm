import sys
input = sys.stdin.readline

def bubble_sort(li):
    cnt = 0
    for i in range(len(li) - 1, 0, -1):
        for j in range(i):
            if li[j] > li[j + 1]:
                li[j], li[j + 1] = li[j + 1], li[j]
                cnt += 1
    return cnt

p = int(input())
for _ in range(p):
    t, *students = map(int, input().split())
    print(t, bubble_sort(students))