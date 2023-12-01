def solution(code):
    ret = ''
    mode = 0
    for idx in range(len(code)):
        if code[idx] == '1':
            mode ^= 1
        elif idx % 2 == mode:
            ret += code[idx]
    return ret if ret else 'EMPTY'