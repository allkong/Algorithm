import sys
input = sys.stdin.readline

def allocate_budget(start, end):
    global max_budget

    while start <= end:
        mid = (start + end) // 2 # 상한액
        total_request = 0 # 지방에 배정한 예산 총액

        for request in province_budget:
            # mid보다 적거나 같게 요청했으면 요청한 금액을 그대로 배정한다
            if request <= mid:
                total_request += request
            # mid보다 크게 요청했으면 mid만큼 배정한다
            else:
                total_request += mid
        
        # 현재 mid로 계산한 배정된 예산 총액이 총 예산보다 크다면 mid를 더 적게 잡는다
        if total_request > total_budget:
            end = mid - 1
        # 현재 mid로 계산한 배정된 예산 총액이 총 예산보다 작거나 같다면 mid를 더 크게 잡아도 가능한지 시도한다
        else:
            max_budget = mid
            start = mid + 1
    
    return max_budget

province_count = int(input()) # 지방의 수
province_budget = list(map(int, input().split())) # 각 지방의 예산 요청
total_budget = int(input()) # 총 예산
max_budget = 0 # 배정된 예산들 중 최댓값

print(allocate_budget(1, max(province_budget)))