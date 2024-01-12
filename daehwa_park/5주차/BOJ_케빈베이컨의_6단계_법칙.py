from collections import deque
import sys

def bfs(start, graph):
    queue = deque()
    queue.append(start)
    visited = [-1 for _ in range(len(graph))]
    visited[start] = 0

    time = 1
    while queue:
        size = len(queue)
        for _ in range(size):
            node = queue.popleft()

            for ne in graph[node]:
                if visited[ne] == -1:
                    visited[ne] = time
                    queue.append(ne)
        time += 1

    return sum(visited)

n, m = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n)]

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    if b - 1 not in graph[a - 1]:
        graph[a - 1].append(b - 1)
    if a - 1 not in graph[b - 1]:
        graph[b - 1].append(a - 1)
# end input
answer = -1
min = sys.maxsize
for i in range(n):
    s = bfs(i, graph)
    if min > s:
        answer = i
        min = s

print(answer + 1)
