Feature: Automation test (Download):

  Scenario: Navigate to the Rest-assured page
    Given Open browser and maximize window
    When Navigate to the 'https://rest-assured.io/'
    And Click to the DOCS tab
    And Click to the Downloads tab
    Then Verify that the Downloads text is shown
    Then Verify that the current URL is 'https://github.com/rest-assured/rest-assured/wiki/Downloads'
    Then Verify that the table has two columns and eight rows