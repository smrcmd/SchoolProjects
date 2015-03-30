__author__ = 'Sophie'
letters = "HAKJFAOSDIJKFJAKLDJFKASJFUIEWIJEWLLOOBADKLEWIQWORPOBNZCYM"
free = [letters[9], " ", letters[1], letters[56], " ", letters[4], letters[48], letters[31], letters[31]]
#creates a list of letters at specific locations to make "i am free"
hello = [letters[0], letters[27], letters[33], letters[34], letters[35]]
#creates a list of letters at specific locations to make "HELLO"

for item in hello:
    print item,
    #the comma allows for all the items in the list to be printed on the same line
print
#adds in a line break
for item in free:
    print item.lower(),
    #prints the "free" variable lowercase... again with the comma
print
#adds in a line break

print len(letters)
#prints the length of the string of letters

