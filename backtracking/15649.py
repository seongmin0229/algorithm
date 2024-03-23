import sys
import copy


n, m = map(int, sys.stdin.readline().split())

n_list = [i + 1 for i in range(n)]


def solution(number_list, c):
    if c == 0:
        for number in number_list:
            print(number, end=" ")
        print()
        # print(number_list)
        return

    for n in n_list:
        if n in number_list:
            return
        else:
            new_list = copy.deepcopy(number_list)
            new_list.append(n)
            solution(new_list, c - 1)


solution([], m)
