package com.codewithsouma.happybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = getMediaPlayer();
    }

    private MediaPlayer getMediaPlayer() {
        return MediaPlayer.create(this,R.raw.happybirthday_song);
    }


    public void handelButtonClick(View view) {
        toggleMediaPlayer();
        toggleButtonText(view);
    }

    private void toggleMediaPlayer() {
        if (!mediaPlayer.isPlaying())
            play();
         else
            pause();
    }

    private void toggleButtonText(View view){
        Button playButton = (Button) view;
        playButton.setText(getButtonText());
    }

    private String getButtonText(){
        return mediaPlayer.isPlaying() ? "Pause" : "Play";
    }

    private void pause() {
        mediaPlayer.pause();
    }

    private void play() {
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }
}