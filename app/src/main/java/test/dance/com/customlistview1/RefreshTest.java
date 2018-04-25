package test.dance.com.customlistview1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class RefreshTest extends AppCompatActivity {
    private static final int MY_PERMISSIONS = 2048;
    private Button refreshButton, testButton;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_test);
        refreshButton = (Button) findViewById(R.id.refresh_button);
        testButton = (Button) findViewById(R.id.text_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onRequestPermissionsResult();
            }
        });
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (ContextCompat.checkSelfPermission(RefreshTest.this, Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Permission is not granted
                    Toast.makeText(RefreshTest.this, "Permission not granted", Toast.LENGTH_SHORT).show();
                    if(ActivityCompat.shouldShowRequestPermissionRationale(RefreshTest.this, Manifest.permission.SEND_SMS))
                    {
                        Toast.makeText(RefreshTest.this, "Needed to send text", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        ActivityCompat.requestPermissions(RefreshTest.this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS);
                    }
                }
                else
                {
                    Toast.makeText(RefreshTest.this, "Permission already granted", Toast.LENGTH_SHORT).show();
                }*/
                Vibrator one = (Vibrator)getBaseContext().getSystemService(VIBRATOR_SERVICE);
                one.vibrate(500);
                sendText();
                
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case MY_PERMISSIONS:
            {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    sendText();
                }
                else
                {

                }
                return;
            }
        }
    }

    private void sendText() {
        Toast.makeText(this, "text would have been sent", Toast.LENGTH_SHORT).show();
    }

    private void changeImage(ImageView imageView)
    {


    }
}
