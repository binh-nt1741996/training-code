import numpy as np 
import matplotlib.pyplot as plt 
import pandas as pd 

plt.style.use("fivethirtyeight")
data = np.loadtxt("ex1data1.txt", delimiter=",")
data_x = data[:,0]
data_y = data[:,1]

plt.scatter(data_x,data_y)
plt.xlabel("x value")
plt.ylabel("y value")
plt.tight_layout()
plt.show()