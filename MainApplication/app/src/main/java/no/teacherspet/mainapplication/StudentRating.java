package no.teacherspet.mainapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class StudentRating extends AppCompatActivity {

    int rating;
    int radioButtonID;
    static final String CURRENT_RESULT="result";
    RadioGroup tempo;
    TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_rating);
        tempo = (RadioGroup) findViewById(R.id.tempoRadioGroup);
        if(savedInstanceState!=null){
            rating=savedInstanceState.getInt(CURRENT_RESULT);
            if(rating>0){
                tempo.check(radioButtonID);
            }
            else{
                rating=0;
            }
        }
        else{
            rating=0;
        }
        hello = (TextView) findViewById(R.id.textView2);
        tempo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup tempo, int checkedId) {
                radioButtonID = tempo.getCheckedRadioButtonId();
                View radioButton = tempo.findViewById(radioButtonID);
                int rating = tempo.indexOfChild(radioButton) +1;
                hello.setText(Integer.toString(rating));
            }
        });
    }
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(CURRENT_RESULT, this.rating);
        super.onSaveInstanceState(savedInstanceState);
    }

}
