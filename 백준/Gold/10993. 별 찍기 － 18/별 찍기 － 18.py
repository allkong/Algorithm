def draw_star(n):
    stars = [] # 별 삼각형을 저장하는 배열
    
    # 1이면 제일 안에 있는 별 하나를 반환한다
    if n == 1:
        return '*'
    
    # 기존 별 모양을 감싸는 테두리를 만든다
    prev_star = draw_star(n - 1)

    # n이 홀수이면 테두리는 삼각형 모양이다
    if n % 2 != 0:
        prev_top = len(prev_star[0]) # 이전 삼각형에서 삼각형 밑부분의 별 개수 (역삼각형의 첫 번째 줄)

        # 윗쪽 테두리
        stars.append(' ' * (prev_top + 1) + '*' + ' ' * (prev_top + 1)) # 상단 꼭짓점
        for idx in range(1, len(prev_star)):
            stars.append(' ' * (prev_top + 1 - idx) + '*' + ' ' * (2 * idx - 1) + '*' + ' ' * (prev_top + 1 - idx))

        # 가운데 테두리
        for idx in range(len(prev_star)):
            # 이전 삼각형의 별 테두리의 앞뒤를 별로 감싸준다
            stars.append(' ' * ((prev_top + 1) // 2 - idx) + '*' + ' ' * idx + prev_star[idx] + ' ' * idx + '*' + ' ' * ((prev_top + 1) // 2 - idx))
        
        # 아랫쪽 테두리
        stars.append('*' * (prev_top + pow(2, n)))

    # n이 짝수이면 테두리는 역삼각형 모양이다
    else:
        prev_bottom = len(prev_star[-1]) # 이전 삼각형에서 삼각형 밑부분의 별 개수

        # 윗쪽 테두리
        stars.append('*' * (prev_bottom + pow(2, n)))

        # 가운데 테두리
        for idx in range(len(prev_star)):
            # 이전 삼각형의 별 테두리의 앞뒤를 별로 감싸준다
            stars.append(' ' * (idx + 1)  + '*' + ' ' * (prev_bottom // 2 - idx) + prev_star[idx] + ' ' * (prev_bottom // 2 - idx) + '*' + ' ' * (idx + 1))
        
        # 아랫쪽 테두리
        for idx in range(1, len(prev_star)):
            stars.append(' ' * (len(prev_star) + idx) + '*' + ' ' * (prev_bottom - idx * 2) + '*' + ' ' * (len(prev_star) + idx))
    
        stars.append(' ' * (prev_bottom + 1) + '*' + ' ' * (prev_bottom + 1)) # 하단 꼭짓점

    # 현재의 별 모양을 반환한다
    return stars

n = int(input())
for line in draw_star(n):
    print(line.rstrip())