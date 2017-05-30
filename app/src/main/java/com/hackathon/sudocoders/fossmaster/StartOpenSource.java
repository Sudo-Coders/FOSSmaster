package com.hackathon.sudocoders.fossmaster;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hackathon.sudocoders.fossmaster.Utils.SharedPref;

public class StartOpenSource extends AppCompatActivity {


    private RadioGroup radioGroup;
    private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_open_source);

        addListenerOnButton();

    }


    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.selectLang);
        next = (Button) findViewById(R.id.nextBtn);

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
                SharedPref sharedPref = new SharedPref(getApplicationContext());
                // find the radiobutton by returned id
                next = (RadioButton) findViewById(selectedId);

                sharedPref.setLanguage(next.getText().toString());
                // STOPSHIP: 2/4/17
                sharedPref.setOpensourceStatus(true);
                startActivity(new Intent(StartOpenSource.this, SelectDifficulty.class));
                finish();
                System.out.println(sharedPref.getLanguage());
                Toast.makeText(StartOpenSource.this,
                        next.getText() + " is selected", Toast.LENGTH_SHORT).show();

            }

        });

    }


}
