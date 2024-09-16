import sys
input = sys.stdin.readline

row_size, col_size = map(int, input().split())
chess = [input().rstrip() for _ in range(row_size)]
count = []

#  8x8 크기의 체스판을 검사하므로 시작점의 범위는 0부터 size - 7까지이다
for start_row in range(row_size - 7):
    for start_col in range(col_size - 7):
        white_count = 0 # W로 시작할 때 경우의 수
        black_count = 0 # B로 시작할 때 경우의 수

        # 시작점에서 8x8 크기의 체스판을 검사한다
        for current_row in range(start_row, start_row + 8):
            for current_col in range(start_col, start_col + 8):
                # 짝수행이 W로 시작하면 홀수행은 B로 시작해야 한다
                # 짝수열이 W면 홀수열은 B다
                # => 시작점이 W일 때, (행 idx + 열 idx)가 짝수면 W, 홀수면 B다

                # 짝수행이 B로 시작하면 홀수행은 W로 시작해야 한다
                # 짝수열이 B면 홀수열은 W이다
                # => 시작점이 B일 때, (행 idx + 열 idx)가 짝수면 B, 홀수면 W이다

                if (current_row + current_col) % 2 == 0:
                    # 짝수이면 짝수인 애들끼리는 색이 같아야 하므로 W나 B로 통일시킨다
                    # 시작점과 색이 같아야 한다 (시작점이 짝수니까)
                    if chess[current_row][current_col] != 'W':
                        white_count += 1
                    else:
                        black_count += 1
                
                else:
                    # 홀수이면 홀수인 애들끼리는 색이 같아야 하므로 W나 B로 통일시킨다
                    # 시작점과 색이 달라야 한다
                    if chess[current_row][current_col] != 'B':
                        white_count += 1
                    else:
                        black_count += 1

        count.append(min(white_count, black_count))

# 가장 적게 바꿔도 되는 경우의 수를 출력한다
print(min(count))