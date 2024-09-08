from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

def find_number(array, left_value, right_value):
    right_index = bisect_right(array, right_value)
    left_index = bisect_left(array, left_value)
    return right_index - left_index

test_case = int(input())
for _ in range(test_case):
    question_number_count = int(input())
    question_numbers = list(map(int, input().split()))
    question_numbers.sort()
    answer_number_count = int(input())
    answer_numbers = list(map(int, input().split()))

    for answer_number in answer_numbers:
        find = find_number(question_numbers, answer_number, answer_number)
        print(1 if find else 0)