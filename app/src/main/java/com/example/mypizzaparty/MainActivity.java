package com.example.mypizzaparty;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final int SLICES_PER_PIZZA = 8;

    private EditText mNumAttendEditText;
    private TextView mNumPizzasTextView;

    private Spinner mHungerLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumAttendEditText = findViewById(R.id.num_attend_edit_text);
        mNumPizzasTextView = findViewById(R.id.num_pizzas_text_view);
        mHungerLevel = findViewById(R.id.hungry_group);


        mNumAttendEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable){
                Toast.makeText(MainActivity.this, "You typed Something!", Toast.LENGTH_LONG).show();
            }
            // Add the missing code here
        });
    }

    public void calculateClick(View view) {

        String numAttendStr = mNumAttendEditText.getText().toString();

        int numAttend = Integer.parseInt(numAttendStr);

        int selected = mHungerLevel.getSelectedItemPosition();

        int slicesPerPerson = 2;

        if (selected == 0) {
            slicesPerPerson = 2;
        }
        else if (selected == 1) {
            slicesPerPerson = 3;
        }
        else if (selected ==2) {
            slicesPerPerson = 4;
        }

        int totalPizzas = (int) Math.ceil(numAttend * slicesPerPerson /
                (double) SLICES_PER_PIZZA);
        mNumPizzasTextView.setText("Total pizzas: " + totalPizzas);
    }
}