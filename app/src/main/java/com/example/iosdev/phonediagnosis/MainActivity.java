package com.example.iosdev.phonediagnosis;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {


    TextView text;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text =(TextView)findViewById(R.id.text);
        progressBar=(ProgressBar) findViewById(R.id.prog);


       //text.setVisibility(View.INVISIBLE);
/*
        text.setText("HARDWARE:-"+ Build.HARDWARE+"\n"+"FINGER_PRINT:-"+Build.FINGERPRINT+"\n"+"DISPLAY:-"+Build.DISPLAY
                +"\n"+"BOOTLOADER:-"+Build.BOOTLOADER+"\n"+"BOARD:-"+Build.BOARD+"\n"+"DEVICE:-"+Build.DEVICE
                +"\n"+"MANUFACTURER:-"+Build.MANUFACTURER+"\n"+"MODEL:-"+Build.MODEL+"\n"+"PRODUCT:-"+Build.PRODUCT
                +"\n"+"TYPE:-"+Build.TYPE+"\n"+"BRAND:-"+Build.BRAND+"\n"+"USER:-"+Build.USER
                +"\n"+"VERSION.SDK_INT:-"+Build.VERSION.SDK_INT+"\n"+"VERSION.BASE_OS:-"+"Build.VERSION.BASE_OS"+"\n"+"VERSION.BASE_OS:-"+Build.VERSION.BASE_OS
                +"\n"+"VERSION.RELEASE:-"+Build.VERSION.RELEASE+"\n"+"VERSION.SECURITY_PATCH:-"+Build.VERSION.SECURITY_PATCH+"\n"+"VERSION.PREVIEW_SDK_PTACH:-"+Build.VERSION.PREVIEW_SDK_INT
                +"\n"+"CPU_ABI:-"+Build.CPU_ABI+"\n"+"TIME:-"+Build.TIME+"\n"+"VERSION.BASE_OS:-");

*/
        MyTask myTask = new MyTask();
        myTask.execute("Sleeping");



    }



    public class MyTask extends AsyncTask<String,String,String> {



        @Override
        protected void onPreExecute() {

            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(100);

        }

        @Override
        protected String doInBackground(String... strings) {


            // THREAD TO MAKE ASYNCHRONUS TASK
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {

                    for(int i =0; i<2000 ;i++) {

                        Log.d("TH",""+ i);
                    }
                }
            });
            try{
                Log.d("TH","THREAD WILL SLEEP FOR 1min");
                t.sleep(3000);
                t.start();
            }catch(Exception e){
                e.printStackTrace();
            }


            return null;
        }



        @Override
        protected void onPostExecute(String s) {
           progressBar.setVisibility(View.GONE);
            text.setVisibility(View.VISIBLE);

             text.setText("HARDWARE:-"+ Build.HARDWARE+"\n"+"FINGER_PRINT:-"+Build.FINGERPRINT+"\n"+"DISPLAY:-"+Build.DISPLAY
             +"\n"+"BOOTLOADER:-"+Build.BOOTLOADER+"\n"+"BOARD:-"+Build.BOARD+"\n"+"DEVICE:-"+Build.DEVICE
             +"\n"+"MANUFACTURER:-"+Build.MANUFACTURER+"\n"+"MODEL:-"+Build.MODEL+"\n"+"PRODUCT:-"+Build.PRODUCT
                     +"\n"+"TYPE:-"+Build.TYPE+"\n"+"BRAND:-"+Build.BRAND+"\n"+"USER:-"+Build.USER
                     +"\n"+"CPU_ABI:-"+Build.CPU_ABI+"\n"+"TIME:-"+Build.TIME+"\n"+"HOST:-"+Build.HOST+"\n"+"TAGS:-"+Build.TAGS
             +"\n"+"USER:-"+Build.USER+"\n");

            /*
            text.setVisibility(View.VISIBLE);
            text.setText(""+Build.HARDWARE);
            text.setText(""+Build.FINGERPRINT);
            text.setText(""+Build.DISPLAY);
            text.setText(""+Build.BOOTLOADER);
            text.setText(""+Build.BOARD);
            text.setText(""+Build.DEVICE);
            //Log.d("SYS",""+Build.getSerial());
            text.setText(""+Build.MANUFACTURER);
            text.setText(""+Build.MODEL);
            text.setText(""+Build.PRODUCT);
            text.setText(""+Build.TYPE);
            text.setText(""+Build.BRAND);
            text.setText(""+Build.USER);
            // VERSION SDK
            text.setText(""+Build.VERSION.SDK_INT);
            text.setText(""+Build.VERSION.BASE_OS);
            text.setText(""+Build.VERSION.BASE_OS);
            */
        }
    }


}
