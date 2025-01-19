import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    clothes = {}

    # 의상 딕셔너리 채우기
    n = int(input())
    for _ in range(n):
        # 의상의 이름과 종류
        name, category = input().split()

        # 입력받은 의상을 의상 딕셔너리에 추가한다
        if category in clothes:
            clothes[category] += [name]
        else:
            clothes[category] = [name]

    # 종류별 의상 개수 구하기
    # 각 종류마다 (종류별 의상 개수 + 1)을 모두 곱한 뒤 -1한 값이 경우의 수
    count = 1
    for value in clothes.values():
        count *= len(value) + 1
    
    print(count - 1)