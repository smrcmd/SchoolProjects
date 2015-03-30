__author__ = 'Sophie'
stl_tax = 0.06
tip_1 = 0.10
tip_2 = 0.15
tip_3 = 0.20
#these items are variables that are used in my tip_calculator

def tip_calculator():
    cost_of_meal = eval(raw_input("Enter the cost of your meal"))
    #asks for raw user input and allows for input to be numbers or strings
    tip_amount = eval(raw_input("Enter tip amount"))
    #asks for user to input how much they want to tip
    if tip_amount == 0.20:
        tip_total = ((cost_of_meal + cost_of_meal * stl_tax)*tip_3)
        #adds the meal and the STL sales tax, then calculates tip
        print cost_of_meal+stl_tax+tip_total
        #prints the total of the meal (with tax) and tip
    elif tip_amount == 0.15:
        tip_total = ((cost_of_meal + cost_of_meal * stl_tax)*tip_2)
        print cost_of_meal+stl_tax+tip_total
    elif tip_amount == 0.10:
        tip_total = ((cost_of_meal + cost_of_meal * stl_tax)*tip_1)
        print cost_of_meal+stl_tax+tip_total
    else:
        print "Please enter .10, .15 or .20"
        #if a user didn't say the right amount to tip it gives the options

tip_calculator()
#calls the function