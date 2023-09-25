package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to the main layout defined in activity_main.xml
        setContentView(R.layout.activity_main);

        // Find and set the app's toolbar as the support action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the title of the action bar (toolbar) to "Mortgage Calculator"
        getSupportActionBar().setTitle("Mortgage Calculator");
    }

    // This method is called when a button with the onClick attribute "navigateToCalculationPage" is clicked
    public void navigateToCalculationPage(View view) {
        // Create an Intent to start the CalculationActivity
        Intent intent = new Intent(this, CalculationActivity.class);

        // Start the CalculationActivity, navigating to the next screen
        startActivity(intent);
    }
}
