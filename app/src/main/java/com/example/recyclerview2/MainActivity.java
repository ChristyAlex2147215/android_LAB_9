package com.example.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<PlanetModel> planetModels=new ArrayList<>();
    int [] planetimages={R.drawable.car1,R.drawable.car2,R.drawable.car3,
            R.drawable.car4,R.drawable.car5,R.drawable.car6,
            R.drawable.car7,R.drawable.car3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView  recyclerView=findViewById(R.id.mrecyclerView);
        setupplanetsmodel();
        AA_RecycleViewAdapter adapter=new AA_RecycleViewAdapter(this,
                planetModels,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

    }
    private  void setupplanetsmodel()
    {
    String[] planetnames=getResources().getStringArray(R.array.planets);
    String[] planetdescription=getResources().getStringArray(R.array.description);
    String[] planetPrices=getResources().getStringArray(R.array.price);
    String[] planetMilage=getResources().getStringArray(R.array.milage);
    for(int i=0;i<planetnames.length;i++)
    {
        planetModels.add(new PlanetModel(planetnames[i],
                planetdescription[i],
                planetimages[i],planetPrices[i],planetMilage[i]));
    }

    }

    @Override
    public void onItemClick(int position) {
        Intent intent= new Intent(MainActivity.this,MainActivity2.class);

        intent.putExtra("NAME",planetModels.get(position).getPlanetname());
        intent.putExtra("Description",planetModels.get(position).getPlanetdescription());
        intent.putExtra("Image",planetModels.get(position).getImage());
        intent.putExtra("Price",planetModels.get(position).getPrice());
        intent.putExtra("Milage",planetModels.get(position).getMilage());
        startActivity(intent);


    }
}