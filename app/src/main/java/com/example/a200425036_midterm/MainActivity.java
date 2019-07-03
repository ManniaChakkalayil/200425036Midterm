package com.example.a200425036_midterm;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText firstName, LastName;
    Spinner spinner;
    Button play, reset;
    String userchoice, computerchoice;
    TextView androidchoice;
    int humanScore;
    int computerscore;
    String Winner;

  List<variable> list;

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.editText);
        LastName = findViewById(R.id.editText2);
        spinner = findViewById(R.id.spinner);
        play = findViewById(R.id.button);
        reset = findViewById(R.id.button2);
        androidchoice = findViewById(R.id.textView);

        list = new ArrayList<>();

        db = FirebaseDatabase.getInstance().getReference("data");


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rand();
                String msg ="Winner:"+Winner;

                Toast.makeText(MainActivity.this,Winner,Toast.LENGTH_SHORT).show();





            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName.setText("");
                LastName.setText("");
            }
        });

    }

    public static final Random rand = new Random();
    int randInt = rand.nextInt(100) + 1;

    {


        if (randInt < 34) {
            computerchoice = "Rock";
            androidchoice.setText(computerchoice);

        }
        if (randInt > 33 && randInt < 67) {
            computerchoice = "paper";
            androidchoice.setText(computerchoice);

        }
        if (randInt > 66) {
            computerchoice = "scissors";
            androidchoice.setText(computerchoice);

        }

        if ((userchoice == "stone") && (computerchoice == "paper")) {
            Winner = "Computer";

        } else if ((userchoice == "stone") && (computerchoice == "scissors")) {
            Winner = "User";


        } else if ((userchoice == "paper") && (computerchoice == "scissors")) {
            Winner = "Computer";

        } else if ((userchoice == "paper") && (computerchoice == "stone")) {
            Winner = "User";

        } else if ((userchoice == "scissors") && (computerchoice == "stone")) {
            Winner = "Computer";

        } else if ((userchoice == "scissors") && (computerchoice == "paper")) {

            Winner = "Computer";


        } else if (userchoice == "stone" && computerchoice == "stone")
            Winner= "draw";

        else if (userchoice == "paper" && computerchoice == "paper")
           Winner= "draw";

        else if (userchoice == "scissors" && computerchoice == "scissors")
          Winner = "draw";

        Toast.makeText(MainActivity.this, Winner, Toast.LENGTH_SHORT).show();

    }
    public void msg(String msg){
        String message= msg;
        String id=db.push().getKey();
        variable v=new variable(id,firstName,LastName,Winner);
        db.child(id).setValue(v);

    }


}





