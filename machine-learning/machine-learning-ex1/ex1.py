import numpy as np 
import matplotlib.pyplot as plt 
import pandas as pd 

#def gradientDescent():

#def computeCost():


if __name__ == "__main__":
    data = np.genfromtxt("ex1data1.txt", delimiter = ",")
    dataX = data[:, 0]
    dataY = data[:, 1]
    