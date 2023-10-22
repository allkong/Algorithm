T = int(input())
for tc in range(1, T+1):
    a, b = map(int, input().split())
    sign = ''
    if a < b:
        sign = '<'
    elif a > b:
        sign = '>'
    else:
        sign = '='
    print(f'#{tc}', sign)