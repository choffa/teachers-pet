package no.teacherspet.mainapplication;

import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by magnus on 17.02.2017.
 */


public class Professor extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professor_layout);
        Button randNumBtn;
        randNumBtn = (Button) findViewById(R.id.genRandomNumBtn);

        randNumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float avg = (float) (Math.random()*49);
                avg = (float) Math.floor(avg);
                avg = avg/10;
                update(avg);
            }
        });

    }

    protected String translateColor(float average){
        String ratingColor;
        String opacityColor;

        int opacity = (int) ((average-2.5)*100); //gir et tall mellom -250 og 250 som vil gi blaa/roed hex respektivt.


        opacityColor = Integer.toHexString(255-Math.abs(opacity));
        if(opacity==0){
            ratingColor = "#ffffff";
        }
        else if(opacity>255-16){
            ratingColor = "#ff0"+ opacityColor + "0" + opacityColor; //Sterk roed
        }
        else if(opacity>0){
            ratingColor = "#ff" + opacityColor + opacityColor;
        }
        else if(opacity<16-255){
            ratingColor = "#0" + opacityColor+"0" + opacityColor+"ff";
        }
        else{
            ratingColor = "#" + opacityColor + opacityColor + "ff";
        }
        return ratingColor;

    }

    protected void update(float average){
        System.out.println(Double.toString(average));
        RelativeLayout layout;
        TextView text;
        layout = (RelativeLayout) findViewById(R.id.profRelLayout);
        layout.setBackgroundColor(Color.parseColor(translateColor(average)));
        text = (TextView) findViewById(R.id.treKommaFem);
        int textNum = (int) (average*10);
        text.setText(Integer.toString(textNum));
    }

}

