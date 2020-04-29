import urllib3
if __name__ == "__main__":
    url = "https://raw.githubusercontent.com/suraggupta/coursera-machine-learning-solutions-python/master/Exercise2/Data/ex2data1.txt"
    data = urllib3j.urlopen(url)
    with open("ex2data.txt", "w") as file2:
        file2.writelines(data)
