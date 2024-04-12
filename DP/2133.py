import sys

n = int(sys.stdin.readline())

DP = [0] * (n + 1)

if n > 1:
    DP[2] = 3

if n > 2:
    for i in range(3, n + 1):
        if i % 2 == 0:
            DP[i] = DP[i - 2] * 3 + 2
            for j in range(4, i + 1, 2):
                DP[i] += DP[i - j] * 2

print(DP[n])

# https://yabmoons.tistory.com/536
