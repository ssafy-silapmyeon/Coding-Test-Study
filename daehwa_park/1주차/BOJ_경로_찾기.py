import sys

sys.setrecursionlimit(1000000)

def dfs(start, dest):
   global is_route
   for i in range(n):
      if array[start][i] == 1 and not visited[i]:
         if i == dest:
            is_route = True
         else:
            visited[i] = True
            dfs(i, dest)

n = int(sys.stdin.readline())

array = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

answer = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
   for j in range(n):
      visited = [False for _ in range(n)]
      is_route = False
      dfs(i, j)
      if is_route:
         answer[i][j] = 1

for i in range(n):
   print(*answer[i])