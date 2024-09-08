import sys
input = sys.stdin.readline

def record_bluray(start, end):
    global min_bluray_size

    while start <= end:
        mid = (start + end) // 2 # 블루레이 크기
        current_bluray = 0 #  현재 블루레이에 넣은 강의 길이 합
        bluray_count = 1 # 블루레이 개수

        for lesson in lessons:
            # 현재 블루레이에 현재 강의를 추가한 길이가 mid보다 크다면
            # 다음 블루레이로 교체한다
            if current_bluray + lesson > mid:
                bluray_count += 1
                # 이미 블루레이 개수가 조건에 안맞으면 더 계산할 필요 없다
                if bluray_count > min_bluray_count:
                    break
                current_bluray = 0
            # 블루레이에 해당 강의를 추가한다
            current_bluray += lesson
        
        # 사용한 블루레이 개수가 사용해야 하는 블루레이 개수보다 적거나 같으면 블루레이 크기를 더 작게 잡아서 시도한다
        if bluray_count <= min_bluray_count:
            min_bluray_size = mid
            end = mid - 1
        # 사용한 블루레이 개수가 사용해야 하는 블루레이 개수보다 많으면 블루레이를 더 적게 써야 한다
        # 즉, 블루레이 하나의 크기를 더 크게 잡아야 한다
        else:
            start = mid + 1

    return min_bluray_size

lesson_count, min_bluray_count = map(int, input().split()) # 강의 수, 블루레이 수
lessons = list(map(int, input().split())) # 강의의 길이
min_bluray_size = sys.maxsize # 가능한 블루레이 크기 최솟값

print(record_bluray(max(lessons), sum(lessons)))