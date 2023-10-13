package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAc,btnPlus,btnMulti,btnEquals,btnDivide,btnDel,btnMinus,btnDot;
    private TextView textViewResult,textViewHistory;
    private String number=null;

    double firstNumber=0;
    double lastNumber=0;
    String status=null;
    boolean operator=false;
    String history,currentResult;
    boolean dot=true;
    boolean btnACcontrol=true;
    boolean btnEqualControl=false;

    DecimalFormat myformatter=new DecimalFormat("######.######");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnPlus=findViewById(R.id.btnPlus);
        btnMinus=findViewById(R.id.btnMinus);
        btnDel=findViewById(R.id.btnDel);
        btnDivide=findViewById(R.id.btnDivide);

        btnAc=findViewById(R.id.btnAC);
        btnDot=findViewById(R.id.btnDot);
        btnEquals=findViewById(R.id.btnEquals);
        btnMulti=findViewById(R.id.btnMulti);

        textViewHistory=findViewById(R.id.textViewHistory);
        textViewResult=findViewById(R.id.textViewResult);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");

            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dot) {
                    if (number == null) {
                        number = "0.";
                    } else {
                        number = number + ".";
                    }
                }
                textViewResult.setText(number);
                dot=false;
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"+");
                if(operator){
                    if(status=="multiplication"){
                        multipy();
                    }else{
                        if(status=="division"){
                            divide();
                        }else{
                            if(status=="subtraction"){
                                minus();
                            }else{
                                plus();
                            }
                        }
                    }
                }
                status="sum";
                operator=false;
                dot=true;
                number=null;
            }

        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"*");
                if(operator){
                    if(status=="sum"){
                        plus();
                    }else{
                        if(status=="division"){
                            divide();
                        }else{
                            if(status=="subtraction"){
                                minus();
                            }else{
                                multipy();
                            }
                        }
                    }
                }
                status="multiplication";
                operator=false;
                dot=true;
                number=null;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"-");
                if(operator){
                   if(status=="multiplication"){
                       multipy();
                   }else{
                       if(status=="division"){
                           divide();
                       }else{
                           if(status=="sum"){
                               plus();
                           }else{
                               minus();
                           }
                       }
                   }
                }
                status="subtraction";
                operator=false;
                dot=true;
                number=null;
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //numberClick("/");
                history=textViewHistory.getText().toString();
                currentResult=textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"/");
                if(operator){
                    if(status=="multiplication"){
                        multipy();
                    }else{
                        if(status=="sum"){
                            plus();
                        }else{
                            if(status=="subtraction"){
                                minus();
                            }else{
                                divide();
                            }
                        }
                    }
                }
                status="division";
                operator=false;
                dot=true;
                number=null;
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnACcontrol==true){
                    textViewResult.setText("0");
                }else{
                    if (number.length()!=0) {

                        number = number.substring(0, number.length() - 1);
                        if(number.contains(".")){
                            dot=false;
                        }else{
                            dot=true;
                        }
                        textViewResult.setText(number);
                    }else{
                        btnDel.setClickable(false);
                    }
                }
            }
        });
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot=true;
              if(operator){
                  if(status=="sum"){
                      plus();
                  }else{
                      if(status=="subtraction"){
                          minus();
                      }else{
                          if(status=="multiplication"){
                              multipy();
                          }else{
                              if (status=="division"){
                                  divide();
                              }else{
                                  firstNumber= Double.parseDouble(textViewResult.getText().toString());
                              }
                          }
                      }
                  }
              }
              operator=false;
              dot=true;
              btnACcontrol=true;

            }
        });
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  number=null;
                  status=null;
                  dot=true;
                  textViewResult.setText("0");
                  textViewHistory.setText("");
                  firstNumber=0;
                  lastNumber=0;
                  btnACcontrol=true;
            }
        });
    }
    public void numberClick(String view){
        if(number==null){
            number=view;
        }else{
            if(btnACcontrol){
                firstNumber=0;
                lastNumber=0;
                number=view;
            }else{
                number=number+view;
            }
        }
        textViewResult.setText(number);
       operator=true;
       btnACcontrol=false;
       btnDel.setClickable(true);
       btnEqualControl=false;
    }
    public void plus(){
        lastNumber=Double.parseDouble(textViewResult.getText().toString());
        firstNumber=firstNumber+lastNumber;
        textViewResult.setText(myformatter.format(firstNumber));

    }
    public void minus(){
        if(firstNumber==0){
            firstNumber=Double.parseDouble(textViewResult.getText().toString());
        }else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }
        textViewResult.setText(myformatter.format(firstNumber));
    }
    public void multipy(){

        if(firstNumber==0){
            firstNumber=1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        textViewResult.setText(myformatter.format(firstNumber));

    }
    public void divide(){

        if(firstNumber==0){
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = lastNumber / 1;
        }else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        textViewResult.setText(myformatter.format(firstNumber));

    }
}