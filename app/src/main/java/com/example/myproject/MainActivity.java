package com.example.myproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    int num1, num2, count, percentage;
    TextView mispar1, mispar2, mispar3, mispar4, mispar5, mispar6;
    ImageView tmona1, tmona2, tmona3;
    Button playagain, bodek1, bodek2, bodek3;
    EditText input1, input2, input3;
    private Toast mToast;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mispar1= findViewById(R.id.textView1);
        mispar2= findViewById(R.id.textView2);
        mispar3= findViewById(R.id.textView3);
        mispar4= findViewById(R.id.textView4);
        mispar5= findViewById(R.id.textView5);
        mispar6= findViewById(R.id.textView6);
        bodek1= findViewById(R.id.button1);
        bodek2= findViewById(R.id.button2);
        bodek3= findViewById(R.id.button3);
        playagain= findViewById(R.id.button4);
        tmona1 = findViewById(R.id.imageView1);
        tmona2 = findViewById(R.id.imageView2);
        tmona3 = findViewById(R.id.imageView3);
        input1 = findViewById(R.id.editTextNumber1);
        input2 = findViewById(R.id.editTextNumber2);
        input3 = findViewById(R.id.editTextNumber3);
        mToast = Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT);
        game();
    }
    public void Restart(View view){
        count = 0;
        percentage = 0;
            bodek1.setEnabled(true);
            bodek2.setEnabled(false);
            bodek3.setEnabled(false);
        mispar3.setVisibility(View.INVISIBLE);
        mispar4.setVisibility(View.INVISIBLE);
        mispar5.setVisibility(View.INVISIBLE);
        mispar6.setVisibility(View.INVISIBLE);
        tmona1.setVisibility(View.INVISIBLE);
        tmona2.setVisibility(View.INVISIBLE);
        tmona3.setVisibility(View.INVISIBLE);
            game();

        }

    public void game() {
        num1 = rand.nextInt(90) + 10;
        num2 = rand.nextInt(90) + 10;
        mispar1.setText(String.valueOf(num1));
        mispar2.setText(String.valueOf(num2));
        bodek1.setEnabled(true);
        bodek2.setEnabled(false);
        bodek3.setEnabled(false);

    }


    public void FirstInput(View view) {
        String value= input1.getText().toString();
        int sum=Integer.parseInt(value);
        bodek1.setEnabled(false);
        bodek2.setEnabled(true);
        if (sum == (num1 + num2)){
            tmona1.setImageResource(R.drawable.rightanswer);
            count++;
        }
        else{
            tmona1.setImageResource(R.drawable.wronganswer);
        }
        tmona1.setVisibility(View.VISIBLE);
        mispar3.setText(String.valueOf(num1 + num2));
        num1 = num1 + num2;
        num2 = rand.nextInt(90) + 10;
        mispar4.setText(String.valueOf(num2));
        mispar3.setVisibility(View.VISIBLE);
        mispar4.setVisibility(View.VISIBLE);



    }
    public void SecondInput(View view) {
        String value= input2.getText().toString();
        int sum=Integer.parseInt(value);
        bodek1.setEnabled(false);
        bodek2.setEnabled(true);
        sum=Integer.parseInt(value);
        if (sum == (num1 + num2)){
            tmona2.setImageResource(R.drawable.rightanswer);
            count++;
        }
        else{
            tmona2.setImageResource(R.drawable.wronganswer);
        }
        tmona2.setVisibility(View.VISIBLE);
        bodek2.setEnabled(false);
        bodek3.setEnabled(true);
        mispar5.setText(String.valueOf(num1 + num2));
        num1 = num1 + num2;
        num2 = rand.nextInt(90) + 10;
        mispar6.setText(String.valueOf(num2));
        mispar5.setVisibility(View.VISIBLE);
        mispar6.setVisibility(View.VISIBLE);
    }
    public void ThirdInput(View view) {
        String value= input3.getText().toString();
        int sum=Integer.parseInt(value);
        bodek1.setEnabled(false);
        bodek2.setEnabled(true);
        if (sum == (num1 + num2)){
            tmona3.setImageResource(R.drawable.rightanswer);
            count++;
        }
        else{
            tmona3.setImageResource(R.drawable.wronganswer);
        }
        tmona3.setVisibility(View.VISIBLE);
        bodek3.setEnabled(false);
        bodek2.setEnabled(false);
        percentage = count * 33;
        if (percentage == 33 || percentage == 0){

        }
        else{
            percentage++;
        }
        mToast.setText("The Score You Got Is: " + count + "/3 " + (percentage) + "%");
        mToast.show();

    }
}

