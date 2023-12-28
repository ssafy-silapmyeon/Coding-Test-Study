def solution(numbers):
    answer = ''
    
    num = list(map(str, numbers))
    
    num.sort(key=lambda x:x*3, reverse=True)
    
    answer = str(int(''.join(num)))
    
    return answer