from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]

def bfs(start, end, graph): # 맨하탄 거리가 2이하일때 막혀있는지 확인
    q = deque()
    visited = [[False for _ in range(5)] for _ in range(5)]
    
    q.append(start)
    visited[start[0]][start[1]] = True
    
    time = 0
    while q:
        s = len(q)
        for _ in range(s):
            i, j = q.popleft()

            if end[0] == i and end[1] == j:
                return False

            for d in range(4):
                ni = i + di[d]
                nj = j + dj[d]
                if ni >= 0 and ni < 5 and nj >= 0 and nj < 5 and graph[ni][nj] != "X":
                    q.append([ni, nj])
                    visited[ni][nj] = True
        time += 1
        if time == 3: # 거리가 2일때까지만 확인
            break
            
    return True

def check(places, w, answer):
    graph = places[w]
    plist = []
    for i in range(5):
        for j in range(5):
            if graph[i][j] == "P":
                plist.append([i, j])
    if len(plist) >= 2: # 응시자가 2명 이상일 때
        for i in range(len(plist)): # 2명 조합
            for j in range(i + 1 ,len(plist)):
                if abs(plist[i][0] - plist[j][0]) + abs(plist[i][1] - plist[j][1]) <= 2: # 맨하탄 거리 2이하
                    if not bfs(plist[i], plist[j], graph):
                        answer.append(0)
                        return
        answer.append(1)
    else: # 응시자가 1명이거나 없을 때
        answer.append(1)

def solution(places):
    answer = []
    
    for w in range(5):
        check(places, w, answer)
    
    return answer