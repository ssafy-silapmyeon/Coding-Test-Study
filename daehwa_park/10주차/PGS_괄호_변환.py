def solution(p):
    answer = ''
    # 올바른지 검사
    if check(p):
        answer = p
    else:
        answer = brace(p) # 변환
    
    return answer

def brace(s):
    if s == '':
        return ''
    
    rb = 0
    lb = 0
    u = ''
    v = ''
    for i, c in enumerate(s):
        if i == 0 or rb != lb:
            if c == '(':
                lb += 1
                u += '('
            else:
                rb += 1
                u += ')'
        else:
            v = s[i:]
            break
    
    if check(u):
        return u + brace(v)
    else:
        return "("+ brace(v) + ")" + rev(u)

def rev(u):
    s = u[1:-1]
    ns = ''
    for c in s:
        if c == "(":
            ns += ")" 
        else:
            ns += "("
    return ns
            
def check(s):
    cnt = 0
    for c in s:
        if cnt < 0:
            return False
        if c == "(":
            cnt += 1
        else:
            cnt -= 1
    return True
        