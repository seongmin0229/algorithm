import sys

n = int(sys.stdin.readline())

numbers = list(map(int, sys.stdin.readline().split()))

DP = [0] * n
DP[0] = numbers[0]

if n > 1:
    for i in range(1, n):
        DP[i] = max(numbers[i], DP[i - 1] + numbers[i])

print(max(DP))
