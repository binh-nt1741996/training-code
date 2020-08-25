from gtts import gTTS

import os

mytext = "A further 26 people who tested positive for Covid-19 have died, bringing the total number of confirmed reported deaths in hospitals in England"
language = "en"

myobj = gTTS(text = mytext, lang = language, slow = False)
myobj.save("welcome.mp3")
os.system("mpyg321 welcome.mp3")
