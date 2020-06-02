import numpy as np
import math as m
import matplotlib.pyplot as plt

def myfunc(x, n, d):
    return m.sqrt(2 / d) * m.sin(n * m.pi * x/d)

if __name__  == "__main__":
    N = np.arange(1, 5)
    d = int(input("Enter d: "))
    X = np.linspace(0, 2, 100)
    Y = [[myfunc(x, n, d) for x in X] for n in N]
    Y = np.array(Y)
    for i in range(Y.shape[0]):
        plt.plot(X, Y[i])
    #plt.plot(X, Y, "r")
    plt.show()
