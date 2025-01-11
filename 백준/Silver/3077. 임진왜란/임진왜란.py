import sys
input = sys.stdin.readline

def grade():
    global score
    
    # 학생의 답 중에 2개를 고른다
    for i in range(n):
        for j in range(i + 1, n):
            # 2개의 순서가 올바르면 1점을 준다
            if answers[i] < answers[j]:
                score += 1

n = int(input()) # 해전의 개수
correct = list(input().split()) # 올바른 정답
answers = list(input().split()) # 학생이 작성한 답안
score = 0

# 학생이 입력한 답안을 정답 순서로 초기화
for i in range(n):
    answers[i] = correct.index(answers[i])

# 채점 후 점수 출력
grade()
print(f'{score}/{n * (n-1) // 2}')