package info.camposha.mrscratchcard;

import android.content.Context;

import java.util.Random;

public class Utils {
    static Random r =new Random();

    /**
     * Let's create a method to convert density independent pixels to
     * pixels.
     * @param context
     * @param dipValue
     * @return
     */
    public static float dipToPx(Context context, float dipValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return dipValue * density;
    }

    /**
     * This method will generate code parts based on the specified
     * min and max values
     * @param min
     * @param max
     * @return
     */
    private static String generateCodePart(int min,int max){
        int temp;
        if(min > max){
            temp = min;
            max = min;
            min = temp;
        }
        return String.valueOf((r.nextInt(max - min) + 1)+min);
    }

    /**
     * Let's create a method that will generate our code and return it
     * @return - code string
     */
    public static String generateNewCode(){
        String firstCodePart = generateCodePart(1000,9999);
        String secondCodePart = generateCodePart(1000,9999);
        String thirdCodePart = generateCodePart(1000,9999);
        String fourthCodePart = generateCodePart(1000,9999);

        return firstCodePart + "-"+secondCodePart+"-"+thirdCodePart+"-"+fourthCodePart;
    }

}
//end









































































































































