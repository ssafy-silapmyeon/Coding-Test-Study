import sys
from collections import deque

def bfs(start, graph, visited):
    queue = deque()
    queue.append(start)
    visited[start] = True

    while queue:
        vertex = queue.popleft()
        for near in graph[vertex]:
            if not visited[near]:
                queue.append(near)
                visited[near] = True


n, m = map(int, sys.stdin.readline().split())

count = 0

visited = [False for _ in range(n + 1)]

graph = [[] for _ in range(n + 1)]
for i in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, n + 1):
    if not visited[i]:
        bfs(i, graph, visited)
        count += 1

print(count)

