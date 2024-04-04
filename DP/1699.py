import sys

n = int(sys.stdin.readline())

DP = [0] * (n + 1)

DP[1] = 1

if n > 1:
    for i in range(2, n + 1):
        DP[i] = i
    for i in range(2, n + 1):
        for j in range(1, int(i**0.5) + 1):
            DP[i] = min(DP[i - j * j] + 1, DP[i])

print(DP[n])
