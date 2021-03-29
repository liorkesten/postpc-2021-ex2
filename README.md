I pledge the highest level of ethical principles in support of academic excellence.  
I ensure that all of my work reflects my own abilities and not those of someone else.
#Question
Answer this hypothetical question in the README file:

Saying we want to add a cool feature - button "x" to run multiplication.
What code do we need to change/add/remove to support this feature?
Which tests can we run on the calculator? On the activity? On the app?

## Answer
If we want to add button x that multiply the operands, we have to add to the UI button:
xml, image, and textview
In addition, we have to add it to the logic app, and consider the order of the operations (e.g "2+3*2) the 2*3 suppsosed to be calculated before the 2+
so we can evaluate the formula with stack.
We would like to add as well tests for all the parts of our program:
1. calculator tests - add tests that check the behavior of the new operator, and also check the order of the operation.
2. Activity tests - add tests like the tests that we wrote to plus and minus operators.
3. flow tests - we should add flow tests that combine few operators. 
# AndroidCalculator - Calculator exercise for Android developers

## In this project:
- Calculator screen with XML ready for portrait and landscape
- Calculator interface used by the Activity
- Unit tests for the calculator and the activity

## Your job:
- Implement `SimpleCalculatorImpl.java`
- add more unit tests to `SimpleCalculatorImpl.java`
- Implement `MainActivity.java`
- add more unit tests to `MainActivityTest.java`
- add more flow tests to `AppFlowTest.java`

Basically look for "TODO" in the code.


Good luck!