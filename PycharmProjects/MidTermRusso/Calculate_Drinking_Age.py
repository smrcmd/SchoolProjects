__author__ = 'Sophie'
def drinking_age():
#creates a function
    bar_goer = eval(raw_input("What is your age?"))
    if bar_goer >= 21:
        #says if the bargoer is 21 or over they can be served the liquid candy
        print "give alcohol"
    else:
        print "deny alcohol"

drinking_age()
#calls the function drinking_age