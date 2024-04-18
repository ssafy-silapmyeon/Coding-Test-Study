def solution(s):
    min_len = float('inf')
    
    if len(s) == 1: # 문자열의 길이가 1이라면 무조건 1
        return 1
    
    for i in range(len(s) // 2): # 길이의 반보다 길게 나누면 어차피 압축이 안됨
        tmp_min = 0 # 임시 최솟값
        cnt = 0 # 반복 개수
        idx = 0 
        before = s[0:i+1] # 이전 문자열
        while idx + i < len(s):
            sub = s[idx:idx+i+1]
            if before == sub:
                cnt += 1
            else:
                if cnt > 1:
                    tmp_min += len(before) + len(str(cnt)) # 압축 횟수의 자릿수 만큼 더해줌
                else:
                    tmp_min += len(before)
                before = sub
                cnt = 1
            idx = idx + i + 1
            if idx + i >= len(s): # 자르고 남은 문자열
                tmp_min += len(s) - idx
                if cnt > 1:
                    tmp_min += len(before) + len(str(cnt))
                else:
                    tmp_min += len(before)
                break
        min_len = min(min_len, tmp_min)
        
    return min_len