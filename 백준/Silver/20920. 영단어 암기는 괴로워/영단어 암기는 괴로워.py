import sys
input = sys.stdin.readline

n, m = map(int, input().split())
vocabulary = {}

for _ in range(n):
    word = input().rstrip()
    
    if len(word) >= m:
        vocabulary[word] = vocabulary.get(word, 0) + 1

# 1. 빈도 내림차순
# 2. 단어의 길이 내림차순
# 3. 알파벳 오름차순
vocabulary = sorted(vocabulary.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

for word in vocabulary:
    print(word[0])