package com.qiyu.bottomusingdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BottomAnimDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new BottomAnimDialog(this, new BottomAnimDialog.BottomAnimDialogListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tv_photo:
                        Toast.makeText(MainActivity.this, "You Clicked Photo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_photograph:
                        Toast.makeText(MainActivity.this, "You Clicked Photograph", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_cancle:
                        dialog.dismiss();
                }
            }
        });

        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });


    }
}
