import sys
input = sys.stdin.readline

string = input()
count = 0

for index in range(1, len(string) - 1):
    # 이전 문자와 현재 문자가 다르면 횟수 증가
    if string[index] != string[index - 1]:
        count += 1

# 문자가 달라지는 시작 부분과 끝 부분을 둘 다 더했으나 1번만 바꾸면 되므로 2로 나눈다
# 문자가 달라지는 끝 부분이 문자열의 마지막 문자일 경우를 고려해 count + 1
print((count + 1) // 2)