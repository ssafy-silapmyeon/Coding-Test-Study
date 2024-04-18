import sys
from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]

def bfs(x, y, visited):
    queue = deque()
    queue.append([x, y])
    visited[x][y] = 0

    time = 1
    while queue:
        size = len(queue)
        for i in range(size):
            cx, cy = queue.popleft()

            for d in range(4):
                nx = cx + di[d]
                ny = cy + dj[d]
                if 0 <= nx < len(visited) and 0 <= ny < len(visited[0]) and visited[nx][ny] == -1:
                    visited[nx][ny] = time
                    queue.append([nx, ny])
        time += 1

n, m = map(int, sys.stdin.readline().split())
x, y = 0, 0

graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

visited = [[-1 for _ in range(m)] for _ in range(n)]
for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            x = i
            y = j
        elif graph[i][j] == 0:
            visited[i][j] = 0

bfs(x, y, visited)

for row in visited:
    print(*row)


