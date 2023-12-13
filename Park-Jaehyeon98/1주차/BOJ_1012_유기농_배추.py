# 백준에서는 재귀 깊이가 1000으로 제한
import sys

# 해당 코드를 통해 10000으로 제한 해제
sys.setrecursionlimit(10000)

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

# DFS 함수
def DFS(x, y):
  arr[x][y] = 0

  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]

    if nx < 0 or ny < 0 or nx >= n or ny >= m:
      continue
    if arr[nx][ny] == 1:
      arr[nx][ny] = 0
      DFS(nx, ny)

from collections import deque      

# BFS 함수
def BFS(x, y):
  que = deque()
  que.append((x, y))
  arr[x][y] = 0
  
  # que에 아무것도 없을 때까지
  while(que):
    x, y = que.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if nx < 0 or ny < 0 or nx >= n or ny >= m:
        continue
      if arr[nx][ny] == 1:
        arr[nx][ny] = 0
        que.append((nx, ny))

# 테스트 케이스 T만큼 반복
for _ in range(int(input())):
  # 가로길이, 세로길이, 배추 갯수 입력
  m, n, k = map(int, input().split())

  # 세로, 가로만큼 배열 생성
  arr = [[0]*m for _ in range(n)]

  # 배추 위치 배열에 저장
  for i in range(k):
    y, x = map(int, input().split())
    arr[x][y] = 1

  # 배추흰지렁이의 수
  cnt = 0
  
  # 배열의 값이 1일 때 DFS 실행
  for i in range(n):
    for j in range(m):
      if arr[i][j] == 1:
        cnt += 1
        BFS(i, j)

  print(cnt)