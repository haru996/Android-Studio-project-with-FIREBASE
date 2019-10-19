package com.example.mainactivity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.DataSource;
import com.couchbase.lite.Database;
import com.couchbase.lite.DatabaseConfiguration;
import com.couchbase.lite.QueryBuilder;
import com.couchbase.lite.Result;
import com.couchbase.lite.ResultSet;
import com.couchbase.lite.SelectResult;

import java.util.ArrayList;
import java.util.List;

public class Record extends AppCompatActivity {
    private RecordAdapter recordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        setTitle("Record");
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            recordAdapter = new RecordAdapter(this);
            recyclerView.setAdapter(recordAdapter);
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }
    }
}

class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordViewHolder>{
    private List<Result> results=new ArrayList<>();
    private  AppCompatActivity activity;
    private String style;
    private String color;
    RecordAdapter(AppCompatActivity activity) throws CouchbaseLiteException {
        this.activity = activity;
        this.setData();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        color = sharedPreferences.getString("list_back_ground","0");
        style = sharedPreferences.getString("list_style","0");
    }
    public void setData() throws CouchbaseLiteException {
        DatabaseConfiguration conf = new DatabaseConfiguration(activity);
        Database db = new Database("record",conf);

        ResultSet rs=QueryBuilder.select(
                SelectResult.property("title"),
                SelectResult.property("subject_num"),
                SelectResult.property("average")
        ).from(DataSource.database(db)).execute();

        results = rs.allResults();
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecordViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.record_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder recordViewHolder, int i) {
        if(style.equals("1")){
            recordViewHolder.title.setTypeface(null, Typeface.ITALIC);
            recordViewHolder.subjects.setTypeface(null, Typeface.ITALIC);
            recordViewHolder.average.setTypeface(null, Typeface.ITALIC);
        }else if(style.equals("2")){
            recordViewHolder.title.setTypeface(null, Typeface.BOLD);
            recordViewHolder.subjects.setTypeface(null, Typeface.BOLD);
            recordViewHolder.average.setTypeface(null, Typeface.BOLD);
        }

        if(color.equals("1")){
            recordViewHolder.v.setBackgroundColor(0xFF45B6FE);;
        }else if(color.equals("2")){
            recordViewHolder.v.setBackgroundColor(0xFF24333);;
        }else{
            recordViewHolder.v.setBackgroundColor(0xFFEFEFEF);;
        }
        recordViewHolder.title.setText("Semester: "+this.results.get(i).getString("title"));
        recordViewHolder.subjects.setText("Total subjects: "+this.results.get(i).getString("subject_num"));
        recordViewHolder.average.setText("Average: "+this.results.get(i).getString("average"));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static class RecordViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView subjects;
        TextView average;
        View v;
        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            v=itemView.findViewById(R.id.block);
            title = itemView.findViewById(R.id.semester);
            subjects = itemView.findViewById(R.id.subject_num);
            average = itemView.findViewById(R.id.average);
        }
    }
}