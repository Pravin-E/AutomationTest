package stepDefinations;


import RoverClass.Rover;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class stepDefination {

    private Rover     rover;
    private Exception exception;
    @Given ("^a rover is positioned at (\\d+) (\\d+) E$")
    public void aRoverIsPositionedAtE (int x, int y, String direction) {
        rover = new Rover();
        rover.setPosition(x, y, Integer.valueOf (direction));
    }

    @Given ("^a rover is positioned at (\\d+) (\\d+) N$")
    public void aRoverIsPositionedAtN (int x, int y, String direction) {
        rover = new Rover();
        rover.setPosition(x, y, Integer.valueOf (direction));
    }

    @When ("^the rover receives the command ABC$")
    public void theRoverReceivesTheCommandABC (String command) {
        try {
            rover.process(command);
        } catch (Exception e) {
            exception = e;
        }
    }

    @When ("^the rover receives the command LMLMLMLMM$")
    public void theRoverReceivesTheCommandLMLMLMLMM (String command) {
        try {
            rover.process(command);
        } catch (Exception e) {
            exception = e;
        }
    }

    @When ("^the rover receives the command MMRMMRMRRM$")
    public void theRoverReceivesTheCommandMMRMMRMRRM (String command) {
        try {
            rover.process(command);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then ("^an exception should be thrown$")
    public void anExceptionShouldBeThrown () {
        Assert.assertNotNull(exception);
    }

    @Then ("^the rover should be at (\\d+) (\\d+) E$")
    public void theRoverShouldBeAtE (int x, int y,String direction) {
        Assert.assertEquals(x, rover.getX());
        Assert.assertEquals(y, rover.getY());
        Assert.assertEquals(direction, rover.getDirection());
    }

    @Then ("^the rover should be at (\\d+) (\\d+) N$")
    public void theRoverShouldBeAtN (int x, int y,String direction) {
        Assert.assertEquals(x, rover.getX());
        Assert.assertEquals(y, rover.getY());
        Assert.assertEquals(direction, rover.getDirection());
    }
}
