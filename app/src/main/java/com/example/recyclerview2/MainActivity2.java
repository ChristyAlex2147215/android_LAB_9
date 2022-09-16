package com.example.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

//page that loads when a click on item
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String NAME=getIntent().getStringExtra("NAME");
        String Description =getIntent().getStringExtra("Description");
        String PRICE=getIntent().getStringExtra("Price");
        String MILAGE =getIntent().getStringExtra("Milage");
        int image=getIntent().getIntExtra("Image",0);
        TextView nameTextView=findViewById(R.id.planetname);
        TextView namedescription=findViewById(R.id.planetdescription);
        TextView namePrice=findViewById(R.id.planetprice);
        TextView nameMilage=findViewById(R.id.planemilage);
        ImageView planetimage= findViewById(R.id.planetimage);
        nameTextView.setText(NAME);
        namedescription.setText(Description);
        planetimage.setImageResource(image);
        nameMilage.setText(PRICE);
        namePrice.setText(MILAGE);
    }
}