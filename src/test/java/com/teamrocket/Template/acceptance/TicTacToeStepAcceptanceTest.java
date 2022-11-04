package com.teamrocket.Template.acceptance;

import com.teamrocket.Template.game.GameFrame;
import com.teamrocket.Template.game.TicTacToe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class TicTacToeStepAcceptanceTest {

    @Autowired
    private GameFrame gameFrame;
    private TicTacToe ticTacToe;
    private String playersSign;


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
}
