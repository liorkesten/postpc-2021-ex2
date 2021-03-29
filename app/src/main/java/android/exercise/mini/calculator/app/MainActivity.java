package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @VisibleForTesting
  public SimpleCalculator calculator;
  private TextView textViewCalculatorOutput;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
    }
    if (savedInstanceState != null){
      onRestoreInstanceState(savedInstanceState);
    }
    /*
    TODO:
    - find all views
    - initial update main text-view based on calculator's output
    - set click listeners on all buttons to operate on the calculator and refresh main text-view
     */
    textViewCalculatorOutput = findViewById(R.id.textViewCalculatorOutput);
    refreshCalcOutput();
    findViewById(R.id.buttonEquals).setOnClickListener(v -> {calculator.insertEquals();refreshCalcOutput();
    });
    findViewById(R.id.button0).setOnClickListener(v -> {calculator.insertDigit(0);refreshCalcOutput();
    });
    findViewById(R.id.button1).setOnClickListener(v -> {calculator.insertDigit(1);refreshCalcOutput();
    });
    findViewById(R.id.button2).setOnClickListener(v -> {calculator.insertDigit(2);refreshCalcOutput();
    });
    findViewById(R.id.button3).setOnClickListener(v -> {calculator.insertDigit(3);refreshCalcOutput();
    });
    findViewById(R.id.button4).setOnClickListener(v -> {calculator.insertDigit(4);refreshCalcOutput();
    });
    findViewById(R.id.button5).setOnClickListener(v -> {calculator.insertDigit(5);refreshCalcOutput();
    });
    findViewById(R.id.button6).setOnClickListener(v -> {calculator.insertDigit(6);refreshCalcOutput();
    });
    findViewById(R.id.button7).setOnClickListener(v -> {calculator.insertDigit(7);refreshCalcOutput();
    });
    findViewById(R.id.button8).setOnClickListener(v -> {calculator.insertDigit(8);refreshCalcOutput();
    });
    findViewById(R.id.button9).setOnClickListener(v -> {calculator.insertDigit(9);refreshCalcOutput();
    });
    findViewById(R.id.buttonBackSpace).setOnClickListener(v -> {calculator.deleteLast();refreshCalcOutput();
    });
    findViewById(R.id.buttonPlus).setOnClickListener(v -> {calculator.insertPlus();refreshCalcOutput();
    });
    findViewById(R.id.buttonMinus).setOnClickListener(v -> {calculator.insertMinus();refreshCalcOutput();
    });
    findViewById(R.id.buttonClear).setOnClickListener(v -> {calculator.clear();textViewCalculatorOutput.setText(calculator.output());
    });
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    // todo: save calculator state into the bundle
    outState.putSerializable("Key_Calculator", calculator.saveState());
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
    calculator.loadState(savedInstanceState.getSerializable("Key_Calculator"));
  }

  private void refreshCalcOutput(){
    if (textViewCalculatorOutput != null)
    {
      textViewCalculatorOutput.setText(calculator.output());
    }
  }
}