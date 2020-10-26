package com.example.ht_721;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    EditText coordinatesET;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                String coordinates = coordinatesET.getText().toString();
                char firstChar = coordinates.charAt(0);

                if (Character.isLetter(firstChar))
                    intent.setData(Uri.parse("geo:?q=" + coordinates));
                else
                    intent.setData(Uri.parse("geo:" + coordinates));

                startActivity(intent);
            }
        });
    }

    private void init() {
        coordinatesET = findViewById(R.id.coordinates);
        searchButton = findViewById(R.id.searchButton);
    }
}