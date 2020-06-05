package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private Button b;
    public static final String SP = "sharedprefs";
    public static final String TEXT = "text";
    private String s;
    private boolean c;
    private String e;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        b = (Button) findViewById(R.id.b);
        et.setEnabled(false);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e = b.getText().toString();
                if (e.equals("edit")){
                    et.setEnabled(true);
                    b.setText("save");
                }if (e.equals("save")){
                    save();
                    b.setText("edit");
                    et.setEnabled(false);

                }



            }
        });

        load();
        set();

    }

    private void save() {
        SharedPreferences pref = getSharedPreferences(SP,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(TEXT, et.getText().toString());
        editor.apply();

    }

    private void load() {
        SharedPreferences pref = getSharedPreferences(SP, Context.MODE_PRIVATE);
        s = pref.getString(TEXT," ");
    }

    private void set() {
        et.setText(s);
        et.setEnabled(false);
    }
}
