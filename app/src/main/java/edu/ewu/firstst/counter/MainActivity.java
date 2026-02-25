package edu.ewu.cse489r2018360058.firstst.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView display;
    private int display_number =2018360058  ;
    boolean run=false ,pause=false;
    private Button b_start, b_reset, b_pause, b_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        b_start= findViewById(R.id.start);
        b_reset= findViewById(R.id.reset);
        b_pause= findViewById(R.id.pause);
        b_exit= findViewById(R.id.exit);



        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          run=true;
          Task T=new Task();
          T.execute(run);

            }
        });

        b_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                display_number=2018360058;
                display.setText(String.valueOf(display_number));
                pause=true;

            }
        });


        b_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(pause==true)
                {
                    pause=false;
                }
                else{
                    pause=true;
                }

            }
        });






        b_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });





    }


    class Task extends AsyncTask<Boolean,Integer,Integer> {


        @Override
        protected Integer doInBackground(Boolean... booleans) {
            while (booleans[0]){
                if(!pause) {
                    display_number--;
                    publishProgress(display_number);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            display.setText(String.valueOf(display_number));

        }
    }

}