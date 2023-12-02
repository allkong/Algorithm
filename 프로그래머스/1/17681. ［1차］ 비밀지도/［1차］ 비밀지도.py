def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        a1 = format(arr1[i], f'0{n}b')
        a2 = format(arr2[i], f'0{n}b')
        row = ''
        for j in range(n):
            if int(a1[j]) or int(a2[j]):
                row += '#'
            else:
                row += ' '
        answer.append(row)
    return answer