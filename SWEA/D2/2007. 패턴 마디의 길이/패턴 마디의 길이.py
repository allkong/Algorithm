T = int(input())
for tc in range(1, T+1):
    s = input()
    for i in range(1, 10):
        if s[:i] == s[i:2*i]:
            print(f'#{tc}', i)
            break