import sys

n = int(sys.stdin.readline())

nums = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

nums.sort(key=lambda x: (x[0], x[1]))

for num in nums:
    print(f"{num[0]} {num[1]}")
