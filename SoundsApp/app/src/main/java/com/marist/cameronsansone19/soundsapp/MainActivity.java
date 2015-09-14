package com.marist.cameronsansone19.soundsapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // MediaPlayer Array
    private MediaPlayer soundPlayer [] = new MediaPlayer[6];

    // Resources Array
    private int soundResources [] = {R.raw.baseball, R.raw.basketball, R.raw.football, R.raw.hockey, R.raw.soccer, R.raw.tennis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the MediaPlayer objects and assign them
        // sounds from the soundResources Array
        for (int i = 0; i < soundPlayer.length; i++) {
            soundPlayer[i] = MediaPlayer.create(this, soundResources[i]);
        } // end for

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
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonClicked(View view) {

        // Switch Case to listen for buttons
        switch (view.getId()) {
            case R.id.imageButtonBaseball:
                soundPlayer[0].start();
                break;

            case R.id.imageButtonBasketball:
                soundPlayer[1].start();
                break;

            case R.id.imageButtonFootball:
                soundPlayer[2].start();
                break;

            case R.id.imageButtonHockey:
                soundPlayer[3].start();
                break;

            case R.id.imageButtonSoccer:
                soundPlayer[4].start();
                break;

            case R.id.imageButtonTennis:
                soundPlayer[5].start();
                break;

            case R.id.button:
                // Iterate through all sounds
                for (int s = 0; s < soundPlayer.length; s++) {
                    // If sound is playing
                    if (soundPlayer[s].isPlaying()) {
                        soundPlayer[s].pause(); // Pause sound
                        soundPlayer[s].seekTo(0); // Rewind to beginning
                    } // end if
                } // end for
                break;

            default:
                break;
        }// End Switch
    }// End button Clicked()

}// End class main activity
