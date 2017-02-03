package com.example.boredombuster;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String riddleList[] = {"I’m tall when I’m young and I’m short when I’m old. What am I?",
                            "What goes up when rain comes down?",
                            "What is the longest word in the dictionary?",
                            "What word becomes shorter when you add two letters to it?",
                            "What travels around the world but stays in one spot?",
                            "What has 4 eyes but can’t see?",
                            "What has hands but can not clap?",
                            "What can you catch but not throw?",
                            "What is at the end of a rainbow?",
                            "What is so delicate that saying its name breaks it?"};

    String answerList[] = {"A candle",
                            "An umbrella",
                            "Smiles, because there is a mile between each ‘s’",
                            "Short",
                            "A stamp!",
                            "Mississippi",
                            "A clock",
                            "A cold",
                            "The letter 'w'",
                            "Silence"};

    TextView RiddleText;
    TextView AnswerText;
    Button GenerateRiddleButton;
    ImageView LightBulbImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Call superclass
        super.onCreate(savedInstanceState);
        // Specify layout and toolbar
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Populate views
        RiddleText = (TextView) findViewById(R.id.riddleText);
        AnswerText = (TextView) findViewById(R.id.textView);
        LightBulbImage = (ImageView) findViewById(R.id.LightBulbImage);
        GenerateRiddleButton = (Button) findViewById(R.id.riddleButton);

        // Add button functionality
        GenerateRiddleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display randomly generated riddle and answer
                int index = new Random().nextInt(riddleList.length);
                RiddleText.setText(riddleList[index]);
                AnswerText.setText(answerList[index]);
                // Animation
                YoYo.with(Techniques.Swing)
                        .duration(500)
                        .playOn(LightBulbImage);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks obon the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
