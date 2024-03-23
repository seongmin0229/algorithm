# 문제
# <그림 1>과 같이 정사각형 모양을 한 다섯 종류의 색종이가 있다. 색종이의 크기는 1×1, 2×2, 3×3, 4×4, 5×5로 총 다섯 종류가 있으며, 각 종류의 색종이는 5개씩 가지고 있다.


# <그림 1>

# 색종이를 크기가 10×10인 종이 위에 붙이려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 0 또는 1이 적혀 있다. 1이 적힌 칸은 모두 색종이로 덮여져야 한다. 색종이를 붙일 때는 종이의 경계 밖으로 나가서는 안되고, 겹쳐도 안 된다. 또, 칸의 경계와 일치하게 붙여야 한다. 0이 적힌 칸에는 색종이가 있으면 안 된다.

# 종이가 주어졌을 때, 1이 적힌 모든 칸을 붙이는데 필요한 색종이의 최소 개수를 구해보자.

# 입력
# 총 10개의 줄에 종이의 각 칸에 적힌 수가 주어진다.

# 출력
# 모든 1을 덮는데 필요한 색종이의 최소 개수를 출력한다. 1을 모두 덮는 것이 불가능한 경우에는 -1을 출력한다.

import sys

map = [list(map(int, sys.stdin.readline().split())) for _ in range(10)]

papers = [5 for i in range(5)]


def is_valid(size, r, c):
    for i in range(size):
        for j in range(size):
            if map[r + i][c + j] == 0:
                return False
    return True


def cover(size, r, c):
    for i in range(size):
        for j in range(size):
            map[r + i][c + j] = 0
    papers[size - 1] -= 1


def uncover(size, r, c):
    for i in range(size):
        for j in range(size):
            map[r + i][c + j] = 1
    papers[size - 1] += 1


def backtracking(r, c, d):
    if map[r][c] == 0:
        return_v = 0
        if c + 1 < 10:
            return_v = backtracking(r, c + 1, d)
        elif r + 1 < 10:
            return_v = backtracking(r + 1, 0, d)
        else:
            return d
        return return_v

    minimum = 999

    for i in range(len(papers)):
        size = i + 1
        if r + size - 1 < 10 and c + size - 1 < 10 and is_valid(size, r, c):
            return_v = 0
            cover(size, r, c)
            if papers[i] < 0:
                uncover(size, r, c)
                continue
            if c + size < 10:
                return_v = backtracking(r, c + size, d + 1)
            elif r + 1 < 10:
                return_v = backtracking(r + 1, 0, d + 1)
            else:
                return_v = d + 1
            uncover(size, r, c)
            if return_v != -1:
                minimum = min(return_v, minimum)

    if minimum == 999:
        return -1
    else:
        return minimum


print(backtracking(0, 0, 0))
