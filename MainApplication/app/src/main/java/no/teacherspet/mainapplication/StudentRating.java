package no.teacherspet.mainapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import backend.StudentInfo;

public class StudentRating extends AppCompatActivity {

    int rating;
    int radioButtonID;
    RadioGroup tempo;
    TextView hello;
    StudentInfo stud=RoleSelect.getStud();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_rating);
        tempo = (RadioGroup) findViewById(R.id.tempoRadioGroup);
        hello = (TextView) findViewById(R.id.textView2);
        tempo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup tempo, int checkedId) {
                radioButtonID = tempo.getCheckedRadioButtonId();
                View radioButton = tempo.findViewById(radioButtonID);
                int rating = tempo.indexOfChild(radioButton) +1;
                RoleSelect.changeStud(rating);
                hello.setText(Integer.toString(RoleSelect.getStud().getRank())+" , "+Integer.toString(RoleSelect.getStud().getOldRank()));
            }
        });
    }
}
