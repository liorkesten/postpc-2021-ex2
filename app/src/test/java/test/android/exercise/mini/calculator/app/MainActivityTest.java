package test.android.exercise.mini.calculator.app;

import android.exercise.mini.calculator.app.MainActivity;
import android.exercise.mini.calculator.app.R;
import android.exercise.mini.calculator.app.SimpleCalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.io.Serializable;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {28})
public class MainActivityTest {

  private static final String DEFAULT_CALCULATOR_OUTPUT = "~~~ ready to start ~~~";

  private ActivityController<MainActivity> activityController;
  private MainActivity activityUnderTest;
  private SimpleCalculator mockCalculator;

  /** initialize main activity with a mock calculator */
  @Before
  public void setup(){
    mockCalculator = Mockito.mock(SimpleCalculator.class);
    Mockito.when(mockCalculator.output()).thenReturn(DEFAULT_CALCULATOR_OUTPUT);

    activityController = Robolectric.buildActivity(MainActivity.class);
    activityUnderTest = activityController.get();
    activityUnderTest.calculator = mockCalculator;
    activityController.create().start().resume();
  }

  @Test
  public void when_settingUpTheActivity_then_itShouldShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = DEFAULT_CALCULATOR_OUTPUT;
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    // verify
    assertEquals(expectedText, activityMainTextView.getText().toString());
  }

  @Test
  public void when_userClicksButtonPlus_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button PLUS clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View buttonPlus = activityUnderTest.findViewById(R.id.buttonPlus);

    // test
    buttonPlus.performClick();

    // verify
    Mockito.verify(mockCalculator).insertPlus(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }

  // TODO: add tests for clicks on all buttons
  @Test
  public void when_userClicksButtonMinus_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button MINUS clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.buttonMinus).performClick();

    // verify
    Mockito.verify(mockCalculator).insertMinus(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void when_userClicksButtonEquals_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button EQUALS clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.buttonEquals).performClick();

    // verify
    Mockito.verify(mockCalculator).insertEquals(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }

  @Test
  public void when_userClicksButtonClear_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button Clear clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.buttonClear).performClick();

    // verify
    Mockito.verify(mockCalculator).clear(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }

  @Test
  public void when_userClicksButtonBackSpace_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button BACKSPACE clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.buttonBackSpace).performClick();

    // verify
    Mockito.verify(mockCalculator).deleteLast(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }


  @Test
  public void when_userClicksButtonZero_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button ZERO clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.button0).performClick();

    // verify
    Mockito.verify(mockCalculator).insertDigit(0); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void when_userClicksButtonOne_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button ONE clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.button1).performClick();

    // verify
    Mockito.verify(mockCalculator).insertDigit(1); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void when_userClicksButtonTWO_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button TWO clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.button2).performClick();

    // verify
    Mockito.verify(mockCalculator).insertDigit(2); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void when_userClicksButtonThree_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button THREE clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.button3).performClick();

    // verify
    Mockito.verify(mockCalculator).insertDigit(3); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void when_userClicksButtonFour_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button FOUR clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.button4).performClick();

    // verify
    Mockito.verify(mockCalculator).insertDigit(4); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void when_userClicksButtonFive_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button FIVE clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.button5).performClick();

    // verify
    Mockito.verify(mockCalculator).insertDigit(5); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void when_userClicksButtonSix_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button SIX clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.button6).performClick();

    // verify
    Mockito.verify(mockCalculator).insertDigit(6); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void when_userClicksButtonSeven_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button SEVEN clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.button7).performClick();

    // verify
    Mockito.verify(mockCalculator).insertDigit(7); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void when_userClicksButtonEight_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button EIGHT clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.button8).performClick();

    // verify
    Mockito.verify(mockCalculator).insertDigit(8); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void when_userClicksButtonNine_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button NINE clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);

    // test
    activityUnderTest.findViewById(R.id.button9).performClick();

    // verify
    Mockito.verify(mockCalculator).insertDigit(9); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }

  @Test
  public void when_activityGetsStateSaved_then_shouldAlsoSaveCalculatorState() {
    // setup
    Serializable dummyState = new Serializable() {};
    Mockito.when(mockCalculator.saveState()).thenReturn(dummyState);

    Bundle spyBundle = Mockito.spy(new Bundle());

    // test
    activityController.saveInstanceState(spyBundle);

    // verify
    Mockito.verify(spyBundle).putSerializable(anyString(), eq(dummyState)); // make sure that the activity stored the calculator state into the spy bundle
  }


  @Test
  public void when_activityGetsStateRestored_then_shouldAlsoSaveCalculatorState() {
    // setup
    Serializable dummyState = new Serializable() {};
    Mockito.when(mockCalculator.saveState()).thenReturn(dummyState);

    // let the activity store the calculator state into the bundle
    Bundle spyBundle = Mockito.spy(new Bundle());
    activityController.saveInstanceState(spyBundle);

    // test
    activityController.restoreInstanceState(spyBundle);

    // verify
    Mockito.verify(mockCalculator).loadState(eq(dummyState)); // make sure that the activity passed the previously-stored state to the calculator to load
  }
}