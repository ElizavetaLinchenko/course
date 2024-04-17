Feature: Automation test (GettingStarted):

  Scenario: Navigate to the Rest-assured page
    Given Open browser and maximize window
    When Navigate to the 'https://rest-assured.io/'
    And Click to the DOCS tab
    And Click to the GettingStarted tab
    Then Verify that the GettingStarted text is shown
    Then Verify that the current URL is 'https://github.com/rest-assured/rest-assured/wiki/GettingStarted'