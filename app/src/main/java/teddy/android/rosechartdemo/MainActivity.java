package teddy.android.rosechartdemo;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

import teddy.android.rosechart.RoseChart;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);

        Float[] list = {Float.valueOf(10), Float.valueOf(20), Float.valueOf(30),
                Float.valueOf(40), Float.valueOf(50), Float.valueOf(60), Float.valueOf(70)};

        ArrayList<Float> arrayList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 360; i++) {
            arrayList.add((float) random.nextInt(101));
        }


//        Float[] list = {Float.valueOf(10), Float.valueOf(20), Float.valueOf(30), Float.valueOf(40)};
//        Float[] list = {Float.valueOf(10), Float.valueOf(20), Float.valueOf(30)};

        RoseChart roseChart = new RoseChart(this, arrayList);

        layout.addView(roseChart);

    }
}
