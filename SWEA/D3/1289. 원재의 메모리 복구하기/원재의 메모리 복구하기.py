T = int(input())
for tc in range(1, T+1):
    origin_memory = list(input()) # 원래 메모리 값
    length = len(origin_memory) # 원래 메모리 값의 길이
    init_memory = ['0'] * length # 초기화 메모리 값
    cnt = 0
    for idx in range(length):
        # 같은 위치의 원래 메모리 값과 초기화 메모리 값이 다르면 수정
        if origin_memory[idx] != init_memory[idx]:
            init_memory[idx:] = [origin_memory[idx]] * (length - idx)
            cnt += 1
    print(f'#{tc}', cnt)