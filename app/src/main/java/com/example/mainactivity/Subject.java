package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Subject extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private Button calculate;
    private ActionBarDrawerToggle toggle;
    private Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6;
    private TextView textView12,textView13,textView14,textView15,textView16,textView17,test;
    private String item1,testS,markone,marktwo,markthree,markfour,markfive,marksix,one ,two ,three ,four,five ,six ;
    private Double credit1,credit2,credit3,credit4,credit5,credit6;
    private EditText editText18,editText19,editText20,editText21,editText22,editText23;
    private FirebaseFirestore db = com.google.firebase.firestore.FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setTitle("Subject Taken");
        final TextView textView12 = findViewById(R.id.textView12);
        final TextView textView13 = findViewById(R.id.textView13);
        final TextView textView14 = findViewById(R.id.textView14);
        final TextView textView15 = findViewById(R.id.textView15);
        final TextView textView16 = findViewById(R.id.textView16);
        final TextView textView17 = findViewById(R.id.textView17);
        calculate = (Button) findViewById(R.id.buttoncalculate);

        editText18 = (EditText) findViewById(R.id.editText18);
        editText19 = (EditText) findViewById(R.id.editText19);
        editText20 = (EditText) findViewById(R.id.editText20);
        editText21 = (EditText) findViewById(R.id.editText21);
        editText22 = (EditText) findViewById(R.id.editText22);
        editText23 = (EditText) findViewById(R.id.editText23);
        spinner1 = (Spinner) findViewById(R.id.spinner7);
        spinner2 = (Spinner) findViewById(R.id.spinner8);
        spinner3 = (Spinner) findViewById(R.id.spinner10);
        spinner4 = (Spinner) findViewById(R.id.spinner11);
        spinner5 = (Spinner) findViewById(R.id.spinner12);
        spinner6 = (Spinner) findViewById(R.id.spinner13);
        item1 = getIntent().getExtras().get("courseName").toString();
        Intent intent3 = new Intent(getApplicationContext(), Result.class);
        CollectionReference nameRef = db.collection(item1);
        final List<String> subjects = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        spinner6.setAdapter(adapter);
       subjects.add("Subject code");
        nameRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String code = document.getString("code");

                       subjects.add(code);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Subject code")){

                }
                else {

                    String item = parent.getItemAtPosition(position).toString();
//                    item1 = getIntent().getExtras().get("courseName").toString();
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection(item1).whereEqualTo("code",item)
                            .get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {


                                        textView12.setText(document.getString("name"));
                                         credit1 = document.getDouble("credit");


//                                        intent3.putExtra("credit1", credit1);




                                    }
                                } else {
                                    Log.w("TAG", "Error getting documents.", task.getException());
                                }
                            });
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Subject code")){

                }
                else {
                    String item = parent.getItemAtPosition(position).toString();
                    item1 = getIntent().getExtras().get("courseName").toString();
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection(item1).whereEqualTo("code",item)
                            .get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        textView13.setText(document.getString("name"));
                                        credit2 = document.getDouble("credit");



                                    }
                                } else {
                                    Log.w("TAG", "Error getting documents.", task.getException());
                                }
                            });
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Subject code")){

                }
                else {
                    String item = parent.getItemAtPosition(position).toString();
                    item1 = getIntent().getExtras().get("courseName").toString();
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection(item1).whereEqualTo("code",item)
                            .get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        textView14.setText(document.getString("name"));
                                     credit3 = document.getDouble("credit");



                                    }
                                } else {
                                    Log.w("TAG", "Error getting documents.", task.getException());
                                }
                            });
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Subject code")){

                }
                else {
                    String item = parent.getItemAtPosition(position).toString();
                    item1 = getIntent().getExtras().get("courseName").toString();
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection(item1).whereEqualTo("code",item)
                            .get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        textView15.setText(document.getString("name"));
                                        credit4 = document.getDouble("credit");



                                    }
                                } else {
                                    Log.w("TAG", "Error getting documents.", task.getException());
                                }
                            });
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Subject code")){

                }
                else {
                    String item = parent.getItemAtPosition(position).toString();
                    item1 = getIntent().getExtras().get("courseName").toString();
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection(item1).whereEqualTo("code",item)
                            .get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        textView16.setText(document.getString("name"));
                                       credit5 = document.getDouble("credit");



                                    }
                                } else {
                                    Log.w("TAG", "Error getting documents.", task.getException());
                                }
                            });
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Subject code")){

                }
                else {
                    String item = parent.getItemAtPosition(position).toString();
                    item1 = getIntent().getExtras().get("courseName").toString();
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection(item1).whereEqualTo("code",item)
                            .get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        textView17.setText(document.getString("name"));
                                        credit6 = document.getDouble("credit");




                                    }
                                } else {
                                    Log.w("TAG", "Error getting documents.", task.getException());
                                }
                            });
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                markone = editText18.getText().toString();
                marktwo = editText19.getText().toString();
                markthree = editText20.getText().toString();
                markfour = editText21.getText().toString();
                markfive = editText22.getText().toString();
                marksix = editText23.getText().toString();
                one = textView12.getText().toString();
                intent3.putExtra("subject1", one);
                two = textView13.getText().toString();
                intent3.putExtra("subject2", two);
                three = textView14.getText().toString();
                intent3.putExtra("subject3", three);
                four = textView15.getText().toString();
                intent3.putExtra("subject4", four);
                five = textView16.getText().toString();
                intent3.putExtra("subject5", five);
                six = textView17.getText().toString();
                intent3.putExtra("subject6", six);
                if(markone.isEmpty() && !(one.isEmpty())){

                    Toast.makeText(Subject.this, "Please enter the mark of the subject you selected", Toast.LENGTH_SHORT).show();
                }
               else if(markthree.isEmpty() && !(three.isEmpty())){

                    Toast.makeText(Subject.this, "Please enter the mark of the subject you selected", Toast.LENGTH_SHORT).show();
                }
                else if(marktwo.isEmpty() && !(two.isEmpty())){

                    Toast.makeText(Subject.this, "Please enter the mark of the subject you selected", Toast.LENGTH_SHORT).show();
                }
                else if(markfour.isEmpty() && !(four.isEmpty())){

                    Toast.makeText(Subject.this, "Please enter the mark of the subject you selected", Toast.LENGTH_SHORT).show();
                }
                else if(markfive.isEmpty() && !(five.isEmpty())){

                    Toast.makeText(Subject.this, "Please enter the mark of the subject you selected", Toast.LENGTH_SHORT).show();
                }
                else if(marksix.isEmpty() && !(six.isEmpty())){

                    Toast.makeText(Subject.this, "Please enter the mark of the subject you selected", Toast.LENGTH_SHORT).show();
                }
                else if (one.isEmpty()&&two.isEmpty()&&three.isEmpty()&&four.isEmpty()&&five.isEmpty()&&six.isEmpty()){
                    Toast.makeText(Subject.this, "You not selected any subject", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent3.putExtra("mark1", markone);
                    intent3.putExtra("mark2", marktwo);
                    intent3.putExtra("mark3", markthree);
                    intent3.putExtra("mark4", markfour);
                    intent3.putExtra("mark5", markfive);
                    intent3.putExtra("mark6", marksix);

                    intent3.putExtra("credit1", credit1);
                    intent3.putExtra("credit2", credit2);
                    intent3.putExtra("credit3", credit3);
                    intent3.putExtra("credit4", credit4);
                    intent3.putExtra("credit5", credit5);
                    intent3.putExtra("credit6", credit6);
                    textView12.setText("");
                    textView13.setText("");
                    textView14.setText("");
                    textView15.setText("");
                    textView16.setText("");
                    textView17.setText("");
                    editText18.setText("");
                    editText19.setText("");
                    editText20.setText("");
                    editText21.setText("");
                    editText22.setText("");
                    editText23.setText("");
                    spinner1.setSelection(0);
                    spinner2.setSelection(0);
                    spinner3.setSelection(0);
                    spinner4.setSelection(0);
                    spinner5.setSelection(0);
                    spinner6.setSelection(0);

                    startActivity(intent3);

                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_home) {
//            // Handle the camera action
//        } else
       if (id == R.id.nav_setting) {
            Intent setting = new Intent(this,Settings.class);
            startActivity(setting);
        }
        else if (id == R.id.nav_view) {
            Intent exit =  new Intent(Subject.this,Record.class);
            startActivity(exit);
        }
        else if (id == R.id.nav_exit) {
          Intent exit =  new Intent(Subject.this,MainActivity.class);
          startActivity(exit);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
