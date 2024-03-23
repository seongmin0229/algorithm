import sys

UP = 1
DOWN = 2
RIGHT = 3
LEFT = 4


def check_overlap(sharks):
    sharks.sort(reverse=True, key=lambda x: x[4])
    sharks.sort(key=lambda x: (x[0], x[1]))
    survived_shark = None
    new_shark_list = []
    for shark in sharks:
        if survived_shark == None:
            new_shark_list.append(shark)
            survived_shark = shark
            continue

        if shark[0] != survived_shark[0] or shark[1] != survived_shark[1]:
            new_shark_list.append(shark)
            survived_shark = shark

    return new_shark_list


def moving_sharks(sharks):
    for shark in sharks:
        if shark[2] == 0:
            continue
        else:
            if shark[3] == LEFT:
                if c == 1:
                    continue
                direction = (
                    RIGHT if ((c - shark[1] + shark[2]) // (c - 1)) % 2 == 1 else LEFT
                )
                moved_distance = (c - shark[1] + shark[2]) % (c - 1)
                if direction == RIGHT:
                    shark[1] = moved_distance + 1
                else:
                    shark[1] = c - moved_distance
                shark[3] = direction
            elif shark[3] == RIGHT:
                if c == 1:
                    continue
                direction = (
                    LEFT if ((shark[1] + shark[2] - 1) // (c - 1)) % 2 == 1 else RIGHT
                )
                moved_distance = (shark[1] + shark[2] - 1) % (c - 1)
                if direction == RIGHT:
                    shark[1] = moved_distance + 1
                else:
                    shark[1] = c - moved_distance
                shark[3] = direction
            elif shark[3] == DOWN:
                if r == 1:
                    continue
                direction = (
                    UP if ((shark[0] + shark[2] - 1) // (r - 1)) % 2 == 1 else DOWN
                )
                moved_distance = (shark[0] + shark[2] - 1) % (r - 1)
                if direction == DOWN:
                    shark[0] = moved_distance + 1
                else:
                    shark[0] = r - moved_distance
                shark[3] = direction
            elif shark[3] == UP:
                if r == 1:
                    continue
                direction = (
                    DOWN if ((r - shark[0] + shark[2]) // (r - 1)) % 2 == 1 else UP
                )
                moved_distance = (r - shark[0] + shark[2]) % (r - 1)
                if direction == DOWN:
                    shark[0] = moved_distance + 1
                else:
                    shark[0] = r - moved_distance
                shark[3] = direction


r, c, m = map(int, sys.stdin.readline().split())

sharks = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]


angler_location = 0
total_shark_size = 0

while angler_location <= c:
    # 낚시왕이 오른쪽으로 한 칸 이동한다.
    angler_location += 1

    # 낚시왕이 열에 있는 상어 중에서 땅과 가장 가까운 상어를 잡는다.
    closer_shark = None
    min_distance = 999
    for shark in sharks:
        if shark[1] == angler_location and shark[0] < min_distance:
            closer_shark = shark
            min_distance = shark[0]

    # 격자판에서 잡은 상어가 사라진다
    if closer_shark != None:
        sharks.remove(closer_shark)
        total_shark_size += closer_shark[4]

    # 상어가 이동한다
    moving_sharks(sharks)

    # 같은 격자판에 있는 상어중 큰놈만 살아남는다.
    sharks = check_overlap(sharks)

print(total_shark_size)
