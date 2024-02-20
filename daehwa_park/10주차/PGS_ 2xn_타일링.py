def solution(n):
    answer = 0
    d = [1, 1]
    
    if n >= 2:
        for i in range(2, n + 1):
            d.append((d[i - 1] + d[i - 2]) % 1000000007) 
    answer = d[n] % 1000000007
    
    return answer