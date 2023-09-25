package com.example.assignment1;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CalculationActivity extends AppCompatActivity {

    // Declare references to UI elements
    private EditText editTextPrincipal;      // Input field for mortgage principal
    private EditText editTextInterestRate;   // Input field for interest rate
    private EditText editTextAmortization;   // Input field for amortization period (in years)
    private TextView textViewPaymentResult;   // TextView to display the calculated payment result

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation_page);

        // Initialize the app's toolbar
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mortgage Calculator");

        // Initialize references to EditText and TextView widgets
        editTextPrincipal = findViewById(R.id.editTextPrincipal);             // Reference to mortgage principal input
        editTextInterestRate = findViewById(R.id.editTextInterestRate);       // Reference to interest rate input
        editTextAmortization = findViewById(R.id.editTextAmortization);       // Reference to amortization period input
        textViewPaymentResult = findViewById(R.id.textViewPaymentResult);     // Reference to payment result TextView
    }

    // This method is called when the "Calculate" button is clicked
    public void calculatePayment(View view) {
        // Get user input from EditText widgets
        double principal = Double.parseDouble(editTextPrincipal.getText().toString());
        double interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
        int amortizationPeriodYears = Integer.parseInt(editTextAmortization.getText().toString());

        // Perform the mortgage payment calculation
        double monthlyInterestRate = (interestRate / 100) / 12;
        int amortizationPeriodMonths = amortizationPeriodYears * 12; // Convert years to months
        double mortgagePayment = (principal * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -amortizationPeriodMonths));

        // Display the calculated payment in the TextView
        textViewPaymentResult.setText("Payment Result: " + String.format("%.2f", mortgagePayment));
    }
}
