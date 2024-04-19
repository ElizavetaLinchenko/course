Feature: Testing numbers

  Scenario Outline: Testing numbers value:
    Then Test that the number from the <first> column is bigger than the number from the <second> column
    Examples:
      | first | second |
      | 10    | 20     |
      | 5     | 16     |