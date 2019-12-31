package com.app.aungpyaephyo.ucs_patheinvoting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref= null;
    private FirebaseAuth mAuth;

    private Button boys,girls,login;
    //qr code scanner object
    private IntentIntegrator qrScan;
    ProgressBar qrLoading;
    String qrCode="";
        @Override
    protected void onCreate(Bundle savedInstanceState) {

            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        boys=findViewById(R.id.boys);
        girls=findViewById(R.id.girls);
        login=findViewById(R.id.login);
        qrLoading=findViewById(R.id.qr_loading);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();

        pref=getSharedPreferences("com.app.aungpyaephyo.ucs_patheinvoting",MODE_PRIVATE);

//        if (pref.getBoolean("firstrun", true)) {
//            // Do first run stuff here then set 'firstrun' as false
//            Toast.makeText(this,"first time",Toast.LENGTH_LONG).show();
//
//            // using the following line to edit/commit prefs
//            pref.edit().putBoolean("firstrun", false).apply();
//
//        }
//        else{
//            Toast.makeText(this,"not first times",Toast.LENGTH_LONG).show();
//        }

        //intializing scan object
        qrScan = new IntentIntegrator(this);


        }

    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                try {
                //converting the data to json
                JSONObject obj = new JSONObject(result.getContents());
                //setting values to textviews
                // textViewName.setText(obj.getString("name"));
                // textViewAddress.setText(obj.getString("address"));
            } catch (JSONException e) {
                e.printStackTrace();
                //if control comes here
                //that means the encoded format not matches
                //in this case you can display whatever data is available on the qrcode
                //to a toast
                qrCode=result.getContents();
            }
                //if qr contains data

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void sendQR(String result){


        Intent intent = new Intent(this, VoteActivity.class);
        intent.putExtra("qrCode",result);
        startActivity(intent);
        this.finish();

    }
    public void btnClick(View view) {
        //initiating the qr code scan
        switch (view.getId()) {
            case R.id.login:{
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    qrScan.initiateScan();
                }
                else
                    Toast.makeText(MainActivity.this,"Please turn on the Internet",Toast.LENGTH_SHORT).show();

            }

                break;
            case R.id.
                        boys:
                {
                    Intent intent = new Intent(this, RecyclerViewActivity.class);
                    intent.putExtra("data","boys");
                    startActivity(intent);
            }
            break;
            case R.id.girls:
                {
                    Intent intent = new Intent(this, RecyclerViewActivity.class);
                    intent.putExtra("data","girls");
                    startActivity(intent);
            }
            break;
        }


    }


    protected void onResume() {
        super.onResume();


        if(qrCode!="") {
            final ProgressDialog dialog = ProgressDialog.show(this, "",
                    "Loading. Please wait...", true);
            String[] strarr=qrCode.split(" ");
            mAuth.signInWithEmailAndPassword(strarr[0]+"@gmail.com",strarr[1]).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                         //login successful
                        Intent i=new Intent(MainActivity.this,VoteActivity.class);
                        finish();
                        startActivity(i);
                        dialog.dismiss();
                    }
                    else{
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this,"You have wrong QR or,\nYou have voted already",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
     }
}

