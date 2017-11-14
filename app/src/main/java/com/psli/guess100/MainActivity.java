package com.psli.guess100;

import android.content.DialogInterface;
import android.opengl.ETC1;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    int sec_num = random.nextInt(100)+1;
    int start = 0;
    int end = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    public void findViews() {
        final TextView t_secret = (TextView) findViewById(R.id.secret);
        t_secret.setText(Integer.toString(sec_num));
        final TextView t_info = (TextView) findViewById(R.id.info);
        final EditText ed_number = (EditText) findViewById(R.id.number);
        Button b_send = (Button) findViewById(R.id.send);
        b_send.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int num = Integer.parseInt(ed_number.getText().toString());
                        if (num == sec_num) {
                            new AlertDialog.Builder(MainActivity.this)
                                    .setMessage("Right Answer")
                                    .setNeutralButton("New Game",
                                            new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    sec_num = random.nextInt(100)+1;
                                                    t_secret.setText(Integer.toString(sec_num));
                                                }
                                            })
                                    .setPositiveButton("OK", null)
                                    .show();
                        } else {
                            if(num > sec_num) {
                                end = num;
                            } else if(num < sec_num) {
                                start = num;
                            }
                            t_info.setText(start+" to "+end);
                        }
                    }
                }
        );
    }
}
