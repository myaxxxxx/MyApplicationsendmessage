package com.example.lenovo.myapplicationsendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button bt=null;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)super.findViewById(R.id.button) ;
        editText1=(EditText)super.findViewById(R.id.editText) ;
        editText2=(EditText)super.findViewById(R.id.editText2) ;
        editText3 = (EditText)findViewById(R.id.editText3);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("message", editText1.getText().toString().trim() + " + " + editText2.getText().toString().trim() + " = ");

                intent.putExtra("name1",Integer.parseInt(editText1.getText().toString()));
                intent.putExtra("name2",Integer.parseInt(editText2.getText().toString()));
                startActivityForResult(intent,1000);

            }
        });


    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000 && resultCode == 1001)
        {
            String result_value = data.getStringExtra("result");
            editText3.setText(result_value);
        }

    }

}
