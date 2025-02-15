import sys
import heapq
input = sys.stdin.readline

def sync(heap):
    # 유효하지 않은 원소 삭제
    while heap and not visited[heap[0][1]]:
        heapq.heappop(heap)

t = int(input())

for _ in range(t):
    k = int(input()) # Q에 적용할 연산의 개수
    minheap = [] # 최소 힙 (최솟값 추출용)
    maxheap = [] # 최대 힙 (최댓값 추출용, 음수 저장)
    visited = {} # 삽입된 원소의 유효 여부 체크 (key: 인덱스, value: 유효 여부)

    for key in range(k):
        command, n = input().split()

        # I n: 정수 n을 Q에 삽입
        if command == 'I':
            heapq.heappush(minheap, (int(n), key))
            heapq.heappush(maxheap, (-int(n), key))
            visited[key] = True

        elif command == 'D':
            # D 1: Q에서 최댓값 삭제
            if n == '1':
                sync(maxheap)
                if maxheap:
                    # 삭제하려는 원소의 key 유효 체크
                    visited[maxheap[0][1]] = False
                    heapq.heappop(maxheap)

            # D -1: Q에서 최솟값 삭제
            elif n == '-1':
                sync(minheap)
                if minheap:
                    # 삭제하려는 원소의 key 유효 체크
                    visited[minheap[0][1]] = False
                    heapq.heappop(minheap)
    
    sync(minheap)
    sync(maxheap)
    
    if minheap and maxheap:
        print(-maxheap[0][0], minheap[0][0])
    else:
        print('EMPTY')