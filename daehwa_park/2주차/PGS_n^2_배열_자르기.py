def solution(n, left, right):
    answer = []
    
    for i in range(left, right + 1):
        q = i // n # 몫
        d = i % n # 나머지
        
        num = max(q + 1, d + 1)
        answer.append(num)
        
    return answer
