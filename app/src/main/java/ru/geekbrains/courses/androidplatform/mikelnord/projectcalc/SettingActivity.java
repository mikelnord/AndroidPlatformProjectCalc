package ru.geekbrains.courses.androidplatform.mikelnord.projectcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingActivity extends AppCompatActivity {
    private static final String EXTRA_THEME = "ru.geekbrains.courses.androidplatform.mikelnord.projectcalc.new_theme";
    private String mTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("Theme", Context.MODE_PRIVATE);
        mTheme = sharedPreferences.getString("ThemeName", mTheme);
        if (mTheme == null) mTheme = getString(R.string.theme_green);
        if (mTheme.equals(getString(R.string.theme_green))) {
            setTheme(R.style.Theme_ProjectCalc);
        } else if (mTheme.equals(getString(R.string.theme_dark))) {
            setTheme(R.style.Theme_ProjectCalcDark);
        } else if (mTheme.equals(getString(R.string.theme_broun))) {
            setTheme(R.style.Theme_ProjectCalcBroun);
        }

        setContentView(R.layout.activity_setting);
        mTheme = getIntent().getStringExtra(EXTRA_THEME);

        RadioButton mGreen = findViewById(R.id.Green);
        RadioButton mDark = findViewById(R.id.Dark);
        RadioButton mBroun = findViewById(R.id.Broun);

        if (getString(R.string.theme_green).equals(mTheme)) {
            mGreen.setChecked(true);
        } else if (getString(R.string.theme_dark).equals(mTheme)) {
            mDark.setChecked(true);
        } else if (getString(R.string.theme_broun).equals(mTheme)) {
            mBroun.setChecked(true);
        } else {
            mGreen.setChecked(true);
        }
        RadioGroup mradioGroup = findViewById(R.id.radioGroup);
        mradioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.Green:
                    mTheme = getString(R.string.theme_green);
                    break;
                case R.id.Dark:
                    mTheme = getString(R.string.theme_dark);
                    break;
                case R.id.Broun:
                    mTheme = getString(R.string.theme_broun);
                    break;
            }
        });
        Button mButtonOk = findViewById(R.id.button_ok);
        Button mButtonCancel = findViewById(R.id.button_cancel);
        mButtonOk.setOnClickListener(view -> {
            setResult(mTheme);
            finish();
        });
        mButtonCancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }

    public static Intent newIntent(Context packageContext, String theme) {
        Intent intent = new Intent(packageContext, SettingActivity.class);
        intent.putExtra(EXTRA_THEME, theme);
        return intent;
    }

    private void setResult(String theme) {
        Intent data = new Intent();
        data.putExtra(EXTRA_THEME, theme);
        setResult(RESULT_OK, data);
    }

    public static String returnResult(Intent result) {
        return result.getStringExtra(EXTRA_THEME);
    }
}