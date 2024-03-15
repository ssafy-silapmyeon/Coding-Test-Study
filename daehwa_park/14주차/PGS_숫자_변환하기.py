from collections import deque

def bfs(s, e, n):
    q = deque()
    visited = [False] * 1000001
    q.append([s, 0])
    visited[s] = True
    while q:
        cur, cnt = q.popleft()
        if cur == e:
            return cnt
        if cur * 3 <= e and not visited[cur * 3]:
            q.append([cur * 3, cnt + 1])
            visited[cur * 3] = True
        if cur * 2 <= e and not visited[cur * 2]:
            q.append([cur * 2, cnt + 1])
            visited[cur * 2] = True
        if cur + n <= e and not visited[cur + n]:
            q.append([cur + n, cnt + 1])
            visited[cur + n] = True
    return -1

def solution(x, y, n):
    answer = -1
    
    answer = bfs(x, y, n)
    
    return answer