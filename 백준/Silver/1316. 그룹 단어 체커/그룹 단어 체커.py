import sys
input = sys.stdin.readline

ALPHABET_COUNT = 26 # 알파벳 개수
ASCII_OFFSET = 97 # 아스키코드에서 a가 97

test_case = int(input())
groupword_count = test_case

for _ in range(test_case):
    word = input()
    visited = [False] * ALPHABET_COUNT # 방문 처리 배열
    visited[ord(word[0]) - ASCII_OFFSET] = True # 첫 알파벳은 무조건 방문 처리한다

    # 한 단어의 모든 알파벳을 살펴본다
    for alphabetIdx in range(1, len(word) - 1):
        target = ord(word[alphabetIdx]) - ASCII_OFFSET

        # 이전과 연속되지 않는 알파벳일 때 확인한다
        if word[alphabetIdx] != word[alphabetIdx-1]:
            # 방문한 적 없는 알파벳이면 방문 표시를 한다
            if not visited[target]:
                visited[target] = True
            # 방문한 적 있는 알파벳이면 그룹 단어가 아니다
            else:
                groupword_count -= 1
                break

print(groupword_count)