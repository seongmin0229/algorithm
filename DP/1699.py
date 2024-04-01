import sys
import math

n = int(sys.stdin.readline())

DP = [0] * (n + 1)

DP[1] = 1

if n > 2:
    for i in range(2, n + 1):
        DP[i] = DP[math.trunc(math.sqrt(i))] + 1

print(DP[n])
print(DP)
