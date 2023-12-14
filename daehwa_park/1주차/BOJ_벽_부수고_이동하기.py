import sys
from collections import deque

def bfs(i, j):
    q = deque()
    visited = [[[False for _ in range(2)] for _ in range(m)] for _ in range(n)]
    q.append([i, j, 1, 0])
    visited[i][j][0] = True
    while q:
        cur = q.popleft()

        if cur[0] == n - 1 and cur[1] == m - 1:
            return cur[2]

        for d in range(4):
            ni = cur[0] + di[d]
            nj = cur[1] + dj[d]
            if 0 <= ni < n and 0 <= nj < m and not visited[ni][nj][cur[3]]:
                if graph[ni][nj] == 1 and cur[3] == 0:
                    visited[ni][nj][1] = True
                    q.append([ni, nj, cur[2] + 1, 1])
                elif graph[ni][nj] == 0:
                    visited[ni][nj][cur[3]] = True
                    q.append([ni, nj, cur[2] + 1, cur[3]])
    return -1

di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]

n, m = map(int, sys.stdin.readline().split())

graph = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
# end input

ans = bfs(0, 0)

print(ans)

