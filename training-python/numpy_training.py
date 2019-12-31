import numpy as np

if __name__=="__main__":
    inp_data = np.array(list(map(int, input("Enter list of integers: ").split(" "))))
    data1 = np.array([1,3,4])
    print(np.concatenate([np.repeat(inp_data,3),np.tile(inp_data,3)]))