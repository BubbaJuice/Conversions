package sanchez.julian.conversions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import sanchez.julian.conversions.temperature.Temperature;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText input = (findViewById(R.id.inputTempEditText));
        final Button convert = (findViewById(R.id.convertButton));
        final TextView output = (findViewById(R.id.resultTextView));
        final Switch switchctof = (findViewById(R.id.cToFSwitch));


        convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 0. Check that a number is supplied.
                String inputString = input.getText().toString();
                if (inputString.isEmpty())
                    return;

                // 1. Get the input number
                double inputValue = Double.parseDouble(inputString);
                // 2. run through our conversion function
                double resultValue =  (switchctof.isChecked())?
                        Temperature.cToF(inputValue)
                        :
                        Temperature.fToC(inputValue);
                // 3. Update the output number
                output.setText("" + resultValue);
            }
        });
    }
}