import sys
input = sys.stdin.readline

n = int(input())
count = n

for _ in range(n):
    word = input()
    for idx in range(0, len(word)-1):
        # 다음 문자와 같다면 넘어간다
        if word[idx] == word[idx+1]:
            continue
        # 현재 문자가 다음 문자와 다르면서
        # 이후에 같은 문자가 다시 나온다면 그룹 단어가 아니다
        elif word[idx] in word[idx+1:]:
            count -= 1
            break

print(count)