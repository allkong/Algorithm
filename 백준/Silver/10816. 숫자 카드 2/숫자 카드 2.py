from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

# 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
def count_by_range(array, left_value, right_value):
    # 정렬된 순서를 유지하면서 배열에 right_value를 삽입할 가장 오른쪽 인덱스를 반환
    right_index = bisect_right(array, right_value)
    # 정렬된 순서를 유지하면서 배열에 left_value를 삽입할 가장 왼쪽 인덱스를 반환
    left_index = bisect_left(array, left_value)
    return right_index - left_index

card_count = int(input())
cards = list(map(int, input().split()))
cards.sort()
target_count = int(input())
targets = list(map(int, input().split()))

for target in targets:
    print(count_by_range(cards, target, target), end=' ')