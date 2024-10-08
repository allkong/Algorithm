import sys
input = sys.stdin.readline

def cut_cable(start, end):
    while start < end - 1:
        cut_count = 0 # 만든 랜선의 개수
        mid = (start + end) // 2

        # 케이블을 하나씩 살펴보며 자를 수 있는 만큼 자른다
        for cable in cables:
            cut_count += cable // mid
        
        # 만든 랜선의 개수가 필요한 랜선의 개수보다 적다면
        # 더 많이 잘라야 한다 (랜선의 길이를 더 짧게 잘라야 한다)
        if cut_count < need_count:
            end = mid
        # 만든 랜선의 개수가 필요한 랜선의 개수 이상이라면
        # 현재 만든 랜선 개수를 저장하고
        # 더 길게 잘라도 가능한지 횟수를 더 적게 잘라본다
        else:
            start = mid

    return start

has_count, need_count = map(int, input().split())
cables = [int(input()) for _ in range(has_count)]

print(cut_cable(1, max(cables) + 1))