package com.example.lenovo.myapplicationsendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private Button bt1;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_main2);
        bt1 =(Button)super.findViewById(R.id.button2);
        editText=(EditText)super.findViewById(R.id.editText4) ;
        textView = (TextView)findViewById(R.id.textView);

        final String message = intent.getStringExtra("message").toString().trim();
        int x =intent.getIntExtra("name1",0);
        int y =intent.getIntExtra("name2",0);
        int z = x+y;
       // String xx =(String )z;
        final String mm=z+"";
        textView.setText(message);


      //  String message = intent.getStringExtra("message").toString().trim();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = message+mm;
                editText.setText(result);
                Intent intent = new Intent();
                intent.putExtra("result", result);
                /*
                 * 调用setResult方法表示我将Intent对象返回给之前的那个Activity，这样就可以在onActivityResult方法中得到Intent对象，
                 */
                setResult(1001, intent);
                //    结束当前这个Activity对象的生命
                finish();

            }
        });
    }
}
