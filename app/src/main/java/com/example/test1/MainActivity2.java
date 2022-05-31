package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telecom.InCallService;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;
//1-public void onBackPressed() {
 //       long D= (Total*duration)/100;
//        If (D< Total){
 //       Intent .put(D)……
//        progressBar.setVisibility(true);
 //       progressBar.setProgress(D);}

//        return;
//
//        }
public class MainActivity2 extends AppCompatActivity {
    private int Currentprogress ;
    private Handler handler = new Handler();
    int counter;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    Button btnclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        EditText Searchhint = findViewById(R.id.Searchhint);
        Searchhint.setText(message);

        btnclose = (Button)findViewById(R.id.btn_close);
        btnclose.setVisibility(View.GONE);

        ProgressBar progressBar = findViewById(R.id.ProgressBarjob) ;


        MediaController mc = new MediaController(this);
        final VideoView videoview =(VideoView)findViewById(R.id.videoview1);
        videoview.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video1);
        mc.setAnchorView(videoview);
        videoview.setMediaController(mc);

        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(),"Video is prepared and Ready for playing",Toast.LENGTH_SHORT).show();
                //long duration = VideoView.getDuration();
            }
        });
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //close button is displayed(when we click on it=>counter +1)
                //progress bar is hide
                Toast.makeText(getApplicationContext(),"Video is completed",Toast.LENGTH_SHORT).show();
                btnclose.setVisibility(View.VISIBLE);
                btnclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //intent

                        Currentprogress = Currentprogress +10;
                        progressBar.setProgress(Currentprogress);
                        progressBar.setMax(100);
                        counter ++;
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result",counter);
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();


                    }


                });
            }
        });


        videoview.start();
    }
}