import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

x = np.arange(20)
plt.plot(x,x*2,label="line 1", ls=":")
plt.plot(x,x*3,label="line 2", ls="--")

plt.legend()
plt.xlabel("x axis")
plt.ylabel("y axis")
plt.title("Sample graph")
plt.show()
