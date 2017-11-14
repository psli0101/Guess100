package com.psli.guess100;

import android.opengl.ETC1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews(); 
    }

    public void findViews() {
        TextView t_secret = (TextView) findViewById(R.id.secret);
        TextView t_info = (TextView) findViewById(R.id.info);
        EditText ed_number = (EditText) findViewById(R.id.number);
        Button b_send = (Button) findViewById(R.id.send);
    }
}
