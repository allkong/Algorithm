sheet_music_count, question_count = map(int, input().split()) # 악보 수, 질문 개수
sheet_music = [] # 몇 초에 어떤 악보를 부르는지 저장하는 리스트 (idx가 시간)

# 몇 초에 어떤 악보를 부르는지 sheet_music 만들기
for sheet_music_number in range(1, sheet_music_count+1):
    sec = int(input()) # 악보가 차지하는 시간(초)
    for _ in range(sec):
        sheet_music.append(sheet_music_number)

# 질문의 시간(초)에 부르는 악보 번호 출력하기
for _ in range(question_count):
    question = int(input())
    print(sheet_music[question])