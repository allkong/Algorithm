import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
k = int(input())
cards = []
nums = set()

for _ in range(n):
    cards.append(input().rstrip())

for case in permutations(cards, k):
    nums.add(''.join(case))

print(len(nums))