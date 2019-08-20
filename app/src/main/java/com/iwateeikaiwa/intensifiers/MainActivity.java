package com.iwateeikaiwa.intensifiers;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected Button wordButton;
    protected Button imageButton;
    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordButton = findViewById(R.id.getWordButton);
        imageButton = findViewById(R.id.getImageButton);
        textView = findViewById(R.id.intensifierView);

        wordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(getIntensifier());
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: add image switching.
            }
        });

    }

    public String generateString(int length) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }


    public String getIntensifier() {
        Random random = new Random();
        Resources res = getResources();
        String[] intensifiers = res.getStringArray(R.array.intensifiers);
        return intensifiers[random.nextInt(intensifiers.length)];
    }
}
