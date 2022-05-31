package com.example.test1;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
// 1-add to layout Continue:
// LinearLayout linearLayout = itemView.findViewById(R.id.notebody);
//CardiView txt = new CardiView(holder.linearLayout.getContext());
//holder.linearLayout.addView(imageView);

//2-rogressBar.setVisibility(true);
//progressBar.setProgress(D)

//3-
public class MainActivity extends AppCompatActivity {
    private int Currentprogress = 0;
    private Handler handler = new Handler();
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    ProgressBar progressBar ;
    ImageView  imageView , imageView2,imageView3;
    TextView Principletitle;
    int LAUNCH_SECOND_ACTIVITY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //The Principle Title set in intent
        Principletitle =(TextView)findViewById(R.id.ccl2) ;

        //Progress Bar
        ProgressBar progressBar = findViewById(R.id.ProgressBarjob) ;




        imageView = findViewById(R.id.imageViewL11);
       //imageViewL21
        imageView2 = findViewById(R.id.imageViewL21);
        imageView3 = findViewById(R.id.imageL31);
        // Apply OnClickListener  to imageView to
        // switch from one activity to another
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to Main.Activity2.class
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //put the title of current layout to
                String message = Principletitle.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivityForResult(intent, LAUNCH_SECOND_ACTIVITY);

            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(MainActivity.this, pdf.class);

                   intent.putExtra("pdf_url", "https://www.heart.org/-/media/files/health-topics/answers-by-heart/what-is-high-blood-pressure.pdf");
                   startActivityForResult(intent, LAUNCH_SECOND_ACTIVITY);
                                          }
                                      }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK){
                int level = data.getIntExtra("result", -1);
                Toast.makeText(getApplicationContext(),"the Job "+level,Toast.LENGTH_SHORT).show();

                //Add To Greate Job





            }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
            }
        }


}
