package com.example.inclasslab;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextRed;
   private EditText editTextGreen;
   private EditText editTextBlue;
    private LinearLayout mainLayout; // Root layout representing the entire page

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextRed = findViewById(R.id.editTextRed);
        editTextGreen = findViewById(R.id.editTextGreen);
        editTextBlue = findViewById(R.id.editTextBlue);
        mainLayout = findViewById(R.id.mainLayout); // Root layout

        // Set the initial background color of the entire page to white (#FFFFFF)
        mainLayout.setBackgroundColor(Color.WHITE);
    }

    public void generateColor(View view) {
        try {
            int red = Integer.parseInt(editTextRed.getText().toString());
            int green = Integer.parseInt(editTextGreen.getText().toString());
            int blue = Integer.parseInt(editTextBlue.getText().toString());

            // Check if RGB values are within the valid range (0-255)
            if (isValidRGBValue(red) && isValidRGBValue(green) && isValidRGBValue(blue)) {
                int color = Color.argb(255,red,green,blue);
                mainLayout.setBackgroundColor(color); // Set background color of the entire page
            } else {
                showToast("Invalid RGB values. Enter values between 0 and 255.");
            }
        } catch (NumberFormatException e) {
            showToast("Please enter valid numeric RGB values.");
        }
    }

    private boolean isValidRGBValue(int value) {
        return value >= 0 && value <= 255;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}