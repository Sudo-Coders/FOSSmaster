package com.hackathon.sudocoders.fossmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hackathon.sudocoders.fossmaster.Utils.SharedPref;

public class SelectDifficulty extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);
        radioGroup = (RadioGroup) findViewById(R.id.selectDifc);
        addListenerOnButton();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SelectDifficulty.this, StartOpenSource.class));
    }


    public void addListenerOnButton() {


        next = (Button) findViewById(R.id.nextBtn);

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
                SharedPref sharedPref = new SharedPref(getApplicationContext());
                // find the radiobutton by returned id
                next = (RadioButton) findViewById(selectedId);
                sharedPref.setLevel(next.getText().toString());
                startActivity(new Intent(SelectDifficulty.this, OpenSourceActivity.class));
                finish();
                Toast.makeText(SelectDifficulty.this,
                        next.getText() + " is selected", Toast.LENGTH_SHORT).show();

            }

        });

    }

}
