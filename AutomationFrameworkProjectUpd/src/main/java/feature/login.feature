Feature: Application Login

Scenario: Login with valid credentials
Given Open any Browser
And Navigate to Login page
When User enters username as "testpm@test.com" and password as "test" into the fields
Then Verify user is able to successfully login