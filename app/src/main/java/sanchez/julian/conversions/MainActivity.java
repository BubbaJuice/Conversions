package sanchez.julian.conversions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import sanchez.julian.conversions.temperature.Temperature;
import sanchez.julian.conversions.temperature.TemperatureFactory;
import sanchez.julian.conversions.temperature.TemperatureUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText input = (findViewById(R.id.inputTempEditText));
        final Button convert = (findViewById(R.id.convertButton));
        final TextView output = (findViewById(R.id.resultTextView));
        final RadioGroup inputType = (findViewById(R.id.inputType));
        final RadioGroup outputType = (findViewById(R.id.outputType));

        inputType.check(R.id.inputCelcius);
        outputType.check(R.id.outputCelcius);

        convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 0. Check that a number is supplied.
                String inputString = input.getText().toString();
                if (inputString.isEmpty())
                    return;

                // 1. Get the input number
                double inputValue = Double.parseDouble(inputString);

                TemperatureUnit unitFrom = TemperatureUnit.CELCIUS;
                TemperatureUnit unitTo = TemperatureUnit.CELCIUS;

                int checkedInputButton = inputType.getCheckedRadioButtonId();
                int checkedOuputButton = outputType.getCheckedRadioButtonId();

                if (checkedInputButton == R.id.inputCelcius)
                    unitFrom = TemperatureUnit.CELCIUS;
                else if (checkedInputButton == R.id.inputFahrenheit)
                    unitFrom = TemperatureUnit.FAHRENHEIT;
                else if (checkedInputButton == R.id.inputKevlin)
                    unitFrom = TemperatureUnit.KELVIN;

                if (checkedOuputButton == R.id.outputCelcius)
                    unitTo = TemperatureUnit.CELCIUS;
                else if (checkedOuputButton == R.id.outputFahrenheit)
                    unitTo = TemperatureUnit.FAHRENHEIT;
                else if (checkedOuputButton == R.id.outputKelvin)
                    unitTo = TemperatureUnit.KELVIN;

                // 2. run through our conversion function
                Temperature temp = TemperatureFactory.create(unitFrom, inputValue);
                double resultValue =  temp.convertTo(unitTo).getTemp();
                // 3. Update the output number
                output.setText("" + resultValue);
            }
        });
    }
}