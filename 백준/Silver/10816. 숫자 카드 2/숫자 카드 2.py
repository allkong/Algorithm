from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

n = int(input())
have = list(map(int, input().split()))
have.sort()
m = int(input())
cards = list(map(int, input().split()))

def cnt(a, left_value, right_value):
	right_index = bisect_right(a, right_value)
	left_index = bisect_left(a, left_value)
	return right_index - left_index

for card in cards:
	print(cnt(have, card, card), end=' ')