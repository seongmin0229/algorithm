# 문제
# 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

# 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.


# 입력
# 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

# 출력
# 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

import sys

n = int(sys.stdin.readline())

DP = [0] * (n + 1)

DP[1] = 1
if n > 1:
    DP[2] = 2

if n > 2:
    for i in range(3, n + 1):
        DP[i] = DP[i - 1] + DP[i - 2]

print(DP[n] % 10007)

# 숫자 그냥 쭉 써보다가 피보나치인 거 눈치챔
# DP는 뭔가 점화식 쓰는 거랑 정확성 증명하는게 논점인거 같음.
