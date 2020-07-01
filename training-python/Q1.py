import numpy as np 

def solution(arr):
    arr = np.array(arr)
    counter = 0
    for i in range(3):
        if (len(set(arr[i, :])) != len(arr[i, :]) or len(set(arr[:, i])) != len(arr[:, i])):
            return False
        else:
            pass
    return True

if __name__ == "__main__":
    inp = []
    with open("file.txt", "r") as f:
        line = f.read().split("\n")
        for x in line:
            inp.append(list(map(int, x.split(" "))))
    print("valid" if solution(inp) else "invalid")


        
        