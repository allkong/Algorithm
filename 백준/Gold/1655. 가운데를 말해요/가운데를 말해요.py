import sys
import heapq
input = sys.stdin.readline

N = int(input())
left = [] # 최대 힙
right = [] # 최소 힙

# 처음 입력값이 mid가 된다
# 짝수개면 더 작은 수가 답이 되므로 mid는 left에 담는다
mid = int(input())
heapq.heappush(left, -mid)
print(mid)

for i in range(N - 1):
    num = int(input())

    # 숫자가 mid 이하면 left(최대 힙)에 삽입한다
    if num <= mid:
        heapq.heappush(left, -num)
    # 숫자가 mid보다 크면 right(최소 힙)에 삽입한다
    else:
        heapq.heappush(right, num)

    # 힙 밸런스 조정
    # mid를 기준으로 left 개수보다 right 개수가 더 많으면
    # right 값을 하나 빼서 left로 이동한다
    if len(left) < len(right):
        heapq.heappush(left, -heapq.heappop(right))
    # right 개수 + 1 보다 left 개수가 더 많으면
    # left 값을 하나 빼서 right로 이동한다
    elif len(left) > len(right) + 1:
        heapq.heappush(right, -heapq.heappop(left))

    mid = -left[0]
    print(mid)    