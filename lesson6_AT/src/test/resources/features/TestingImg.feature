Feature: Automation test (IMG Checking):

  Scenario: Navigate to the Rest-assured page
    When Navigate to the 'https://www.jenkins.io/'
    Then Verify that the current img has .png format