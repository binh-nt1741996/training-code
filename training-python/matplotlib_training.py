import matplotlib.pyplot as plt 
import numpy as np 

if __name__ == "__main__":
    plt.style.use("seaborn")
    link = "https://raw.githubusercontent.com/sbu-python-summer/python-tutorial/master/day-4/nasa-giss.txt"
    data = np.loadtxt(link, delimiter = "     ")
    year = data[:,0]
    temp_change = data[:,1]
    smooth = data[:,2]
    
    fig, ax = plt.subplots(2,1, sharex=True)
    ax[0].plot(year, smooth)
    ax[1].scatter(year[np.where(temp_change > 0)], temp_change[np.where(temp_change > 0)], color = "blue")
    ax[1].scatter(year[np.where(temp_change < 0)], temp_change[np.where(temp_change < 0)], color = "red")

    ax[0].set_title("Smoothed representation of the temperature change")
    ax[1].set_title("Temperature change (no smoothing)")
    ax[1].set_xlabel("Year")
    ax[0].set_ylabel("Temperature change")
    ax[1].set_ylabel("Temperature change")
    plt.tight_layout()
    plt.show()