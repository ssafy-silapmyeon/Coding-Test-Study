import sys

n = int(sys.stdin.readline())

array = list(map(int, sys.stdin.readline().split()))
# end input
cur = 0
max_num = -1000000000

for i in range(n):
   cur = max(array[i], array[i] + cur)
   max_num = max(max_num, cur)

print(max_num)