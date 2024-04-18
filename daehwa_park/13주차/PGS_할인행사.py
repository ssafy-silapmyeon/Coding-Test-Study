def check(dic, want, number):
    for i in range(len(want)):
        if dic[want[i]] != number[i]:
            return False
    return True

def solution(want, number, discount):
    answer = 0
    dic = {}
    
    for w in want: # 원하는 제품 개수 초기화
        dic[w] = 0
    
    for i in range(10):
        if dic.get(discount[i]) != None:
            dic[discount[i]] += 1
    for i in range(len(discount) - 9):
        if check(dic, want, number):
            answer += 1
        if i + 10 == len(discount):
            break
            
        if dic.get(discount[i]) != None:
            dic[discount[i]] -= 1
        if dic.get(discount[i + 10]) != None:
            dic[discount[i + 10]] += 1
    
    return answer