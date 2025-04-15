package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sound access for Dice rolling sound
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);

        //creating Button variable
        Button btnRoll = findViewById(R.id.btnRoll);


        //Creating Image variable
        ImageView imgDice1 = findViewById(R.id.imgDice1);
        ImageView imgDice2 = findViewById(R.id.imgDice2);

        // Creating Array to Store all the images
        int [] diceImages = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};


        //Button On-Click Listener
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Generating Random Number
                Random ran = new Random();
                int ranNum1= ran.nextInt(6);
                int ranNum2 = ran.nextInt(6);

                //Changing the image with random number generation using arrays
                imgDice1.setImageResource(diceImages[ranNum1]);
                imgDice2.setImageResource(diceImages[ranNum2]);

                //Animation of shaking images using project libraries from github
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice1));

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice2));

                //Playing dice music
                mp.start();
            }
        });


    }
}