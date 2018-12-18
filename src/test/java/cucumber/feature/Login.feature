Feature:Facebook application
In order to access facebook application
As a admin login
I want to Login

Background: 
Given I open "<URL>" on "<Browser>"

Scenario Outline: Facebook application

And I enter "<Object>" as "gokul"
And I enter "<Object1>" as "Seetha"
And I click "<Action>" button
Then login should be "<Result>"


Examples:
| URL  | Browser  |  Object   | Object1    | Action | Result  |
| url  | Browser  |  username   | password | signin | Success |
| url  | Browser  |  username   | password | signin | Success |