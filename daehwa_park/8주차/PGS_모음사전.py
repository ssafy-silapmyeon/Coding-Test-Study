answer = 0
is_same = False

def solution(word): 
    perm(0, "", word)
    
    return answer

def perm(cnt, cur, word):
    global answer, is_same
    mo = ['A', 'E', 'I', 'O', 'U']
    
    if cnt == 5 or is_same:
        return
    
    for m in mo:
        if cur + m == word:
            is_same = True
            answer += 1
            return
        
        if not is_same:
            answer += 1
            perm(cnt + 1, cur + m, word)