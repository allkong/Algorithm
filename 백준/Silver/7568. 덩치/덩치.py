import sys
input = sys.stdin.readline

n = int(input())
people = [list(map(int, input().split())) for _ in range(n)] # index 0이 몸무게, 1이 키

for standard in people:
    rank = 1
    for compare in people:
        # 현재 기준인 사람보다 더 덩치가 큰 사람이 있으면 등수가 밀린다
        if standard[0] < compare[0] and standard[1] < compare[1]:
            rank += 1
    print(rank, end=' ')