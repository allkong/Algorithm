def draw_star(n):
    stars = [] # 별 삼각형을 저장하는 배열
    
    # n이 3이면(최소 숫자) 삼각형을 하나 그려서 반환한다
    if n == 3:
        stars.append('  *  ')
        stars.append(' * * ')
        stars.append('*****')
        return stars
    
    # 기존 삼각형에 띄어쓰기를 추가해서 별 배열에 저장한다
    for line in draw_star(n // 2):
        stars.append(' ' * (n // 2) + line + ' ' * (n // 2))
    # 기존 삼각형 두 개를 나란히 배치한다
    for line in draw_star(n // 2):
        stars.append(line + ' ' + line)

    # 현재의 별 모양을 반환한다
    return stars

n = int(input())
print(*draw_star(n), sep='\n')