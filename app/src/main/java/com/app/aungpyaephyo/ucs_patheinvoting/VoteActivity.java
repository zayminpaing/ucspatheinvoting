package com.app.aungpyaephyo.ucs_patheinvoting;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class VoteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Button vote;
    TextView title;
    ImageView imageView;
    String type="";
    String select="";
    String b1="1";
    String b2="2";
    String b3="3";
    String b4="4";
    String b5="5";
    String b6="6";
    String b7="7";
    String b8="8";
    String b9="9";
    String b10="10";
    String g1="1";
    String g2="2";
    String g3="3";
    String g4="4";
    String g5="5";
    String g6="6";
    String g7="7";
    String g8="8";
    String g9="9";
    String g10="10";
    String bp1="https://cdn3.iconfinder.com/data/icons/google-material-design-icons/48/ic_filter_1_48px-256.png";
    String bp2="https://cdn3.iconfinder.com/data/icons/google-material-design-icons/48/ic_filter_2_48px-512.png";
    String bp3="https://cdn3.iconfinder.com/data/icons/google-material-design-icons/48/ic_filter_3_48px-256.png";
    String bp4="https://cdn3.iconfinder.com/data/icons/letters-and-numbers-1/32/number_4_green-256.png";
    String bp5="https://cdn0.iconfinder.com/data/icons/social-flat-rounded-rects/512/html5-256.png";
    String bp6="https://cdn3.iconfinder.com/data/icons/letters-and-numbers-1/32/number_6_blue-256.png";
    String bp7="https://cdn3.iconfinder.com/data/icons/letters-and-numbers-1/32/number_7_blue-256.png";
    String bp8="https://cdn3.iconfinder.com/data/icons/letters-and-numbers-1/32/number_8_blue-256.png";
    String bp9="https://cdn3.iconfinder.com/data/icons/letters-and-numbers-1/32/number_9_blue-256.png";
    String bp10="https://cdn1.iconfinder.com/data/icons/social-media-glossy/512/78-microsoft_social-256.png";
    String gp1="https://cdn3.iconfinder.com/data/icons/google-material-design-icons/48/ic_filter_1_48px-256.png";
    String gp2="https://cdn3.iconfinder.com/data/icons/google-material-design-icons/48/ic_filter_2_48px-512.png";
    String gp3="https://cdn3.iconfinder.com/data/icons/google-material-design-icons/48/ic_filter_3_48px-256.png";
    String gp4="https://cdn3.iconfinder.com/data/icons/letters-and-numbers-1/32/number_4_green-256.png";
    String gp5="https://cdn0.iconfinder.com/data/icons/social-flat-rounded-rects/512/html5-256.png";
    String gp6="https://cdn3.iconfinder.com/data/icons/letters-and-numbers-1/32/number_6_blue-256.png";
    String gp7="https://cdn3.iconfinder.com/data/icons/letters-and-numbers-1/32/number_7_blue-256.png";
    String gp8="https://cdn3.iconfinder.com/data/icons/letters-and-numbers-1/32/number_8_blue-256.png";
    String gp9="https://cdn3.iconfinder.com/data/icons/letters-and-numbers-1/32/number_9_blue-256.png";
    String gp10="https://cdn1.iconfinder.com/data/icons/social-media-glossy/512/78-microsoft_social-256.png";
    String[] boys={b1,b2,b3,b4,b5,b6,b7,b8,b9,b10};
    String[] girls={g1,g2,g3,g4,g5,g6,g7,g8,g9,g10};
    String[] current_title ={"King","Style Boy","Innocent Boy","Queen","Style Girl","Innocent Girl"};
    String ct=current_title[0];
    String current_gender="male";
    String[] result=new String[6];
    int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        imageView = findViewById(R.id.image);

        title=findViewById(R.id.text);

//        Bundle bundle=getIntent().getExtras();
//        type=bundle.getString("type");
//        select=bundle.getString("select");

        addItemsOnSpinner();

        addListenerOnButton();

        addListenerOnSpinnerItemSelection();

    }


    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        if(parent.getItemAtPosition(pos).equals(b1)){
            Glide.with(this).load(bp1).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b2)){
            Glide.with(this).load(bp2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b3)){
            Glide.with(this).load(bp3).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b4)){
            Glide.with(this).load(bp4).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b5)){
            Glide.with(this).load(bp5).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b6)){
            Glide.with(this).load(bp6).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b7)){
            Glide.with(this).load(bp7).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b8)){
            Glide.with(this).load(bp8).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b9)){
            Glide.with(this).load(bp9).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(b10)){
            Glide.with(this).load(bp10).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g1)){
            Glide.with(this).load(gp1).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g2)){
            Glide.with(this).load(gp2).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g3)){
            Glide.with(this).load(gp3).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g4)){
            Glide.with(this).load(gp4).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g5)){
            Glide.with(this).load(gp5).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g6)){
            Glide.with(this).load(gp6).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g7)){
            Glide.with(this).load(gp7).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g8)){
            Glide.with(this).load(gp8).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g9)){
            Glide.with(this).load(gp9).fitCenter().into(imageView);
        }
        else if(parent.getItemAtPosition(pos).equals(g10)){
            Glide.with(this).load(gp10).fitCenter().into(imageView);
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = findViewById(R.id.name);
        spinner.setOnItemSelectedListener(this);

    }
        // get the selected dropdown list value
        public void addListenerOnButton () {
            vote = findViewById(R.id.vote);
            vote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ct.equals("Innocent Girl")){
                        Glide.with(VoteActivity.this).load(R.drawable.splah_welcome).fitCenter().into(imageView);
                        String str = spinner.getSelectedItem().toString();
                        result[index] = ct + "," + str;
                        Toast.makeText(VoteActivity.this,result[0]+"\n"+result[1]+"\n"+result[2]+"\n"+result[3]+"\n"+result[4]+"\n"+result[5],Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Glide.with(VoteActivity.this).load(R.drawable.splah_welcome).fitCenter().into(imageView);
                        String str = spinner.getSelectedItem().toString();
                        result[index] = ct + "," + str;

                        Toast.makeText(VoteActivity.this,
                                result[index],
                                Toast.LENGTH_SHORT).show();

                        if (current_gender.equals("male")) {
                            for (int i = 0; i < boys.length; i++) {
                                if (boys[i].equals(str)) {
                                    boys[i] = "";
                                }
                            }
                        } else {
                            for (int i = 0; i < girls.length; i++) {
                                if (girls[i].equals(str)) {
                                    girls[i] = "";
                                }
                            }
                        }

                        index++;
                        ct = current_title[index];
                        if (ct.equals("Queen"))
                            current_gender = "female";
                        title.setText("Who is your " + ct);
                        addItemsOnSpinner();
                    }

                }
            });
        }

        public void addItemsOnSpinner () {
            List<String> list=new ArrayList<String>();
            spinner=findViewById(R.id.name);
            list.add("Choose your "+ ct);
            if(current_gender.equals("male")) {
                for (String boy : boys) {
                    if(boy.length()>0)
                    list.add(boy);
                }
            }
            else{
                for (String girl : girls) {
                    if(girl.length()>0)
                    list.add(girl);
                }
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
        }

}