from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]

def solution(maps):
    answer = 0
    
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    
    answer = bfs(maps, visited)
    
    return answer

def bfs(maps, visited):
    q = deque()
    q.append([0, 0, 1])
    
    while q:
        cur = q.popleft()
        
        if cur[0] == len(maps) - 1 and cur[1] == len(maps[0]) - 1 :
            return cur[2]
        
        for d in range(4):
            ni = cur[0] + di[d]
            nj = cur[1] + dj[d]
            if ni >= 0 and ni < len(maps) and nj >= 0 and nj < len(maps[0]) and not visited[ni][nj] and maps[ni][nj] == 1:
                visited[ni][nj] = True
                q.append([ni, nj, cur[2] + 1])
    return -1
        
        
    
    