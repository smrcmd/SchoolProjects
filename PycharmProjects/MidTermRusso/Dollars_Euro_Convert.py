__author__ = 'Sophie'
def dollars_convert():
#creates the variable that will do the converting
    dollars=eval(raw_input("What is the dollar amount?"))
    euros = 0.79 * dollars
    #multiples the dollar amount by .79 (which is the conversion rate via google)
    print euros

dollars_convert()
#calls the variable