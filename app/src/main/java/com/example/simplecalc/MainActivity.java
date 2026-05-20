package com.example.simplecalc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.simplecalc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EditText firstNumber, secondNumber;
    private TextView resulttext;

    private double result = 0;
    private String operation = "";
    private int resultColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);

        Button addBtn = findViewById(R.id.addBtn);
        Button subBtn = findViewById(R.id.subBtn);
        Button mulBtn = findViewById(R.id.mulBtn);
        Button divBtn = findViewById(R.id.divBtn);

        resulttext = findViewById(R.id.resulttext);

        addBtn.setOnClickListener(v -> {
            double n1 = Double.parseDouble(firstNumber.getText().toString());
            double n2 = Double.parseDouble(secondNumber.getText().toString());

            result = n1 + n2;
            operation = "ADD";

            resulttext.setText(String.valueOf(result));
            resultColor = Color.parseColor("#0F6206");
            resulttext.setTextColor(resultColor);
        });

        subBtn.setOnClickListener(v -> {
            double n1 = Double.parseDouble(firstNumber.getText().toString());
            double n2 = Double.parseDouble(secondNumber.getText().toString());

            result = n1 - n2;
            operation = "SUB";

            resulttext.setText(String.valueOf(result));
            resultColor = Color.parseColor("#F80D0D");
            resulttext.setTextColor(resultColor);
        });

        mulBtn.setOnClickListener(v -> {
            double n1 = Double.parseDouble(firstNumber.getText().toString());
            double n2 = Double.parseDouble(secondNumber.getText().toString());

            result = n1 * n2;
            operation = "MUL";

            resulttext.setText(String.valueOf(result));
            resultColor = Color.parseColor("#4F096D");
            resulttext.setTextColor(resultColor);
        });

        divBtn.setOnClickListener(v -> {
            double n1 = Double.parseDouble(firstNumber.getText().toString());
            double n2 = Double.parseDouble(secondNumber.getText().toString());

            result = n1 / n2;
            operation = "DIV";

            resulttext.setText(String.valueOf(result));
            resultColor = Color.parseColor("#E7AF11");
            resulttext.setTextColor(resultColor);
        });

        resulttext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);

            intent.putExtra("num1", firstNumber.getText().toString());
            intent.putExtra("num2", secondNumber.getText().toString());
            intent.putExtra("result", String.valueOf(result));
            intent.putExtra("operation", operation);

            startActivity(intent);
        });

        if (savedInstanceState != null) {
            firstNumber.setText(savedInstanceState.getString("num1"));
            secondNumber.setText(savedInstanceState.getString("num2"));

            result = savedInstanceState.getDouble("result");
            operation = savedInstanceState.getString("operation");
            resultColor = savedInstanceState.getInt("color");

            resulttext.setText(String.valueOf(result));
            resulttext.setTextColor(resultColor);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("num1", firstNumber.getText().toString());
        outState.putString("num2", secondNumber.getText().toString());
        outState.putDouble("result", result);
        outState.putString("operation", operation);
        outState.putInt("color", resultColor);
    }
}