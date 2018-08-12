@Etsy
Feature: Etsy product search
  I want to use this feature to seacrh Etsy products

  @tag1
  Scenario: Etsy search for an item
    Given User is on Etsy homepage
    When User searches for "wooden spoon"
    Then Search results should be displayed

