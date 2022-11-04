Feature: Player can start the game

  Scenario:
    Given A Game Frame
    When Choosing who starts
    Then The one who starts should be chosen randomly

  Scenario:
    Given A Game Frame
    When Player starts new game
    Then New Game is started


