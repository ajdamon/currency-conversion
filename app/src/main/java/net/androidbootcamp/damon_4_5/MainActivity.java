package net.androidbootcamp.damon_4_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double euro = 0.91;
    double peso = 18.76;
    double cDoll = 1.33;
    int printNumber;
    double conversion;
    String currencyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText amountDollars = (EditText) findViewById(R.id.txtD);
        final RadioButton rdOne = (RadioButton) findViewById(R.id.txtEuro);
        final RadioButton rdTwo = (RadioButton) findViewById(R.id.txtPeso);
        final RadioButton rdThree = (RadioButton) findViewById(R.id.txtCan);

        final TextView theResult = (TextView) findViewById(R.id.txtResult);

        Button btCalc = (Button) findViewById(R.id.btnCalc);

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber = Integer.parseInt(amountDollars.getText().toString());
                DecimalFormat currency = new DecimalFormat("##.##");
                if (printNumber < 100000) {
                    if (rdOne.isChecked()) {
                        conversion = printNumber * euro;
                        currencyName = "Euros";
                    }

                    if (rdTwo.isChecked()) {
                        conversion = printNumber * peso;
                        currencyName = "Pesos";
                    }

                    if (rdThree.isChecked()) {
                        conversion = printNumber * cDoll;
                        currencyName = "CAD";
                    }
                    theResult.setText("Conversion: " + currency.format(conversion) + " " + currencyName);
                } else {
                    Toast.makeText(MainActivity.this, "Value Must Be Below $100,000 USD", Toast.LENGTH_LONG).show();
                }
            }
        });
    }}
