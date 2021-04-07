@regression
Feature: Validate log in function to TeamMaximo
Scenario: User able to login using valid username and password

Given open the browser
Then check the title of "IBM Maximo"
And enter valid user name
And enter valid password
And click the sign in button
And validate page title "Start Center"
#Then click on sign out button

