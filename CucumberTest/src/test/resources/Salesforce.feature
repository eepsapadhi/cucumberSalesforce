

Feature:  login to salesforce application

  Scenario: login with valid username and invalid password
      Given user is on login page
      When user enters "eepsa@force.com" into username field
      When user enters "   " into password field
      When user click on login button
      Then verify the error message "Please enter your password."
 
  Scenario: login with valid username and invalid password
     Given user is on login page
     When user enters "eepsa@force.com" into username field
     When user enters "padhi1990" into password field
     When user click on login button
     Then verify page title "Home Page ~ Salesforce - Devloper Edition"

  Scenario: check remember me
   Given user is on login page
    When user enters "eepsa@force.com" into username field
    When user enters "padhi1990" into password field
    When user click on check remember me button
    When user click on login button
    Then user click on usermenu dropdown button
   And  user click on logout button
    Then Validate the user name displayed in user name field
    
  Scenario: forget password
     Given user is on login page
     When user click on forget password 
     When Provide "eepsa@force.com" in salesforce forgot password page 
     And click on contiue button
     Then Password reset message page is displayed
   
  Scenario: forget password2
     Given user is on login page
     When user enters "123" into username field
     When user enters "22131" into password field
     When user click on login button
     Then error message should be displayed