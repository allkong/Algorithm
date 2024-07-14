import sys
from collections import deque
input = sys.stdin.readline

size, target = map(int, input().split())
#  1 ~ n 사람 구성
queue = deque(range(1, size+1))
josephus_permutation = []

# 모든 사람이 제거될 때까지 계속한다
while queue:
    # target-1번만큼 왼쪽으로 큐를 이동시킨다
    queue.rotate(-target+1)
    josephus_permutation.append(str(queue.popleft()))

print('<' + ', '.join(josephus_permutation) + '>')