# 문제
# 2048 게임은 4×4 크기의 보드에서 혼자 즐기는 재미있는 게임이다. 이 링크를 누르면 게임을 해볼 수 있다.

# 이 게임에서 한 번의 이동은 보드 위에 있는 전체 블록을 상하좌우 네 방향 중 하나로 이동시키는 것이다. 이때, 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다. 한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다. (실제 게임에서는 이동을 한 번 할 때마다 블록이 추가되지만, 이 문제에서 블록이 추가되는 경우는 없다)

# 이 문제에서 다루는 2048 게임은 보드의 크기가 N×N 이다. 보드의 크기와 보드판의 블록 상태가 주어졌을 때, 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값을 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 보드의 크기 N (1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 게임판의 초기 상태가 주어진다. 0은 빈 칸을 나타내며, 이외의 값은 모두 블록을 나타낸다. 블록에 쓰여 있는 수는 2보다 크거나 같고, 1024보다 작거나 같은 2의 제곱꼴이다. 블록은 적어도 하나 주어진다.

# 출력
# 최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록을 출력한다.

import sys
import itertools
import copy


def up(map):
    for i in range(len(map)):
        j = 0
        while j < len(map):
            if map[j][i] != 0:
                cur_num = map[j][i]
                next_idx = j + 1
                while next_idx < len(map):
                    if map[next_idx][i] != 0:
                        if map[next_idx][i] == map[j][i]:
                            map[j][i] = cur_num * 2
                            map[next_idx][i] = 0
                        break
                    next_idx += 1
            j += 1
        j = 0
        while j < len(map):
            if map[j][i] == 0:
                next_idx = j + 1
                while next_idx < len(map):
                    if map[next_idx][i] != 0:
                        map[j][i] = map[next_idx][i]
                        map[next_idx][i] = 0
                        break
                    else:
                        next_idx += 1
            j += 1


def down(map):
    for i in range(len(map)):
        j = len(map) - 1
        while j > -1:
            if map[j][i] != 0:
                cur_num = map[j][i]
                next_idx = j - 1
                while next_idx > -1:
                    if map[next_idx][i] != 0:
                        if map[next_idx][i] == map[j][i]:
                            map[j][i] = cur_num * 2
                            map[next_idx][i] = 0
                        break
                    next_idx -= 1
            j -= 1
        j = len(map) - 1
        while j > -1:
            if map[j][i] == 0:
                next_idx = j - 1
                while next_idx > -1:
                    if map[next_idx][i] != 0:
                        map[j][i] = map[next_idx][i]
                        map[next_idx][i] = 0
                        break
                    else:
                        next_idx -= 1
            j -= 1


def left(map):
    for i in range(len(map)):
        j = 0
        while j < len(map):
            if map[i][j] != 0:
                cur_num = map[i][j]
                next_idx = j + 1
                while next_idx < len(map):
                    if map[i][next_idx] != 0:
                        if map[i][next_idx] == map[i][j]:
                            map[i][j] = cur_num * 2
                            map[i][next_idx] = 0
                        break
                    next_idx += 1
            j += 1
        j = 0
        while j < len(map):
            if map[i][j] == 0:
                next_idx = j + 1
                while next_idx < len(map):
                    if map[i][next_idx] != 0:
                        map[i][j] = map[i][next_idx]
                        map[i][next_idx] = 0
                        break
                    else:
                        next_idx += 1
            j += 1


def right(map):
    for i in range(len(map)):
        j = len(map) - 1
        while j > -1:
            if map[i][j] != 0:
                cur_num = map[i][j]
                next_idx = j - 1
                while next_idx > -1:
                    if map[i][next_idx] != 0:
                        if map[i][next_idx] == map[i][j]:
                            map[i][j] = cur_num * 2
                            map[i][next_idx] = 0
                        break
                    next_idx -= 1
            j -= 1
        j = len(map) - 1
        while j > -1:
            if map[i][j] == 0:
                next_idx = j - 1
                while next_idx > -1:
                    if map[i][next_idx] != 0:
                        map[i][j] = map[i][next_idx]
                        map[i][next_idx] = 0
                        break
                    else:
                        next_idx -= 1
            j -= 1


def map_max(map):
    max = -1
    for i in range(len(map)):
        for j in range(len(map)):
            if map[i][j] > max:
                max = map[i][j]
    return max


UP = 1
DOWN = 2
RIGHT = 3
LEFT = 4

if __name__ == "__main__":
    n = int(sys.stdin.readline())

    origin_map = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    # print(origin_map)
    direction = [UP, DOWN, RIGHT, LEFT]

    direction_permutations = list(itertools.product(direction, repeat=5))

    max_val = -1
    for direction_permutation in direction_permutations:
        map = copy.deepcopy(origin_map)
        for direction in direction_permutation:
            if direction == UP:
                up(map)
            elif direction == DOWN:
                down(map)
            elif direction == RIGHT:
                right(map)
            elif direction == LEFT:
                left(map)
        if max_val < map_max(map):
            max_val = map_max(map)
            # print(direction_permutation)
            # print(map)
    print(max_val)
