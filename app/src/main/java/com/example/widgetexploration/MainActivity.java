package com.example.widgetexploration;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        final TextClock textClock = findViewById(R.id.textClock);
        final CheckBox cbTransperancy = findViewById(R.id.checkBoxTransparency);
        final CheckBox cbTint = findViewById(R.id.checkBoxTint);
        final CheckBox cbResize = findViewById(R.id.checkBoxReSize);
        final ImageView imageView = findViewById(R.id.imageView);
        Switch switch1 = findViewById(R.id.switch1);
        final TextView textView = findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);

        cbTransperancy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbTransperancy.isChecked()){
                    imageView.setAlpha(0.1f);
                } else {
                    imageView.setAlpha(1.0f);
                }
            }
        });

        cbTint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbTint.isChecked()){
                    imageView.setColorFilter(Color.argb(150, 150 ,20,20));
                } else {
                    imageView.setColorFilter(Color.argb(0, 0 ,0,0));

                }
            }
        });

        cbResize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbResize.isChecked()) {
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                } else {
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }
            }
        });

       radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                switch (radioButton.getId()){
                    case R.id.radioButtonLondon:
                        textClock.setTimeZone("Europe/London");
                        break;

                    case R.id.radioButtonBeijing:
                        textClock.setTimeZone("CST6CDT");
                        break;

                    case R.id.radioButtonNewYork:
                        textClock.setTimeZone(
                                "America/New_York");
                        break;

                    case R.id.radioButtonEurope:
                        textClock.setTimeZone(
                                "Europe/Brussels");
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText());
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textView.setVisibility(View.VISIBLE);
                } else {
                    textView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}