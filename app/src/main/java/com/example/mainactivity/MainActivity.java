package com.example.mainactivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerc,spinner1,spinner2,spinner3,spinner4,spinner5,spinner6;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Course");

        spinnerc = (Spinner) findViewById(R.id.spinnercourse);

        CollectionReference nameRef = db.collection("course");
        final List<String> courses = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_item, courses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerc.setAdapter(adapter);
        courses.add("Choose your course");
        nameRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("name");

                        courses.add(name);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
        spinnerc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Choose your course")){

                }
                else {
                    String item = parent.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(), Subject.class);
                    intent.putExtra("courseName", item);
                    startActivity(intent);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }




}
