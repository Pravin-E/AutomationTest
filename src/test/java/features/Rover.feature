Feature: Mars Rover
  Scenario: Moving the rover
    Given a rover is positioned at 1 2 N
    When the rover receives the command LMLMLMLMM
    Then the rover should be at 1 3 N

  Scenario: Moving the rover in a different scenario
    Given a rover is positioned at 3 3 E
    When the rover receives the command MMRMMRMRRM
    Then the rover should be at 5 1 E

  Scenario: Invalid command received by the rover
    Given a rover is positioned at 0 0 N
    When the rover receives the command ABC
    Then an exception should be thrown