Feature: Player can start the game

  Scenario:
    Given A Game Frame
    When Choosing who starts
    Then The one who starts should be chosen randomly

  Scenario:
    Given A Game Frame
    When Player starts new game
    Then New Game is started

  Scenario Outline:
    Given a TicTacToe game and player with "<sign>"
    When player puts a sign on one <field>
    Then the "<sign>" should be on <x>, <y>
    Examples:
      | sign | field | x | y |
      | X    | 1     | 0 | 0 |
      | X    | 2     | 0 | 1 |
      | X    | 3     | 0 | 2 |
      | X    | 4     | 1 | 0 |
      | X    | 5     | 1 | 1 |
      | X    | 6     | 1 | 2 |
      | X    | 7     | 2 | 0 |
      | O    | 8     | 2 | 1 |
      | O    | 9     | 2 | 2 |






