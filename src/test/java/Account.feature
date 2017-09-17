@current @regression @automation
Feature: Validate Account function
Scenario: Varify Account in Sales Force
Given user opens a browser 
And User navigates to "https://login.salesforce.com/"
When user enters user name as "USER_ULFAT" and password as "PASSWORD_ULFAT" 
##parameters in double quote above 
And user click on LogIn
And user sees the below objects
|Accounts|
Then user logs out of the current application