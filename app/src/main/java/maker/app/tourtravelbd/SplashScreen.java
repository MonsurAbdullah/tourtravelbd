package maker.app.tourtravelbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private  int progrees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        progressBar = findViewById(R.id.progressBarID);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    doWork();
                    strarApp();
            }
        });
        thread.start();
    }
    public void doWork(){

        for(progrees = 0;progrees <=100;progrees=progrees+20){

            try {
                Thread.sleep(1000);
                progressBar.setProgress(progrees);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void strarApp(){

        Intent intent = new Intent(SplashScreen.this,WelcomePage.class);
        startActivity(intent);
        finish();
    }
}
