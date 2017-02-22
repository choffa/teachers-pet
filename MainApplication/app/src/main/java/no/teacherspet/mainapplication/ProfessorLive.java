package no.teacherspet.mainapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by magnus on 17.02.2017.
 */


public class ProfessorLive extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professor_layout);
        Button randNumBtn;
        randNumBtn = (Button) findViewById(R.id.genRandomNumBtn);

        randNumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float avg = (float) (Math.random()*40)+10;
                avg = (float) Math.floor(avg);
                avg = avg/10;
                update(avg);
            }
        });

    }

    protected String translateColor(float average){
        String ratingColor;
        String opacityColor;

        int opacity = (int) ((average-3)*100)*250/200; //gir et tall mellom -250 og 250 som vil gi blaa/roed hex respektivt.


        opacityColor = Integer.toHexString(255-Math.abs(opacity));


        if (opacity == 0) {
            ratingColor = "#ffffff";
        } else if (opacity > 255 - 16) {
            ratingColor = "#ff0" + opacityColor + "0" + opacityColor; //Sterk roed
        } else if (opacity > 0) {
            ratingColor = "#ff" + opacityColor + opacityColor;
        } else if (opacity < 16 - 255) {
            ratingColor = "#0" + opacityColor + "0" + opacityColor + "ff";
        } else {
            ratingColor = "#" + opacityColor + opacityColor + "ff";
        }
        return ratingColor;


    }

    public static int darker (int color, float factor) {
        int a = Color.alpha( color );
        int r = Color.red( color );
        int g = Color.green( color );
        int b = Color.blue( color );

        return Color.argb( a,
                Math.max( (int)(r * factor), 0 ),
                Math.max( (int)(g * factor), 0 ),
                Math.max( (int)(b * factor), 0 ) );
    }

    protected void update(float average){
        RelativeLayout layout;
        TextView text;
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        layout = (RelativeLayout) findViewById(R.id.profRelLayout);
        layout.setBackgroundColor(Color.parseColor(translateColor(average)));
        actionBar.setBackgroundDrawable(new ColorDrawable(darker(Color.parseColor(translateColor(average)), (float) 0.8)));
        text = (TextView) findViewById(R.id.treKommaFem);
        text.setText(String.format("%.1f",average-3));
    }

}

