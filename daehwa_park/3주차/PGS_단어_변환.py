from collections import deque

def solution(begin, target, words):
    answer = 0
    
    q = deque()
    visited = set()
    q.append([begin, 0])
    
    while q:
        cur, time = q.popleft()
        
        if cur == target:
            answer = time
        
        for word in words:
            count = 0
            for i in range(len(cur)):
                if cur[i] != word[i]:
                    count += 1
            if count == 1 and word not in visited:
                visited.add(word)
                q.append([word, time + 1])
    
    return answer