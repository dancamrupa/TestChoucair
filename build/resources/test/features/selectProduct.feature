Feature: The user enters the online page
  of Exito and selects a product at random

  Scenario Outline: User selects a random product
    Given The user enters the online page of Exito
    When the user chooses <number> products randomly
    Then The user will be able to validate the products selected in the shopping cart
    Examples:
      | number |
      | 5      |