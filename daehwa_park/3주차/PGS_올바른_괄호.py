from collections import deque

def solution(s):
    count = 0
    for b in s:
        if b == '(':
            count += 1
        elif b == ')' and count >= 1:
            count -= 1
        else:
            return False

    return count == 0