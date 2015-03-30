__author__ = 'Sophie'
#first we will define all of the functions that will do the converting
def dollars_convert():
    dollars=eval(raw_input("What is the dollar amount?"))
    #prompts user to enter a numerical amount
    euros = 0.79 * dollars
    print euros

def kilogram_convert():
    kilogram = eval(raw_input("What is the kilogram amount?"))
    pounds = kilogram * 2.20
    print pounds

def liters_convert():
    liters = eval(raw_input("What is the liters amount?"))
    gallons = liters * 0.26
    print gallons

#this is our main function that will call the others when the user enters an answer
def what_to_convert():
    question = str(raw_input("What can I convert for you?"))
    #the user enters a string which is why we include the str instead of eval
    if question == "dollars":
        dollars_convert()
    elif question == "kilograms":
        kilogram_convert()
    elif question == "liters":
        liters_convert()
    else:
        print "Please enter dollars, kilograms or liters"

what_to_convert()
#calls the function