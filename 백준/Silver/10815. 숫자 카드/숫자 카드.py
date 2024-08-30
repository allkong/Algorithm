import sys
input = sys.stdin.readline

card_count = int(input())
cards = list(map(int, input().split()))
target_count = int(input())
targets = list(map(int, input().split()))

# 리스트보다 딕셔너리(해시 테이블)이 더 빠르다
# 리스트: O(n), 딕셔너리: O(1)
check = {card : 0 for card in cards}

for target in targets:
    print(1 if target in check else 0, end=' ')