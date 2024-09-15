import sys
input = sys.stdin.readline

weight = int(input())
count = 0

while weight >= 0:
    # 담아야 하는 설탕의 무게가 5의 배수이면 몫만큼 봉지 개수를 더하고 종료한다
    if weight % 5 == 0:
        count += weight // 5
        print(count)
        break
    # 그렇지 않으면 3kg 봉지를 챙기고 봉지 개수를 1 더한다
    weight -= 3
    count += 1
else:
    print(-1)