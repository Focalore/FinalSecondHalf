package com.example.finalsecondhalf;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameController {

    public Button attackButton, doNothingButton, quitButton;

    public int enemyDeathCount, enemyHealth, highScore;

    public Label gameStatusLabel, highScoreLabel, HPLabel, effectLabel, winnerWinnerChickenDinner;
    public void enemy(String enemyStatus, int enemyHealth) {
            gameStatusLabel.setText("a " + enemyStatus + " has appeared with " + enemyHealth + " health");
            if (enemyHealth == 0) {
                gameStatusLabel.setText("nothing has appeared, you have a moment to rest.");
            }
    }

    public void enemyHPCount(int enemyHealth){
        HPLabel.setText("The enemy has " + enemyHealth + " health remaining.");
        if (enemyHealth <= 0) {
            HPLabel.setText("The enemy has 0 HP remaining.");
        }
    }

    public void attack(ActionEvent event) {
        quitButton.setDisable(true);
        effectLabel.setText("");
        if (enemyHealth <= 1) {
            enemyDeathCount += 1;
            highScoreLabel.setText("current score: " + enemyDeathCount);
            attackButton.setVisible(false);
            doNothingButton.setVisible(false);
        }
        Random rand = new Random();
        int randInt = rand.nextInt(11);
        if (randInt == 0) {
            enemyHealth -= 3;
            effectLabel.setText("Critical Hit!");
        } else enemyHealth -= 1;
        enemyHPCount(enemyHealth);

    }

    public void walk() {
        if (enemyDeathCount >= 3){
            quitButton.setDisable(false);
            victory();
        }
        attackButton.setVisible(true);
        doNothingButton.setVisible(true);
        HPLabel.setText("");
        effectLabel.setText("You have moved forward");
        highScore += 1;
        Random rand = new Random();
        int randInt = rand.nextInt(0, 5);
        if (randInt == 0) {
            attackButton.setVisible(false);
            doNothingButton.setVisible(false);
            gameStatusLabel.setText("nothing has appeared, you may rest");
            enemyDeathCount += 1;
            highScoreLabel.setText("current score: " + enemyDeathCount);
        } else {
            enemyStatus();
        }
    }

    public void nothing() {
        effectLabel.setText("you have rested, but so has your foe");
        enemyHealth += 1;
        enemyHPCount(enemyHealth);

    }

    public void victory() {
            winnerWinnerChickenDinner.setText("you have won, and may return at any time.");
            quitButton.setDisable(false);

    }

    public void quit(ActionEvent event) {
        Button caller = (Button) event.getSource();
        Stage window = (Stage)caller.getScene().getWindow();
        window.close();
    }

    public void enemyStatus() {
        Random rand = new Random();
        int randInt = rand.nextInt(35);
        enemyHealth = randInt;
        String thing = "";
        if (randInt == 0) {
            return;
        }
        else if (randInt <= 5) {
            thing = "slime";

        } else if (randInt <= 15) {
            thing = "Wild Animal";

        } else if (randInt <= 25) {
            thing = "kobold";

        } else if (randInt <= 34) {
            thing = "Challenging foe";

        }
        enemy(thing, randInt);

    }
}
