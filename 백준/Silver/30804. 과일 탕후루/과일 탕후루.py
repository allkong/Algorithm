import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
tanghulu = list(map(int, input().split())) # 처음 입력받은 과일 탕후루
fruits = defaultdict(int) # 현재 꽂혀 있는 과일 탕후루
cnt = 0
s, e = 0, 0

while e < N:
    fruits[tanghulu[e]] += 1

    # 과일 종류가 두 종류 이하가 될 때까지 s를 오른쪽으로 이동시킨다
    while len(fruits) > 2:
        # 가장 왼쪽에 있는 과일을 뺀다
        fruits[tanghulu[s]] -= 1
        # 과일을 빼면서 해당 과일이 현재 탕후루에 없으면 key를 삭제한다
        if fruits[tanghulu[s]] == 0:
            del fruits[tanghulu[s]]
        s += 1

    # 과일 개수의 최댓값을 갱신하다
    cnt = max(cnt, e - s + 1)
    # e를 오른쪽으로 이동시킨다
    e += 1

print(cnt)