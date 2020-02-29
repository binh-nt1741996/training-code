import numpy as np 
import matplotlib.pyplot as plt 
from scipy import optimize

def plotData(dataX, dataY):
    plt.style.use("seaborn")
    fig = plt.figure()
    pos = dataY == 1
    neg = dataY == 0
    plt.plot(dataX[pos,0], dataX[pos,1], "k*", lw=1, ms=10)
    plt.plot(dataX[neg,0], dataX[neg,1], "ko", mfc='y', ms=8, mec='k', mew=1)

def sigmoid(z):
    z = np.array(z)
    g = 1 / (1 + np.exp(-z))
    return g 
def costFunction(theta, dataX, dataY):
    m = len(dataY)
    h = sigmoid(dataX.dot(theta.T))
    J = (1/m) * np.sum(-dataY.dot(np.log(h)) - (1-dataY).dot(np.log(1-h)))
    grad = (1/m) * np.dot(h- dataY, dataX)
    return J, grad 

def optimize_scipy(initial_theta, dataX, dataY):
    #set options for optimizers
    options = {"maxiter": 400}
    # see documention for scipy's optimize.minimize  for description about
    # the different parameters
    # The function returns an object `OptimizeResult`
    # We use truncated Newton algorithm for optimization which is 
    # equivalent to MATLAB's fminunc
    # See https://stackoverflow.com/questions/18801002/fminunc-alternate-in-numpy
    res = optimize.minimize(costFunction, 
                            initial_theta, 
                            (dataX, dataY),
                            jac=True,
                            method='TNC',
                            options=options)
    #the fun property returns the value of costFunction at optimized theta
    cost = res.fun
    #the optimized theta is in x property
    theta = res.x
    print("Cost at theta found by scipy optimize minimize: {:.4f}".format(cost))
    print("Optimized theta: {:.3f} {:.3f} {:.3f}".format(*theta))
    return theta

def plotDecisionBoundary(plotData, theta, X, y):
    """
    Plots the data points X and y into a new figure with the decision boundary defined by theta.
    Plots the data points with * for the positive examples and o for  the negative examples.
    Parameters
    ----------
    plotData : func
        A function reference for plotting the X, y data.
    theta : array_like
        Parameters for logistic regression. A vector of shape (n+1, ).
    X : array_like
        The input dataset. X is assumed to be  a either:
            1) Mx3 matrix, where the first column is an all ones column for the intercept.
            2) MxN, N>3 matrix, where the first column is all ones.
    y : array_like
        Vector of data labels of shape (m, ).
    """
    # make sure theta is a numpy array
    theta = np.array(theta)

    # Plot Data (remember first column in X is the intercept)
    plotData(X[:, 1:3], y)

    if X.shape[1] <= 3:
        # Only need 2 points to define a line, so choose two endpoints
        plot_x = np.array([np.min(X[:, 1]) - 2, np.max(X[:, 1]) + 2])

        # Calculate the decision boundary line
        plot_y = (-1. / theta[2]) * (theta[1] * plot_x + theta[0])

        # Plot, and adjust axes for better viewing
        plt.plot(plot_x, plot_y)

        # Legend, specific for the exercise
        plt.legend(['Admitted', 'Not admitted', 'Decision Boundary'])
        plt.xlim([30, 100])
        plt.ylim([30, 100])

if __name__ == "__main__":
    data = np.loadtxt("ex2data1.txt", delimiter=",")
    dataY = data[:, 2]
    m = len(dataY)
    dataX = np.concatenate((np.ones((m,1)), data[:,:2]), axis=1)
    
    plotData(dataX[:,1:3], dataY)
    plt.legend(["Admitted", "Not admitted"])
    plt.xlabel("Exam 1 score")
    plt.ylabel("Exam 2 score")

    print(sigmoid(0))
    #Initialize fitting parameters
    initial_theta = np.zeros(3)
    cost, grad = costFunction(initial_theta, dataX, dataY)
    print("Cost at initial theta zeros: {:.3f}".format(cost))
    print("Gradient at initial theta zeros: {:.4f} {:.4f} {:.4f}".format(*grad))
    
    #Compute and display cost and gradient with non-zero theta
    test_theta = np.array([-24, 0.2, 0.2])
    cost, grad = costFunction(test_theta, dataX, dataY)
    print("Cost at test theta: {:.3f}".format(cost))
    print("Gradient at test theta: {:.4f} {:.4f} {:.4f}".format(*grad))

    theta = optimize_scipy(initial_theta, dataX, dataY)
    plotDecisionBoundary(plotData, theta, dataX, dataY)
    plt.show()