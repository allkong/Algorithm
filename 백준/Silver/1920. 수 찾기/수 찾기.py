import sys
input = sys.stdin.readline

def binary_search(array, target, start, end):
    while start <= end:
        # 중간지점 찾기
        mid = (start + end) // 2
        # 중간지점의 값이 타겟이면 중간지점 반환
        if array[mid] == target:
            return 1
        # 중간지점의 값보다 타겟이 작으면 왼쪽 확인
        elif target < array[mid]:
            end = mid - 1
        # 중간지점의 값보다 타겟이 크면 오른쪽 확인
        else:
            start = mid + 1
    return 0

number_count = int(input())
numbers = list(map(int, input().split()))
numbers.sort()
target_count = int(input())
targets = list(map(int, input().split()))

for target in targets:
    print(binary_search(numbers, target, 0, number_count - 1))