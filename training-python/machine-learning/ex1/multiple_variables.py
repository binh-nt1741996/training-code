import numpy as np 
import matplotlib.pyplot as plt 

def featureNormalize(dataX):
    #Calculate the mean and the standard deviation of dataX
    mu = np.mean(dataX, axis=0)
    sigma = np.std(dataX, axis=0)
    #Start feature normalizing dataX
    dataX = (dataX - mu)/sigma
    return dataX 

def computeCost(dataX, dataY, theta):
    m = len(dataY)
    J_vals = (1/(2*m)) * np.sum((np.dot(dataX, theta) - dataY)**2)

    return J_vals
def gradient_descent(dataX, dataY, theta, iter, alpha):
    m = len(dataY)
    J_history = []
    for i in range(iter):
        theta = theta - (alpha/m) * np.dot(np.dot(dataX, theta) - dataY, dataX)
        J_history.append(computeCost(dataX, dataY, theta))
    
    return theta, J_history

def normalEquation(dataX, dataY):
    theta = np.dot(np.dot(np.linalg.inv(np.dot(dataX.T,dataX)), dataX.T), dataY)
    return theta

if __name__ == "__main__":
    data = np.loadtxt("ex1data2.txt", delimiter=",")
    dataX = data[:,:2]
    dataY = data[:,2]
    #Conduct feature normalize
    dataX = featureNormalize(dataX)
    #Add the ones array to dataX (np.ones((47,1)) instead of np.ones(47) as in 1-variable problem)
    dataX = np.concatenate([np.ones((len(dataY),1)), dataX], axis=1)
    theta = np.zeros(3)

    theta, J_history = gradient_descent(dataX, dataY, theta, 400, 0.1)
    print("{:,.3f} {:,.3f} {:,.3f}".format(*theta))

    #theta found by normal equation
    nor_theta = normalEquation(dataX, dataY)
    print(nor_theta)