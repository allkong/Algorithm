import sys
input = sys.stdin.readline

def cut_tree(start, end):
    global max_height

    while start <= end:
        total = 0 # 집으로 가져갈 나무의 길이
        mid = (start + end) // 2 # 중간지점 찾기
        
        # 나무를 하나씩 살펴본다
        for tree in trees:
            # 현재 나무가 mid보다 높으면 잘리는 나무 높이만큼 가져간다
            if tree > mid:
                total += tree - mid
        # 현재까지 잘린 나무 길이 총합이 집으로 가져갈 나무의 최소 길이보다 작다면
        # 더 많이 자를 수 있도록 다음엔 더 아래에서 자른다
        if total < min_length:
            end = mid - 1
        # 현재까지 잘린 나무 길이 총합이 집으로 가져갈 나무의 최소 길이보다 크다면
        # 현재까지 잘린 나무 길이 총합을 저장하고
        # 더 조금 잘라도 가능한지 다음엔 더 위에서 자른다
        else:
            max_height = mid
            start = mid + 1

    return max_height

tree_count, min_length = map(int, input().split()) # 나무의 수, 집으로 가져갈 나무의 최소 길이
trees = list(map(int, input().split())) # 나무의 높이
max_height = 0
print(cut_tree(0, max(trees)))