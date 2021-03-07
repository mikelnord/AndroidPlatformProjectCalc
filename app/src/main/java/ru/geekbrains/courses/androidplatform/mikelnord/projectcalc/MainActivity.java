package ru.geekbrains.courses.androidplatform.mikelnord.projectcalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButton0;
    private Button mButtonPoint;
    private Button mButtonPlus;
    private Button mButtonRav;
    private Button mButtonDiv;
    private Button mButtonMinus;
    private Button mButtonUmn;
    private Button mButtonProc;
    private Button mButtonC;
    private Button mButtonCE;
    private Button mButtonPm;
    private final static String keyCalc = "Calc";
    private final static String keyText = "textViewText";


    private TextView mTextView;
    Calc calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        inizial();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(keyCalc, calc);
        outState.putString(keyText, mTextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calc = savedInstanceState.getParcelable(keyCalc);
        mTextView.setText(savedInstanceState.getString(keyText));
    }

    private void initButton() {
        mButton1 = findViewById(R.id.button_1);
        mButton2 = findViewById(R.id.button_2);
        mButton3 = findViewById(R.id.button_3);
        mButton4 = findViewById(R.id.button_4);
        mButton5 = findViewById(R.id.button_5);
        mButton6 = findViewById(R.id.button_6);
        mButton7 = findViewById(R.id.button_7);
        mButton8 = findViewById(R.id.button_8);
        mButton9 = findViewById(R.id.button_9);
        mButton0 = findViewById(R.id.button_0);
        mButtonPoint = findViewById(R.id.button_point);
        mButtonPlus = findViewById(R.id.button_plus);
        mButtonRav = findViewById(R.id.button_rav);
        mButtonDiv = findViewById(R.id.button_div);
        mButtonMinus = findViewById(R.id.button_minus);
        mButtonUmn = findViewById(R.id.button_umn);
        mButtonProc = findViewById(R.id.button_proc);
        mButtonC = findViewById(R.id.button_c);
        mButtonCE = findViewById(R.id.button_ce);
        mButtonPm = findViewById(R.id.button_pm);
    }

    private void inizial() {
        calc = new Calc();
        mTextView = findViewById(R.id.monitorTextView);
        mTextView.setText("0");

        mButtonPm.setOnClickListener(view -> {
            String st = mTextView.getText().toString();
            mTextView.setText(String.valueOf((-1) * Double.parseDouble(st)));
            calc.changingSign();
        });
        mButtonCE.setOnClickListener(view -> {
            calc.clearLast();
            mTextView.setText("0");
        });
        mButtonC.setOnClickListener(view -> {
            calc.clear();
            mTextView.setText("0");
        });
        mButtonDiv.setOnClickListener(view -> {
            setText(calc.getRezult(), mTextView);
            calc.setOperator(Calc.div);
        });
        mButtonMinus.setOnClickListener(view -> {
            setText(calc.getRezult(), mTextView);
            calc.setOperator(Calc.minus);
        });
        mButtonUmn.setOnClickListener(view -> {
            setText(calc.getRezult(), mTextView);
            calc.setOperator(Calc.umn);
        });
        mButtonRav.setOnClickListener(view -> {
            setText(calc.getRezult(), mTextView);
            calc.setOperator("");
        });
        mButtonPlus.setOnClickListener(view -> {
            setText(calc.getRezult(), mTextView);
            calc.setOperator(Calc.plus);
        });
        mButtonPoint.setOnClickListener(view -> {
            calc.setVal(".");
            setText(calc.getVal(), mTextView);
        });
        mButton0.setOnClickListener(view -> {
            calc.setVal("0");
            mTextView.setText(calc.getVal());
        });
        mButton1.setOnClickListener(view -> {
            calc.setVal("1");
            mTextView.setText(calc.getVal());
        });
        mButton2.setOnClickListener(view -> {
            calc.setVal("2");
            mTextView.setText(calc.getVal());
        });
        mButton3.setOnClickListener(view -> {
            calc.setVal("3");
            mTextView.setText(calc.getVal());
        });
        mButton4.setOnClickListener(view -> {
            calc.setVal("4");
            mTextView.setText(calc.getVal());
        });
        mButton5.setOnClickListener(view -> {
            calc.setVal("5");
            mTextView.setText(calc.getVal());
        });
        mButton6.setOnClickListener(view -> {
            calc.setVal("6");
            mTextView.setText(calc.getVal());
        });
        mButton7.setOnClickListener(view -> {
            calc.setVal("7");
            mTextView.setText(calc.getVal());
        });
        mButton8.setOnClickListener(view -> {
            calc.setVal("8");
            mTextView.setText(calc.getVal());
        });
        mButton9.setOnClickListener(view -> {
            calc.setVal("9");
            mTextView.setText(calc.getVal());
        });
        mButtonProc.setOnClickListener(view -> mTextView.setText(calc.getProc()));
    }

    private void setText(String s, TextView mTextvew) {
        if (!s.equals("0")) {
            if ((s.lastIndexOf(".0") > 0) && (s.lastIndexOf(".0") == s.length() - 2))
                s = s.substring(0, s.length() - 2);
            mTextvew.setText(s);
        }
    }
}