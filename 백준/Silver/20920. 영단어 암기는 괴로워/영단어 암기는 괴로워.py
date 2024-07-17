from collections import Counter
import sys
input = sys.stdin.readline

word_count, min_length = map(int, input().split())
vocabulary = []
for _ in range(word_count):
    word = input().strip()
    # 길이가 min_length 이상인 단어들만 외운다
    if len(word) >= min_length:
        vocabulary.append(word)

# 리스트의 원소 개수 세기
vocabulary = dict(Counter(vocabulary))

# 1. 빈도 내림차순
# 2. 단어의 길이 내림차순
# 3. 알파벳 오름차순
vocabulary = sorted(vocabulary.items(), key=lambda x:(-x[1], -len(x[0]), x[0]))

for word in vocabulary:
    print(word[0])