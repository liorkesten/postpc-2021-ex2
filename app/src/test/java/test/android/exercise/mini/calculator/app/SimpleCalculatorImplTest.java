package test.android.exercise.mini.calculator.app;

import android.exercise.mini.calculator.app.SimpleCalculatorImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SimpleCalculatorImplTest {

  private SimpleCalculatorImpl calculator;
  @Before
  public void setupBeforeEachTest(){
    calculator = new SimpleCalculatorImpl();
  }

  @Test
  public void when_noInputGiven_then_outputShouldBe0(){
    assertEquals("0", calculator.output());
  }

  @Test
  public void when_inputIsPlus_then_outputShouldBe0Plus(){
    calculator.insertPlus();
    assertEquals("0+", calculator.output());
  }


  @Test
  public void when_inputIsMinus_then_outputShouldBeCorrect(){
    calculator.insertMinus();
    String expected = "0-";
    assertEquals(expected, calculator.output());
  }

  @Test
  public void when_callingInsertDigitWithIllegalNumber_then_exceptionShouldBeThrown(){
    try {
      calculator.insertDigit(357);
      fail("should throw an exception and not reach this line");
    } catch (RuntimeException e) {
      // good :)
    }
  }


  @Test
  public void when_callingDeleteLast_then_lastOutputShouldBeDeleted(){
    calculator.insertDigit(4);
    calculator.deleteLast();
    assertEquals("0",calculator.output());
  }

  @Test
  public void when_callingClear_then_outputShouldBeCleared(){
    calculator.insertDigit(4);
    calculator.insertPlus();
    calculator.insertDigit(2);
    calculator.clear();

    assertEquals("0",calculator.output());
  }

  @Test
  public void when_savingState_should_loadThatStateCorrectly(){
    // give some input
    calculator.insertDigit(5);
    calculator.insertPlus();
    calculator.insertDigit(7);

    // save current state
    Serializable savedState = calculator.saveState();
    assertNotNull(savedState);

    // call `clear` and make sure calculator cleared
    calculator.clear();
    assertEquals("0", calculator.output());

    // load the saved state and make sure state was loaded correctly
    calculator.loadState(savedState);
    assertEquals("5+7", calculator.output());
  }

  @Test
  public void when_savingStateFromFirstCalculator_should_loadStateCorrectlyFromSecondCalculator(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();
    // TODO: implement the test based on this method's name.
    //  you can get inspiration from the test method `when_savingState_should_loadThatStateCorrectly()`
  }


  // TODO:
  //  the existing tests are not enough since they only test simple use-cases with small inputs.
  //  write at least 10 methods to test correct behavior with complicated inputs or use-cases.
  //  examples:
  //  - given input "5+7-13<DeleteLast>25", expected output is "5+17-125"
  //  - given input "9<Clear>12<Clear>8-7=", expected output is "1"
  //  - given input "8-7=+4=-1=", expected output is "4"
  //  - given input "999-888-222=-333", expected output is "-111-333"
  //  - with 2 calculators, give them different inputs, then save state on first calculator and load the state into second calculator, make sure state loaded well
  //  etc etc.
  //  feel free to be creative in your tests!

  @Test
  public void when_evaluteAndThenAddNegativeNumber_should_sumOfTwoNegatives(){
    calculator.insertDigit(9);
    calculator.insertDigit(9);
    calculator.insertDigit(9);
    calculator.insertMinus();
    calculator.insertDigit(8);
    calculator.insertDigit(8);
    calculator.insertDigit(8);
    calculator.insertMinus();
    calculator.insertDigit(2);
    calculator.insertDigit(2);
    calculator.insertDigit(2);
    calculator.insertEquals();
    calculator.insertMinus();
    calculator.insertDigit(3);
    calculator.insertDigit(3);
    calculator.insertDigit(3);

    assertEquals("-111-333",calculator.output());
  }
  @Test
  public void when_addFormulaAndThenEqual_should_one_number(){
    calculator.insertDigit(2);
    calculator.insertPlus();
    calculator.insertDigit(3);
    calculator.insertEquals();

    assertEquals("5",calculator.output());
  }

  @Test
  public void when_addTwoPluses_shouldNot_addSecondPlus(){
    calculator.insertDigit(2);
    calculator.insertPlus();
    calculator.insertPlus();

    assertEquals("2+",calculator.output());
  }


  @Test
  public void when_addMinusAfterPlus_shouldNot_addPlus(){
    calculator.insertDigit(2);
    calculator.insertPlus();
    calculator.insertMinus();

    assertEquals("2+",calculator.output());
  }


  @Test
  public void when_addEqualAfterPlus_shouldNot_containPlus(){
    calculator.insertDigit(2);
    calculator.insertPlus();
    calculator.insertEquals();

    assertEquals("2",calculator.output());
  }

  @Test
  public void when_addEqualAfterMinus_shouldNot_containMinus(){
    calculator.insertDigit(2);
    calculator.insertMinus();
    calculator.insertEquals();

    assertEquals("2",calculator.output());
  }


  @Test
  public void when_deleteLastTwiceInRow_should_deleteLastTwoItems(){
    calculator.insertDigit(1);
    calculator.insertMinus();
    calculator.insertDigit(3);
    calculator.insertDigit(3);
    calculator.deleteLast();
    calculator.deleteLast();

    assertEquals("1-",calculator.output());
  }

  @Test
  public void when_deleteLastInMidOfFormula_should_deleteMidDigit(){
    calculator.insertDigit(5);
    calculator.insertPlus();
    calculator.insertDigit(7);
    calculator.insertMinus();
    calculator.insertDigit(1);
    calculator.insertDigit(3);
    calculator.deleteLast();
    calculator.insertDigit(2);
    calculator.insertDigit(5);

    assertEquals("5+7-125",calculator.output());
  }

}