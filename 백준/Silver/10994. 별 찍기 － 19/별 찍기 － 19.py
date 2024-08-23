def draw_star(n):
    stars = [] # 별을 저장하는 배열

    # 1이면 제일 안에 있는 별을 반환한다
    if n == 1:
        return '*'
    
    # 4 * (n - 1) + 1
    size = 4 * n - 3

    # 처음 두 줄을 출력한다
    stars.append('*' * size)
    stars.append('*' + ' ' * (size - 2) + '*')

    # 이전 별 테두리의 앞뒤를 별로 감싸준다
    for line in draw_star(n - 1):
        stars.append('* ' + line + ' *')

    # 마지막 두 줄을 출력한다
    stars.append('*' + ' ' * (size - 2) + '*')
    stars.append('*' * size)

    # 현재의 별 모양 배열을 반환한다
    return stars

n = int(input())
print(*draw_star(n), sep='\n')