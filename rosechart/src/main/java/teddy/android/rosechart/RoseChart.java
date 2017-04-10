package teddy.android.rosechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import java.util.ArrayList;

import teddy.android.rosechart.utils.Colors;

/**
 * Created by theodorecha on 2017. 4. 10..
 */

public class RoseChart extends View {

    private ArrayList<Float> values;
    private String[] colors;
    private int maxValue = 100;

    public RoseChart(Context context, ArrayList<Float> values) {
        super(context);
        this.values = values;
    }

    public RoseChart(Context context, ArrayList<Float> values, int maxValue) {
        super(context);
        this.values = values;
        this.maxValue = maxValue;
    }

    public RoseChart(Context context, ArrayList<Float> values, int maxValue, String[] colors) {
        super(context);
        this.values = values;
        this.maxValue = maxValue;
        this.colors = colors;
    }

    public RoseChart(Context context, ArrayList<Float> values, String[] colors) {
        super(context);
        this.values = values;
        this.colors = colors;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float range = 360 / values.size();

        boolean hasColors = true;

        if (colors == null) {
            hasColors = false;
        }

        for(int i = 0; i < values.size(); i++) {
            Paint paint = new Paint();
            if(hasColors) {
                if (i >= colors.length) {
                    paint.setColor(Color.parseColor(colors[colors.length - 1]));
                } else {
                    paint.setColor(Color.parseColor(colors[i]));
                }

            } else {
                paint.setColor(Colors.getDefaultColor(i));
            }
            paint.setAntiAlias(true);

            float min = fanCoordinate(values.get(i), canvas.getWidth());
            float max = canvas.getWidth() - fanCoordinate(values.get(i), canvas.getWidth());

            RectF rf = new RectF(min, min, max, max);

            canvas.drawArc(rf, range * i, range, true, paint);
        }
    }

    private float fanCoordinate(float value, float standard) {
        return (standard - (value * standard / maxValue)) / 2;
    }

}
