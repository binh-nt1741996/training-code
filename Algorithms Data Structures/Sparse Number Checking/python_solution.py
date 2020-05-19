import numpy as np

if __name__ == "__main__":
    inp = int(input("Enter an integer: "))
    ls = np.array([0, 1])
    index = 1
    while(True):
        if (inp == 0 or inp == 1):
            print("It is already a sparse number")
            break
        left = index * 2
        right = left * 2 + 1
        if (inp > right):
            index = right
            continue
        elif (inp > left and inp <= right):
            print(f"The smallest sparse number greater than or equal {inp} is {right}")
            break
        else:
            print(f"The smallest sparse number greater than or equal {inp} is {left}")
            break
