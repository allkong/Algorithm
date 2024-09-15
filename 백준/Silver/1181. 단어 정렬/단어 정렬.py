import sys
input = sys.stdin.readline

word_count = int(input())
words = [input().strip() for _ in range(word_count)]
words = list(set(words)) # 중복 제거
words.sort(key=lambda x: (len(x), x)) # 길이가 짧은 순으로 정렬, 길이가 같으면 사전 순으로 정렬
print(*words, sep='\n')