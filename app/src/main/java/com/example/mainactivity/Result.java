package com.example.mainactivity;
import android.content.Intent;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.DatabaseConfiguration;
import com.couchbase.lite.MutableDocument;

public class Result extends AppCompatActivity {
//    private TextView textView9,textView10,textView11,textView18,textView19,textView20,textView33,textView21,textView22,textView23,textView24,textView25,textView26,textView27,textView28,textView29,textView30,textView31,textView32;
    private String item11,item21,item31,item41,item51,item61,credit1,credit2,credit3,credit4,credit5,credit6,mark1,mark2,mark3,mark4,mark5,mark6,grade;
    private Double marks,credit,creditvalue;
    private Double total,credittotal,c1,c2,c3,c4,c5,c6;
    private Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("Result");
        final TextView textView9 = findViewById(R.id.textView9);
        final TextView textView10 = findViewById(R.id.textView10);
        final TextView textView11 = findViewById(R.id.textView11);
        final TextView textView18 = findViewById(R.id.textView18);
        final TextView textView19 = findViewById(R.id.textView19);
        final TextView textView20 = findViewById(R.id.textView20);
        final TextView textView21 = findViewById(R.id.textView21);
        final TextView textView22 = findViewById(R.id.textView22);
        final TextView textView23 = findViewById(R.id.textView23);
        final TextView textView24 = findViewById(R.id.textView24);
        final TextView textView25 = findViewById(R.id.textView25);
        final TextView textView26 = findViewById(R.id.textView26);
        final TextView textView27 = findViewById(R.id.textView27);
        final TextView textView28 = findViewById(R.id.textView28);
        final TextView textView29 = findViewById(R.id.textView29);
        final TextView textView30 = findViewById(R.id.textView30);
        final TextView textView31 = findViewById(R.id.textView31);
        final TextView textView32 = findViewById(R.id.textView32);
        final TextView textView33 = findViewById(R.id.textView33);
        mark1 = getIntent().getExtras().get("mark1").toString();
        mark2 = getIntent().getExtras().get("mark2").toString();
        mark3 = getIntent().getExtras().get("mark3").toString();
        mark4 = getIntent().getExtras().get("mark4").toString();
        mark5 = getIntent().getExtras().get("mark5").toString();
        mark6 = getIntent().getExtras().get("mark6").toString();
        item11 = getIntent().getExtras().get("subject1").toString();
        item21 = getIntent().getExtras().get("subject2").toString();
        item31 = getIntent().getExtras().get("subject3").toString();
        item41 = getIntent().getExtras().get("subject4").toString();
        item51 = getIntent().getExtras().get("subject5").toString();
        item61 = getIntent().getExtras().get("subject6").toString();


        if (item11.isEmpty()){
            credit1 = "";

        }
        else{
            count=1;
            credit1 = getIntent ().getExtras().get("credit1").toString();
            credit = Double.parseDouble(credit1);
            marks = Double.parseDouble(mark1);
            if (marks > 100) {
                grade = "Invalid marks";
            } else if (marks >= 70) {
                grade = "A";
                creditvalue = marks * credit;

            } else if (marks >= 60) {
                grade = "B";
                creditvalue = marks * credit;
            } else if (marks >= 50) {
                grade = "C";
                creditvalue = marks * credit;
            } else if (marks >= 40) {
                grade = "D";
                creditvalue = marks * credit;
            } else if (marks >= 0) {
                grade = "F";
                creditvalue = marks * credit;
            }
            textView21.setText(grade);
            textView27.setText(creditvalue.toString());

        }
        if (item21.isEmpty()){
            credit2 = "";

        }
        else{
            count=2;
            credit2 = getIntent ().getExtras().get("credit2").toString();
            credit = Double.parseDouble(credit2);
            marks = Double.parseDouble(mark2);
            if (marks > 100) {
                grade = "Invalid marks";
            } else if (marks >= 70) {
                grade = "A";
                creditvalue = marks * credit;

            } else if (marks >= 60) {
                grade = "B";
                creditvalue = marks * credit;
            } else if (marks >= 50) {
                grade = "C";
                creditvalue = marks * credit;
            } else if (marks >= 40) {
                grade = "D";
                creditvalue = marks * credit;
            } else if (marks >= 0) {
                grade = "F";
                creditvalue = marks * credit;
            }
            textView22.setText(grade);
            textView28.setText(creditvalue.toString());
        }
        if (item31.isEmpty()){
            credit3 = "";

        }
        else{
            count=3;
            credit3 = getIntent ().getExtras().get("credit3").toString();
            credit = Double.parseDouble(credit3);
            marks = Double.parseDouble(mark3);
            if (marks > 100) {
                grade = "Invalid marks";
            } else if (marks >= 70) {
                grade = "A";
                creditvalue = marks * credit;

            } else if (marks >= 60) {
                grade = "B";
                creditvalue = marks * credit;
            } else if (marks >= 50) {
                grade = "C";
                creditvalue = marks * credit;
            } else if (marks >= 40) {
                grade = "D";
                creditvalue = marks * credit;
            } else if (marks >= 0) {
                grade = "F";
                creditvalue = marks * credit;
            }
            textView23.setText(grade);
            textView29.setText(creditvalue.toString());
        }
        if (item41.isEmpty()){
            credit4 = "";

        }
        else{
            count=4;
            credit4 = getIntent ().getExtras().get("credit4").toString();
            credit = Double.parseDouble(credit4);
            marks = Double.parseDouble(mark4);
            if (marks > 100) {
                grade = "Invalid marks";
            } else if (marks >= 70) {
                grade = "A";
                creditvalue = marks * credit;

            } else if (marks >= 60) {
                grade = "B";
                creditvalue = marks * credit;
            } else if (marks >= 50) {
                grade = "C";
                creditvalue = marks * credit;
            } else if (marks >= 40) {
                grade = "D";
                creditvalue = marks * credit;
            } else if (marks >= 0) {
                grade = "F";
                creditvalue = marks * credit;
            }
            textView24.setText(grade);
            textView30.setText(creditvalue.toString());
        }
        if (item51.isEmpty()){
            credit5 = "";

        }
        else{
            count=5;
            credit5 = getIntent ().getExtras().get("credit5").toString();
            credit = Double.parseDouble(credit5);
            marks = Double.parseDouble(mark5);
            if (marks > 100) {
                grade = "Invalid marks";
            } else if (marks >= 70) {
                grade = "A";
                creditvalue = marks * credit;

            } else if (marks >= 60) {
                grade = "B";
                creditvalue = marks * credit;
            } else if (marks >= 50) {
                grade = "C";
                creditvalue = marks * credit;
            } else if (marks >= 40) {
                grade = "D";
                creditvalue = marks * credit;
            } else if (marks >= 0) {
                grade = "F";
                creditvalue = marks * credit;
            }
            textView25.setText(grade);
            textView31.setText(creditvalue.toString());
        }
        if (item61.isEmpty()){
            credit6 = "";

        }
        else{
            count=6;
            credit6 = getIntent ().getExtras().get("credit6").toString();
            credit = Double.parseDouble(credit6);
            marks = Double.parseDouble(mark6);
            if (marks > 100) {
                grade = "Invalid marks";
            } else if (marks >= 70) {
                grade = "A";
                creditvalue = marks * credit;

            } else if (marks >= 60) {
                grade = "B";
                creditvalue = marks * credit;
            } else if (marks >= 50) {
                grade = "C";
                creditvalue = marks * credit;
            } else if (marks >= 40) {
                grade = "D";
                creditvalue = marks * credit;
            } else if (marks >= 0) {
                grade = "F";
                creditvalue = marks * credit;
            }
            textView26.setText(grade);
            textView32.setText(creditvalue.toString());
        }

        if (count==1) {

            c1 = Double.parseDouble(textView27.getText().toString());


           Double cre1 = Double.parseDouble(credit1);


            total = c1/cre1;
            //calculation for total credit
        }

       else if (count==2) {
            c1 = Double.parseDouble(textView27.getText().toString());
            c2 = Double.parseDouble(textView28.getText().toString());
            Double cre1 = Double.parseDouble(credit1);
            Double cre2 = Double.parseDouble(credit2);

            Double tc = c1+c2;
            credittotal = cre1+cre2;
            total = tc/credittotal;

        }

        if (count==3) {
            c1 = Double.parseDouble(textView27.getText().toString());
            c2 = Double.parseDouble(textView28.getText().toString());
            c3 = Double.parseDouble(textView29.getText().toString());
            Double cre1 = Double.parseDouble(credit1);
            Double cre2 = Double.parseDouble(credit2);
            Double cre3 = Double.parseDouble(credit3);

            Double tc = c1+c2+c3;
            credittotal = cre1+cre2+cre3;
            total = tc/credittotal;
        }

        if (count==4) {
            c1 = Double.parseDouble(textView27.getText().toString());
            c2 = Double.parseDouble(textView28.getText().toString());
            c3 = Double.parseDouble(textView29.getText().toString());
            c4 = Double.parseDouble(textView30.getText().toString());
            Double cre1 = Double.parseDouble(credit1);
            Double cre2 = Double.parseDouble(credit2);
            Double cre3 = Double.parseDouble(credit3);
            Double cre4 = Double.parseDouble(credit4);

            Double tc = c1+c2+c3+c4;
            credittotal = cre1+cre2+cre3+cre4;
            total = tc/credittotal;
        }

        if (count==5) {
            c1 = Double.parseDouble(textView27.getText().toString());
            c2 = Double.parseDouble(textView28.getText().toString());
            c3 = Double.parseDouble(textView29.getText().toString());
            c4 = Double.parseDouble(textView30.getText().toString());
            c5 = Double.parseDouble(textView31.getText().toString());
            Double cre1 = Double.parseDouble(credit1);
            Double cre2 = Double.parseDouble(credit2);
            Double cre3 = Double.parseDouble(credit3);
            Double cre4 = Double.parseDouble(credit4);
            Double cre5 = Double.parseDouble(credit5);

            Double tc = c1+c2+c3+c4+c5;
            credittotal = cre1+cre2+cre3+cre4+cre5;
            total = tc/credittotal;
        }
        if (count==6) {
            c1 = Double.parseDouble(textView27.getText().toString());
            c2 = Double.parseDouble(textView28.getText().toString());
            c3 = Double.parseDouble(textView29.getText().toString());
            c4 = Double.parseDouble(textView30.getText().toString());
            c5 = Double.parseDouble(textView31.getText().toString());
            c6 = Double.parseDouble(textView32.getText().toString());
            Double cre1 = Double.parseDouble(credit1);
            Double cre2 = Double.parseDouble(credit2);
            Double cre3 = Double.parseDouble(credit3);
            Double cre4 = Double.parseDouble(credit4);
            Double cre5 = Double.parseDouble(credit5);
            Double cre6 = Double.parseDouble(credit6);

            Double tc = c1+c2+c3+c4+c5+c6;
            credittotal = cre1+cre2+cre3+cre4+cre5+cre6;
            total = tc/credittotal;
        }



        textView9.setText(item11);
        textView10.setText(item21);
        textView11.setText(item31);
        textView18.setText(item41);
        textView19.setText(item51);
        textView20.setText(item61);
        textView33.setText("Your total average is " + String.format("%.2f",total));

        Button btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(v->{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Save as semester:");
                final EditText input = new EditText(this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);
                builder.setPositiveButton("confirm",(d,i)->{
                    try {
                        DatabaseConfiguration conf = new DatabaseConfiguration(this);
                        Database db = new Database("record",conf);

                        MutableDocument doc = new MutableDocument();
                        doc.setString("title",input.getText()+"");
                        doc.setString("subject_num",count+"");
                        doc.setString("average",total+"");
                        db.save(doc);
                        Toast.makeText(this,"Saved!",Toast.LENGTH_LONG).show();
                        finish();

                    } catch (CouchbaseLiteException e) {
                        e.printStackTrace();
                    }
                }).setNegativeButton("cancel",(d,i)->{

                }).show();


        });
    }
}
