package com.example.srijanakc.sanopalaute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class HomeActivity extends AppCompatActivity {

    int PLACE_PICKER_REQUEST = 1;
    TextView tvPlace;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvPlace= (TextView) findViewById(R.id.tvPlace) ;

        tvPlace.setOnClickListener(new View.OnClickListener() {
            @Override
           /* public void onClick(View view) {

                tvPlace.setText("Paranna palvelua");

            }*/

            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, ParannaPalveluaActivity.class);
                st = tvPlace.getText().toString();
                intent.putExtra("Yritys Oy",st);
                startActivity(intent);
                finish();
            }



        });
    }

   /* public void process(View view) {
        Intent intent=null;
        intent = new Intent(android.content.Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo: 60.192059,24.945831"));
        startActivity(intent);



    }*/



    public void goPlacePicker(View view) {

        //this is the place to call the place picker function

        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {
                startActivityForResult(builder.build(HomeActivity.this), PLACE_PICKER_REQUEST);
            
        }  catch (GooglePlayServicesRepairableException e)   {
            e.printStackTrace();
        }    catch (GooglePlayServicesNotAvailableException e)  {

            e.printStackTrace();
        }
    }

      @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
           if(requestCode == PLACE_PICKER_REQUEST){

               if(resultCode == RESULT_OK){


                   Place place = PlacePicker.getPlace(data, HomeActivity.this);
                   tvPlace.setText(place.getAddress());

                   
               }

               
           }
        
    }



}
