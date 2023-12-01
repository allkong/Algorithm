def solution(code):
    ret = ''
    mode = 0
    for idx in range(len(code)):
        if mode == 0:
            if code[idx] == '1':
                mode = 1
            elif idx % 2 == 0:
                ret += code[idx]
        elif mode == 1:
            if code[idx] == '1':
                mode = 0
            elif idx % 2 != 0:
                ret += code[idx]              
    if not ret:
        ret += 'EMPTY'
    return ret