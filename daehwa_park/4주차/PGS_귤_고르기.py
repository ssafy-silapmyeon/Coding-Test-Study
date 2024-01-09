from collections import Counter

def solution(k, tangerine):
    answer = 0
    
    h = Counter(tangerine)
    
    sum = 0
    for i in sorted(h.values(), reverse=True):
        sum += i
        answer += 1
        if sum >= k:
            break
    
    return answer