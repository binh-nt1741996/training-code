import matplotlib.pyplot as plt
from matplotlib import rcParams
import numpy as np 
import pandas as pd 
from collections import Counter

def extract_data(data):
    data = [i[4:11] for i in data]
    data = Counter(data)
    data = sorted(data.items())
    return [i[1] for i in data]
def add_zero_category(*data):
    for i in data:
        if len(i) < 7:
            for j in range(7-len(i)):
                i.append(0)

if __name__ == "__main__":
    plt.style.use("grayscale")
    igfont = {'family':'IPAexGothic'}
    rcParams['font.family'] = 'sans-serif'
    rcParams['font.sans-serif'] = ['Hiragino Maru Gothic Pro', 'Yu Gothic', 'Meirio', 'Takao', 'IPAexGothic', 'IPAPGothic', 'VL PGothic', 'Noto Sans CJK JP']
    plt.figure(figsize=(8,6))
    with open("kou1.txt","r") as read1:
        data1 = read1.readlines()
    with open("kou2.txt","r") as read2:
        data2 = read2.readlines()
    with open("kou3.txt","r") as read3:
        data3 = read3.readlines()

    ages1 = extract_data(data1)
    ages2 = extract_data(data2)
    ages3 = extract_data(data3)
    add_zero_category(ages1,ages2,ages3)
    
    x_index = np.arange(7)
    width = 0.25
    x_labels = ["0-24", "25-34", "35-44", "45-54", "55-64", "65-74", "75以上"]
    plt.bar(x_index-width, ages1, width=width, color="blue")
    plt.bar(x_index, ages2, width=width, color="red")
    plt.bar(x_index+width, ages3, width=width, color="green")

    plt.xticks(ticks=x_index, labels=x_labels)
    plt.xlabel("年齢")
    plt.ylabel("人数")
    plt.legend(["寿町","高松市天神前","峰山口"],fontsize="small")
    plt.grid(False)
    plt.title("当事者の年齢")
    plt.tight_layout()
    plt.savefig("meow.png")
    plt.show()

