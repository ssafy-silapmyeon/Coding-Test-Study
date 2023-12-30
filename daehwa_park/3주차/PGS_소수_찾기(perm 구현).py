count = 0

def solution(numbers):
    global count
    
    num_list = list(map(str, numbers))
    
    visited = [False] * len(num_list)
    
    dic = {}
    
    for i in range(1, len(num_list) + 1):
        result = ""
        go(0, i, visited, num_list, result, dic)
    
    return count

def go(cnt, dst, visited, num_list, result, dic):
    global count
    if cnt == dst:
        num = int(result)
        if num not in dic:
            dic[num] = 1
            if is_prime(num):
                count += 1
        return
    
    for i in range(len(num_list)):
        if visited[i]:
            continue
            
        visited[i] = True
        go(cnt + 1, dst, visited, num_list, result + num_list[i], dic)
        visited[i] = False
        
def is_prime(number):
    if number == 1 or number == 0:
        return False
    for i in range(2, int(number ** 0.5) + 1):
        if number % i == 0:
            return False
    return True