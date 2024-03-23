# 문제
# N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

# N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 N이 주어진다. (1 ≤ N < 15)

# 출력
# 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

import sys

n = int(sys.stdin.readline())

map = [-1 for i in range(n)]
visited = [False for _ in range(n)]

result = 0


def is_valid(x):
    for i in range(x):
        if map[x] == map[i] or abs(x - i) == abs(map[x] - map[i]):
            return False

    return True


def backtracking(c):
    global result
    if c == n:
        result += 1
        return
    for i in range(n):
        map[c] = i
        if is_valid(c):
            backtracking(c + 1)
        map[c] = -1


backtracking(0)
print(result)
