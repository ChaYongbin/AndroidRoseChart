package teddy.android.rosechart.utils;


import android.graphics.Color;

import java.util.Random;

/**
 * Created by theodorecha on 2017. 4. 10..
 */

public class Colors {

    private static String[] colorList = {"#5484A4", "#F6D155", "#004B8D", "#F2552C",
            "#95DEE3", "#EDCDC2", "#88B04B", "#CE3175", "#5A7247", "#CFB095"};

    public static int getDefaultColor(int idx) {
        if (idx > 9){
            Random random = new Random();
            return Color.parseColor(colorList[random.nextInt(10)]);
        }

        return Color.parseColor(colorList[idx]);
    }

}
