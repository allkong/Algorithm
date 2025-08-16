import sys
from itertools import product
input = sys.stdin.readline

element_count, select_count = map(int, input().split()) # 전체 원소 개수, 선택할 원소 개수
# 중복 순열
# 전체 원소에서 선택할 숫자만큼 숫자를 뽑는다
for select_element in product(range(1, element_count+1), repeat=select_count):
    print(*select_element)