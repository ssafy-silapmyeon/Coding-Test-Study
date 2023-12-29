from itertools import permutations

count = 0

def solution(numbers):
    global count
    
    s = set()
    
    for i in range(1, len(numbers) + 1):
        s |= set(map(int, map("".join, permutations(list(numbers), i))))
    
    for num in s:
        if is_prime(num):
            count += 1
    
    return count
        
def is_prime(number):
    if number == 1 or number == 0:
        return False
    for i in range(2, int(number ** 0.5) + 1):
        if number % i == 0:
            return False
    return True