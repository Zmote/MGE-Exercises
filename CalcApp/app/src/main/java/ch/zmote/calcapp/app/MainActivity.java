package ch.zmote.calcapp.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btnMulti = (Button) findViewById(R.id.btnMulti);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        Button btnEqual = (Button) findViewById(R.id.btnEqual);
        Button btnDot = (Button) findViewById(R.id.btnDot);
        Button btnRest = (Button) findViewById(R.id.btnRest);
        Button btnPlus = (Button) findViewById(R.id.btnPlus);
        final TextView inputField = (TextView) findViewById(R.id.input_val);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField(v, inputField);
            }
        };

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
        btn0.setOnClickListener(listener);
        btnMulti.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
        btnPlus.setOnClickListener(listener);
        btnMinus.setOnClickListener(listener);
        btnEqual.setOnClickListener(listener);
        btnDot.setOnClickListener(listener);
        btnRest.setOnClickListener(listener);
    }

    private void updateInputField(View v, final TextView inputField) {
        if(inputField.getText().toString().equals("0")){
            inputField.setText("");
        }
        int intID = v.getId();
        Button button = (Button) findViewById(intID);
        String btnVal = button.getText().toString();

        if(btnVal.equals("=")){
            Evaluator evaluator = new Evaluator(this, new Evaluator.Callback<String>() {
                /**
                 * @param s das Resultat der Berechnung als String
                 */
                @Override
                public void apply(String s) {
                    inputField.setText(s);
                }
            });

            evaluator.evaluate(inputField.getText().toString());
        }else if(btnVal.equals("RST")){
            inputField.setText("0"); //interessanter Fehler, wenn man '' anstatt "" benutzt.
        }else{
            String updatedString = inputField.getText().toString() + btnVal;
            inputField.setText(updatedString);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onResume(){
        super.onResume();
    }
}
