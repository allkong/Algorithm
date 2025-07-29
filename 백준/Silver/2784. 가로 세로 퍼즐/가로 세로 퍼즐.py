import sys
input = sys.stdin.readline

def check_puzzle():
    remain = []
    vertical = []

    # 선택되지 않은 단어 찾기 (세로 단어)
    for i in range(6):
        if not selected[i]:
            remain.append(voca[i])
    
    # 가로 단어에서 세로 단어 뽑기
    for i in range(3):
        vertical.append(horizontal[0][i] + horizontal[1][i] + horizontal[2][i])

    # 선택되지 않은 단어들이 가로 단어에서 뽑은 세로 단어들과 같다면 퍼즐 완성
    if sorted(remain) == sorted(vertical):
        print(*horizontal, sep='\n')
        exit()

def permutation(select_idx):
    # 1. 기저 조건
    # 모든 원소를 선택함
    if select_idx == 3:
        check_puzzle()
        return
    
    # 2. 전처리 로직
    # 아직 다 선택하지 않음
    for i in range(6):
        # 이미 선택한 원소는 패스
        if selected[i]:
            continue
        
        selected[i] = True
        horizontal[select_idx] = voca[i]

        # 3. 재귀 호출
        permutation(select_idx + 1)

        # 4. 후처리 로직
        # 사용 다 했으면 되돌리기
        selected[i] = False

voca = [input().rstrip() for _ in range(6)]
selected = [False] * 6
horizontal = [''] * 3

permutation(0)
print(0)