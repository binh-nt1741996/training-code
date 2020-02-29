import numpy as np 
import matplotlib.pyplot as plt 
from mpl_toolkits.mplot3d import Axes3D

def gradient_descent(dataX, dataY, theta, iter, alpha):
    m = len(dataY)
    J_history = []
    for i in range(iter):
        theta = theta - (alpha/m) * np.dot(np.dot(dataX, theta) - dataY, dataX)
        J_history.append(computeCost(dataX, dataY, theta))
    return theta, J_history

def plotData(dataX, dataY, theta, predict_input):
    plt.style.use("seaborn")

    plt.scatter(dataX[:,1], dataY, label="Training data", color="blue")
    
    plt.plot(dataX[:,1], np.dot(dataX, theta), label="Gradient Descent", color="red", linewidth=3)
    plt.scatter(predict_input/10_000, np.dot(np.stack((np.ones(2), predict_input/10_000), axis=1), descent_theta), label="Predict", color="green")

    plt.xlabel("Populations of area (10,000s)")
    plt.ylabel("Profits of area (10,000$)")

    plt.legend()
    plt.tight_layout()
    plt.show()
def computeCost(dataX, dataY, theta):
    m = len(dataY)
    cost = 1/(2*m) * np.sum((np.dot(dataX, theta) - dataY)**2)

    return cost

def surface_plot(dataX, dataY):
    theta0_vals = np.linspace(-10, 10, 100)
    theta1_vals = np.linspace(-1, 4, 100)

    # initialize J_vals to a matrix of 0's
    J_vals = np.zeros((theta0_vals.shape[0], theta1_vals.shape[0]))

    # Fill out J_vals
    for i, theta0 in enumerate(theta0_vals):
        for j, theta1 in enumerate(theta1_vals):
            J_vals[i, j] = computeCost(dataX, dataY, [theta0, theta1])
            
    # Because of the way meshgrids work in the surf command, we need to
    # transpose J_vals before calling surf, or else the axes will be flipped
    J_vals = J_vals.T

    # surface plot
    fig = plt.figure(figsize=(12, 5))
    ax = fig.add_subplot(121, projection='3d')
    ax.plot_surface(theta0_vals, theta1_vals, J_vals, cmap='viridis')
    plt.xlabel('theta0')
    plt.ylabel('theta1')
    plt.title('Surface')

    # contour plot
    # Plot J_vals as 15 contours spaced logarithmically between 0.01 and 100
    ax = plt.subplot(122)
    plt.contour(theta0_vals, theta1_vals, J_vals, linewidths=2, cmap='viridis', levels=np.logspace(-2, 3, 20))
    plt.xlabel('theta0')
    plt.ylabel('theta1')
    plt.plot(theta[0], theta[1], 'ro', ms=10, lw=2)
    plt.title('Contour, showing minimum')
    pass

if __name__ == "__main__":
    #Extract data from text file into dataX and dataY
    data = np.loadtxt("ex1data1.txt", delimiter=",")
    dataX = np.stack((np.ones(len(data[:,0])), data[:,0]), axis=1)              #Merge ones array into dataX's 1st axis
    dataY = data[:,1]

    #Initialize the parameter for hypothesis
    theta = np.zeros(2)
    print("Cost function's result is: {:.2f}".format(computeCost(dataX, dataY, theta)))

    descent_theta, J_history = gradient_descent(dataX, dataY, theta, 1500, 0.01)
    print("Estimated theta found by gradient descent is: {0:.3f} and {1:.3f}".format(*descent_theta))

    predict_input = np.array(list(map(int, input("Enter the populations of areas that you want to predict the profit: ").split(" "))))

    print("The estimated profit of area {0:,d} is {1:.2f}".format(predict_input[0], np.dot([1, predict_input[0]/10_000], descent_theta)))
    print("The estimated profit of area {0:,d} is {1:.2f}".format(predict_input[1], np.dot([1, predict_input[1]/10_000], descent_theta)))
    plotData(dataX, dataY, descent_theta, predict_input)
    #surface_plot(dataX, dataY)


    
