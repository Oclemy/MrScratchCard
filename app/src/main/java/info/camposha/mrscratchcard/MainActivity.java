package info.camposha.mrscratchcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView codeTxt;
    private ScratchCard mScratchCard;

    /**
     *  Let's create a method to initialize widgets
     */
    private void initializeWigets(){
        codeTxt = findViewById(R.id.codeTxt);
        mScratchCard = findViewById(R.id.scratchCard);
		codeTxt.setText(Utils.generateNewCode());
    }

    /**
     * Let's create a method to scratch.
     * @param isScratched
     */
    private void scratch(boolean isScratched){
        if(isScratched){
            mScratchCard.setVisibility(View.INVISIBLE);
        }else{
            mScratchCard.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Handle scratch listenes
     */
    private void handleListeners(){
        mScratchCard.setOnScratchListener(new ScratchCard.OnScratchListener() {
            @Override
            public void onScratch(ScratchCard scratchCard, float visiblePercent) {
                if (visiblePercent > 0.3) {
                    scratch(true);
                    Toast.makeText(MainActivity.this, "Code Visible Now", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    /**
     * Our onCreate callback
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeWigets();
        this.handleListeners();
    }
}
//end
