def solution(n, k):
    answer = 0
    
    num = n_to_k(n, k)
    filtered = [p for p in num.split("0") if p]
    for p in map(int, filtered):
        if is_prime(p):
            answer += 1
    
    return answer

def n_to_k(n, k):
    num = ""
    while n > 0:
        q, r = divmod(n, k)
        num = str(r) + num
        n = q
    return num

def is_prime(num):
    if num == 1:
        return False
    for i in range(2, int(num ** 0.5) + 2):
        if num != i and num % i == 0:
            return False
    return True