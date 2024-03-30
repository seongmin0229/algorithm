import sys

n = int(sys.stdin.readline())

numbers = list(map(int, sys.stdin.readline().split(" ")))

DP = [1] * n

for i in range(n):
    for j in range(i):
        if numbers[j] > numbers[i]:
            DP[i] = max(DP[i], DP[j] + 1)

print(max(DP))
