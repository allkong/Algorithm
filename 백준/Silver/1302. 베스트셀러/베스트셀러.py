import sys
from collections import deque
input = sys.stdin.readline

n = int(input()) # 하루 동안 팔린 책의 권수
books = {}

for _ in range(n):
    book = input().strip() # 팔린 책 제목
    # 이미 팔린 책이면 판매수 + 1
    if book in books:
        books[book] += 1
    # 아직 팔린 적 없는 책이면 1권 판매 등록
    else:
        books[book] = 1

# items(판매 권수)를 내림차순으로 정렬한 후에 values(책 제목)를 오름차순으로 정렬
books = sorted(books.items(), key = lambda x:(-x[1], x[0]))
print(books[0][0])