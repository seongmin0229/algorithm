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


import sys

r, c, m = map(int, sys.stdin.readline().split())

sharks = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

angler_location = -1

for shark in sharks:
    if shark[0] == 4:
        sharks.remove(shark)

print(sharks)
