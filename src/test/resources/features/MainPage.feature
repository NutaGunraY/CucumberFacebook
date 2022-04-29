Feature: Check All features on main page
  Background:
    Given the main page
    Scenario: Checking the left side list
      When clicks on more button which is on the left side of the page
      Then validate all the links
    Scenario: Does search bar work
      When sees the search bar
      Then enter a text in bar
    Scenario: Does links on the top work
      When sees links on the top
      Then validate all links
    Scenario: Are hud buttons working
      When sees the hud buttons
      Then validate all hud buttons