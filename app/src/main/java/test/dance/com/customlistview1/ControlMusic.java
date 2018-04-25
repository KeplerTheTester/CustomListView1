package test.dance.com.customlistview1;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class ControlMusic extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button startMusic;
    private Button stopMusic;
    private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_music);
        mediaPlayer = new MediaPlayer();
        startMusic = (Button) findViewById(R.id.start_music_button);
        stopMusic = (Button) findViewById(R.id.stop_music_button);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        //final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.trial);
        //final MediaPlayer mp = MediaPlayer.create(ControlMusic.this, R.raw.summerfriends);
        startMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ControlMusic.this, "test", Toast.LENGTH_SHORT).show();
                playMusic();
                updateSeekBar();

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //int pool = seekBar.getProgress();
                if(b == true) {

                    Toast.makeText(ControlMusic.this, "Skipped to "+i, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        stopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //double progress = mediaPlayer.getCurrentPosition()/1000;
                //Toast.makeText(ControlMusic.this, "Progress"+(int)progress, Toast.LENGTH_SHORT).show();
                updateSeekBar();
            }
        });
    }
    private void playMusic()
    {
        //mediaPlayer = MediaPlayer.create(this,R.raw.summerfriends );
        //mediaPlayer.start();
        mediaPlayer = MediaPlayer.create(ControlMusic.this, R.raw.summerfriends);
        mediaPlayer.start();

    }
    private void updateSeekBar()
    {
        if(mediaPlayer.isPlaying() == true){
            double progress = mediaPlayer.getCurrentPosition()/1000;
            seekBar.setProgress((int)progress);
        }

    }
    public double getPercentPlayed(int position, int duration)
    {
        double progress = (100.0* position)/duration;
        return progress;
        //seekBar.setProgress(progress);
    }
}
