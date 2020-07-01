import requests

def combination(data):
    compare = []
    for i in range(len(data) - 1):
        for j in range(i + 1, len(data)):
            compare.append(data[i] + "+" + data[j])
    return compare

def analyze(mons, database):
    ladder = dict(zip(mons, [0] * 5))
    for data in database:
        r = requests.get(url = "https://ob6la3c120.execute-api.ap-northeast-1.amazonaws.com/Prod/battle/" + data)
        result = r.text
        winner = r.text.split("\"")[3]
        loser = r.text.split("\"")[7]
        ladder[winner] += 1
    sort_ladder = sorted(ladder.items(), key = lambda item : item[1], reverse = True)
    print([x[0] for x in sort_ladder])

if __name__ == "__main__":
    mons = ["dragon", "griffin", "medusa", "troll", "vampire"]
    analyze(mons, combination(mons))
    