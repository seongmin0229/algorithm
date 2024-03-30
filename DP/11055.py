import sys

n = int(sys.stdin.readline())

numbers = list(map(int, sys.stdin.readline().split(" ")))

DP = [0] * n
DP[0] = numbers[0]

for i in range(n):
    DP[i] = numbers[i]
    for j in range(i):
        if numbers[i] > numbers[j]:
            DP[i] = max(DP[i], DP[j] + numbers[i])

print(max(DP))
