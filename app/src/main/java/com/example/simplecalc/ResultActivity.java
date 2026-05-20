package com.example.simplecalc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView detailsTv =
                findViewById(R.id.detailsTv);

        Intent intent = getIntent();

        String num1 =
                intent.getStringExtra("num1");

        String num2 =
                intent.getStringExtra("num2");

        String result =
                intent.getStringExtra("result");

        String operation =
                intent.getStringExtra("operation");

        detailsTv.setText(
                "First Number : " + num1 +
                        "\n\nSecond Number : " + num2 +
                        "\n\nOperation : " + operation +
                        "\n\nResult : " + result
        );
    }
}