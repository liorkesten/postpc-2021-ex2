package android.exercise.mini.calculator.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class SimpleCalculatorImpl implements SimpleCalculator {
  private static final Set<String> OPERATORS = new HashSet<String>() {{
    add("+");
    add("_");
  }};
  private final List<String> history = new ArrayList<>();
  private final List<Integer> equalsIndexes = new Stack<>();
  private final List<Integer> lastCalculatedNumber = new Stack<>();
  // todo: add fields as needed
  public SimpleCalculatorImpl(){
    //Dummy:
    clear();
  }
  @Override
  public String output() {
    // todo: return output based on the current state
    StringBuilder curr = new StringBuilder(lastCalculatedNumber.get(lastCalculatedNumber.size() - 1));
    for (int i = equalsIndexes.get(equalsIndexes.size()-1); i < history.size(); ++i){
      curr.append(history.get(i));
    }
    return curr.toString();
  }

  @Override
  public void insertDigit(int digit) {
    if (digit < 0 || digit >9){
      throw new IllegalArgumentException("Digit must be between 0-9");
    }
    history.add(String.valueOf(digit));
  }

  @Override
  public void insertPlus() {
    insertOperator("+");
  }

  @Override
  public void insertMinus() {
    insertOperator("-");
  }

  @Override
  public void insertEquals() {
    // todo: calculate the equation. after calling `insertEquals()`, the output should be the result
    //  e.g. given input "14+3", calling `insertEquals()`, and calling `output()`, output should be "17"
    if (isLastItemInHistoryIsOperator()){
      history.remove(history.size()-1);
    }
    //TODO Implement
  }

  @Override
  public void deleteLast() {
    // todo: delete the last input (digit, plus or minus)
    //  e.g.
    //  if input was "12+3" and called `deleteLast()`, then delete the "3"
    //  if input was "12+" and called `deleteLast()`, then delete the "+"
    //  if no input was given, then there is nothing to do here
    if (!isEmpty()){
      history.remove(history.size()-1);
    }
  }

  @Override
  public void clear() {
    // todo: clear everything (same as no-input was never given)
    //Clear all
    history.clear();
    equalsIndexes.clear();
    lastCalculatedNumber.clear();
    // Add Dummies
    history.add("0");
    equalsIndexes.add(0);
    lastCalculatedNumber.add(0);

  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    // todo: insert all data to the state, so in the future we can load from this state
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    // todo: use the CalculatorState to load
  }

  private boolean isEmpty(){
    return history.size() == 1;
  }

  private boolean isLastItemInHistoryIsOperator(){
    if (!isEmpty() && OPERATORS.contains(history.get(history.size()-1))){
      return true;
    }
    return false;
  }

  private void insertOperator(String operator){
    if (!isLastItemInHistoryIsOperator()){
      history.add(operator);
    }
  }

  private static class CalculatorState implements Serializable {
    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
  }
}
