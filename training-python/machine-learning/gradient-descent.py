import numpy as np 
import matplotlib.pyplot as plt 
import pandas as pd 

def computeCost(theta,data_x,data_y):
    n = len(data_y)
    J = 0
    hypothesis = np.dot(data_x,theta)
    J = (1/(2*n))*np.sum(np.square(hypothesis-data_y))

    return J

def gradient_descent(data_x, data_y, theta, alpha, num_iters):
    n = data_y.size
    J_history = []

    for i in range(num_iters):
        theta = theta - (alpha/n)*(np.dot(data_x,theta)-data_y).dot(data_x)

        J_history.append(computeCost(theta,data_x,data_y))
    return theta, J_history
def normalization(data_x, data_y):
    atrans = data_x.transpose()
    a_inv_trans = np.linalg.inv(np.dot(atrans,data_x))

    theta = np.linalg.multi_dot([a_inv_trans,atrans,data_y])

    return theta

if (__name__ == "__main__"):
    plt.style.use("fivethirtyeight")
    data = np.loadtxt("ex1data1.txt", delimiter=",")
    data_x = np.array(data[:,0])
    data_y = data[:,1]
    n = len(data_x)

    data_x = data_x.reshape(n,1)
    one_value = np.ones((n,1))
    data_x = np.concatenate((one_value, data_x), axis=1)
    theta = np.array([0,0])
    print("Cost computed = %.2f" %computeCost(theta,data_x,data_y))

    theta_normal= normalization(data_x,data_y)
    theta_after = gradient_descent(data_x,data_y,theta,0.01,1500)[0]
    
    print(theta_normal)
    print(theta_after.shape)

    #PLOTTING FIGURE
    plt.scatter(data_x[:,1], data_y, label="Training Data")
    plt.plot(data_x[:,1], np.dot(data_x,theta_after), color="red", label="Linear Regression")
    plt.plot(data_x[:,1], np.dot(data_x,theta_normal),color="yellow", label="Normalization")
    
    plt.xlabel("Population of City in 10,000s")
    plt.ylabel("Profit in $10,000s")
    plt.legend()

    plt.tight_layout()
    plt.show()

    #Predict values for population sizes of 35,000
    predict = np.dot(theta_after,[1, 3.5])
    print("Predict is {:.2f}".format(predict*10000))