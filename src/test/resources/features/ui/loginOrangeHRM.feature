@Login
  Feature: Login on Website OrangeHRM

    Scenario: Success login using valid credentials
      Given [user] opens website using the endpoint "https://opensource-demo.orangehrmlive.com"
      When [user] fill valid username with value 'Admin'
      And [user] fill valid password with value 'admin123'
      And [user] click button Login
#      Then verify user navigate to "dashboard" page