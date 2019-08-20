package com.iwateeikaiwa.intensifiers;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected Button wordButton;
    protected TextView textView;
    protected ImageView imageView;

    protected int[] imageIds = {
            R.drawable.angry,
            R.drawable.baseball,
            R.drawable.beach,
            R.drawable.disneyland,
            R.drawable.dog,
            R.drawable.happy,
            R.drawable.hotdog,
            R.drawable.mansion,
            R.drawable.mb,
            R.drawable.pizza,
            R.drawable.nintendo,
            R.drawable.rollercoaster,
            R.drawable.salad,
            R.drawable.skier
    };
    int currentImgIndex;
    int currentWordIndex;
    String[] intensifiers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        wordButton = findViewById(R.id.getWordButton);
        textView = findViewById(R.id.intensifierView);
        Resources res = getResources();
        intensifiers = res.getStringArray(R.array.intensifiers);

        initializeGame();

        wordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                haveAllWordsShown();
                haveAllImagesShown();
                if (currentImgIndex < imageIds.length) {
                    imageView.setImageResource(imageIds[currentImgIndex]);
                    textView.setText(intensifiers[currentWordIndex]);
                    currentWordIndex++;
                }
            }
        });
    }

    private void initializeGame() {
        imageView.setImageResource(R.drawable.cover);
        textView.setText(R.string.start);
        currentWordIndex = 0;
        currentImgIndex = 0;
    }

    private void haveAllImagesShown() {
        if (currentImgIndex == imageIds.length) {
            // Finished
            textView.setText(R.string.finished);

        }
    }

    private void haveAllWordsShown() {
        if (currentWordIndex == intensifiers.length) {
            currentWordIndex = 0;
            currentImgIndex++;
        }
    }

}
