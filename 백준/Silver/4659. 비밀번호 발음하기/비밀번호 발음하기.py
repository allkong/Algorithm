import sys
input = sys.stdin.readline

vowels = ['a', 'e', 'i', 'o', 'u']
while True:
    pw = input().rstrip()
    
    if pw == "end":
        break
        
    flag = 1
    v_ex, v_cnt, c_cnt = 0, 0, 0
    for i in range(len(pw)):
        if i > 0:
            if pw[i-1] == pw[i] and pw[i] != 'e' and pw[i] != 'o':
                flag = 0
                break

        if pw[i] in vowels:
            v_ex = 1
            v_cnt += 1
            c_cnt = 0
        else:
            c_cnt += 1
            v_cnt = 0
        
        if v_cnt == 3 or c_cnt == 3:
            flag = 0
            break
    
    if flag == 1 and v_ex == 1:
        print("<%s> is acceptable." % pw)
    else:
        print("<%s> is not acceptable." % pw)