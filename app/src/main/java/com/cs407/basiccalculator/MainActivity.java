package com.cs407.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editTextText3);
        editText2 = findViewById(R.id.editTextText4);
        addButton = findViewById(R.id.button15);
        subtractButton = findViewById(R.id.button19);
        multiplyButton = findViewById(R.id.button20);
        divideButton = findViewById(R.id.button21);

        addButton.setOnClickListener(v -> performOperation("+"));
        subtractButton.setOnClickListener(v -> performOperation("-"));
        multiplyButton.setOnClickListener(v -> performOperation("*"));
        divideButton.setOnClickListener(v -> performOperation("/"));
    }

    private void performOperation(String operation) {
        String num1 = editText1.getText().toString();
        String num2 = editText2.getText().toString();
        if (num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);

        if (operation.equals("/") && number2 == 0) {
            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("num1", number1);
        intent.putExtra("num2", number2);
        intent.putExtra("operation", operation);
        startActivity(intent);
    }
}
