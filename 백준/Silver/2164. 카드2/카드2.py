from collections import deque

n = int(input())
card = deque(range(1, n + 1))

while True:
    if len(card) == 1:
        break

    card.popleft()
    card.append(card.popleft())

print(card[0])