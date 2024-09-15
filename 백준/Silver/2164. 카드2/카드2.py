from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
cards = deque(range(1, n + 1))

# 카드가 1장 남을 때까지 반복한다
while len(cards) > 1:
    # 제일 위에 있는 카드를 버린다
    cards.popleft()
    # 제일 위에 있는 카드를 제일 아래로 옮긴다
    cards.append(cards.popleft())
# 마지막에 남은 카드를 출력한다
print(cards[0])