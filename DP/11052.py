import sys

n = int(sys.stdin.readline())

prices = list(map(int, sys.stdin.readline().split()))

prices.insert(0, 0)

DP = [0] * (n + 1)

for i in range(1, n + 1):
    for j in range(1, i + 1):
        DP[i] = max(DP[i], DP[i - j] + prices[j])

print(DP[n])
