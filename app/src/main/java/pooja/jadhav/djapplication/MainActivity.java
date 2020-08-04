package pooja.jadhav.djapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

import pooja.jadhav.djapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, View.OnLongClickListener {
    MediaPlayer mediaPlayer,mediaPlayer1;
    SoundPool soundPool;
    public static int dhamaka;
    Random random_crazy=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = new View(this);
        view.setOnClickListener(this);
        view.setOnTouchListener(this);
        view.setOnLongClickListener(this);
        setContentView(view);

        view.setBackgroundColor(Color.rgb(random_crazy.nextInt(255),random_crazy.nextInt(255),random_crazy.nextInt(255)));

        mediaPlayer=MediaPlayer.create(this,R.raw.rock);
        mediaPlayer1=MediaPlayer.create(this,R.raw.r2);
        soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        dhamaka=soundPool.load(this, R.raw.r1,1);


    }

    @Override
    public void onClick(View view) {
        mediaPlayer1.start();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (dhamaka!=0)
        {
            soundPool.play(dhamaka,1,1,0,0,1);
            view.setBackgroundColor(Color.rgb(random_crazy.nextInt(255),random_crazy.nextInt(255),random_crazy.nextInt(255)));
        }

        return false;
    }

    @Override
    public boolean onLongClick(View view) {
        mediaPlayer.start();
        return true;
    }
}