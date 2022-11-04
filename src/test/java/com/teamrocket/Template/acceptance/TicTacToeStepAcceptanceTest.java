package com.teamrocket.Template.acceptance;

import com.teamrocket.Template.game.GameFrame;
import com.teamrocket.Template.game.TicTacToe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TicTacToeStepAcceptanceTest {

    @Autowired
    private GameFrame gameFrame;
    private TicTacToe ticTacToe;
    private String playersSign;
    private String player;
    private int x;
    private int y;


    @Given("A Game Frame")
    public void a_game_frame() {
        assertNotNull(gameFrame);
    }

    @When("Player starts new game")
    public void player_starts_new_game() {
        ticTacToe = gameFrame.startNewGame("X", "O");
    }

    @Then("New Game is started")
    public void new_game_is_started() {
        assertTrue(ticTacToe.getComputer().equals("O") && ticTacToe.getPlayer().equals("X"));
    }

    @When("Choosing who starts")
    public void setting_up_new_game() {

        playersSign = gameFrame.assignSignToPlayer();
    }

    @Then("The one who starts should be chosen randomly")
    public void the_one_who_starts_should_be_chosen_randomly() {
        assertTrue(playersSign.equals("X") || playersSign.equals("O"));
    }

    @Given("a TicTacToe game and player with {string}")
    public void a_tic_tac_toe_game_and_player_with(String string) {
        player = string;
        ticTacToe = gameFrame.startNewGame(player, "c");
    }

    @When("player puts a sign on one {int}")
    public void player_puts_a_sign_on_one(Integer field) {
        gameFrame.makeMove(ticTacToe, player, field);
    }

    @Then("the {string} should be on {int}, {int}")
    public void the_should_be_on(String string, Integer x, Integer y) {
        assertEquals(ticTacToe.getField(x, y), string);
    }
}
