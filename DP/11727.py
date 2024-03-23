import sys

n = int(sys.stdin.readline())

DP = [0] * (n + 1)

DP[1] = 1

if n > 1:
    DP[2] = 3

if n > 2:
    for i in range(3, n + 1):
        DP[i] = DP[i - 1] + DP[i - 2] * 2

print(DP[n] % 10007)
