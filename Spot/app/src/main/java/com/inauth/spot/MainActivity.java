package com.inauth.spot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.inauth.grab.GrabInfo;
import com.inauth.cipher.VigenereCipher;




public class MainActivity extends AppCompatActivity {

    private Button btn_GPS;
    private Button btn_apps;
    private Button btn_encrypt;
    private Button btn_decrypt;
    private TextView tv;
    private EditText txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText) findViewById(R.id.txt_encrypt);
        tv = (TextView) findViewById(R.id.textView_1);

        final Button gps = findViewById(R.id.btn_GPS);
        gps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //tv.setText("GPS Button Clicked");
                GrabInfo instance = new GrabInfo();
                double result[] = GrabInfo.gps();

                tv.setText("Lat: " + result[0] + "\nLon: " + result[1]);


            }
        });

        final Button apps = findViewById(R.id.btn_apps);
        apps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                tv.setText("Apps Button Clicked");
            }
        });

        final Button encrypt = findViewById(R.id.btn_encrypt);
        encrypt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //txt.setText("Encrypt Button Clicked");

                VigenereCipher instance = new VigenereCipher();
                txt.setText((VigenereCipher.encrypt(txt.getText().toString())));

            }
        });

        final Button decrypt = findViewById(R.id.btn_decrypt);
        decrypt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //txt.setText("Encrypt Button Clicked");

                VigenereCipher instance = new VigenereCipher();
                txt.setText((VigenereCipher.decrypt(txt.getText().toString())));

            }
        });

    }

}
