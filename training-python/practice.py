import numpy as np
import sys
import copy

record_steps = []

def diff(arr1, arr2):
    size = arr1.shape[0]
    return np.sum((arr1 - arr2)**2)


def move(arr, element, index, direction):
    direction = -1 if (direction%2 == 1) else 1
    if (element == 2):
        arr[:, index] = np.roll(arr[:, index], direction)
    else:
        arr[index] = np.roll(arr[index], direction)
    return arr


min_diff = 1000
def solve(arr1, arr2, difference):
    global min_diff
    if difference == 0:
        return True
    else:
        counter = 0
        elements = np.arange(1, 3)
        directions = np.arange(1, 3)
        indexes = arr1.shape[0]
        test = copy.deepcopy(arr1)
        for index in range(indexes):
            for element in elements:
                for direction in directions:
                    temp = copy.deepcopy(arr1)
                    temp = move(temp, element, index, direction)
                    
                    difference = diff(temp, arr2)

                    if difference < min_diff:
                        if counter > 0:
                            record_steps.append([element, index, direction])
                        min_diff = difference
                        counter+=1
                    if (min_diff == 0):
                        return True
                arr1 = copy.deepcopy(temp) if diff(arr1, arr2) < min_diff else arr1
                min_diff = diff(arr1, arr2) if diff(arr1, arr2) < min_diff else min_diff
        return solve(arr1, arr2, min_diff)


if __name__ == "__main__":
    size = int(input("Enter matrix size: "))
    ls = []
    for i in range(size):
        inp_row = list(map(int, input(f"Enter {i} row: ").split(" ")))
        ls.append(inp_row)
    arr = np.array(ls)
    
    desire_ls = []
    for i in range(size):
        inp_row = list(map(int, input(f"Enter {i} desired row: ").split(" ")))
        desire_ls.append(inp_row)

    desire_arr = np.array(desire_ls)
    print("yes" if solve(arr, desire_arr, diff(arr, desire_arr)) else "no")
    print(record_steps)