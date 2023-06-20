def solution(numer1, denom1, numer2, denom2):    
    numer = numer1 * denom2 + numer2 * denom1
    denom = denom1 * denom2
    max_num = 1
    for i in range(2, max(numer, denom)+1):
        if numer % i == 0 and denom % i == 0:
            max_num = i
    return [numer/max_num, denom/max_num]