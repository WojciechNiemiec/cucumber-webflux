Feature: I can stream

  Scenario: When I query stream I obtain stream
    When I query stream
    Then I obtain 3 elements
