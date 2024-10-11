package com.example.checklist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextTask1 = null;
    CheckBox checkBoxTask1 = null;
    EditText editTextTask2 = null;
    CheckBox checkBoxTask2 = null;
    EditText editTextTask3 = null;
    CheckBox checkBoxTask3 = null;
    EditText editTextTask4 = null;
    CheckBox checkBoxTask4 = null;
    EditText editTextTask5 = null;
    CheckBox checkBoxTask5 = null;
    EditText editTextEmail = null;
    Button button2 = null;

    String task1;
    String task2;
    String task3;
    String task4;
    String task5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask1 = (EditText)findViewById(R.id.editTextTask1);
        checkBoxTask1 = (CheckBox)findViewById(R.id.checkBoxTask1);
        checkBoxTask1.setOnClickListener(this);
        checkBoxTask1.setChecked(false);

        editTextTask2 = (EditText)findViewById(R.id.editTextTask2);
        checkBoxTask2 = (CheckBox)findViewById(R.id.checkBoxTask2);
        checkBoxTask2.setOnClickListener(this);
        checkBoxTask2.setChecked(false);

        editTextTask3 = (EditText)findViewById(R.id.editTextTask3);
        checkBoxTask3 = (CheckBox)findViewById(R.id.checkBoxTask3);
        checkBoxTask3.setOnClickListener(this);
        checkBoxTask3.setChecked(false);

        editTextTask4 = (EditText)findViewById(R.id.editTextTask4);
        checkBoxTask4 = (CheckBox)findViewById(R.id.checkBoxTask4);
        checkBoxTask4.setOnClickListener(this);
        checkBoxTask4.setChecked(false);

        editTextTask5 = (EditText)findViewById(R.id.editTextTask5);
        checkBoxTask5 = (CheckBox)findViewById(R.id.checkBoxTask5);
        checkBoxTask5.setOnClickListener(this);
        checkBoxTask5.setChecked(false);

        editTextEmail = (EditText)findViewById(R.id.editTextEmail);

        button2 = (Button)findViewById(R.id.button2);

        TextView done = (TextView)findViewById(R.id.done);
        done.setText(R.string.notDone);
    }

    public void onClick(View v){
        if(checkBoxTask1.isChecked() &
                checkBoxTask2.isChecked() &
                checkBoxTask3.isChecked() &
                checkBoxTask3.isChecked() &
                checkBoxTask4.isChecked() &
                checkBoxTask5.isChecked()){
            TextView done = (TextView)findViewById(R.id.done);
            done.setText(R.string.done);
            button2.setVisibility(View.VISIBLE);
            editTextEmail.setVisibility(View.VISIBLE);
        }
    }

    public void clearTasks(View v){
        if(checkBoxTask1.isChecked()){
            checkBoxTask1.setChecked(false);
        }
        if(checkBoxTask2.isChecked()){
            checkBoxTask2.setChecked(false);
        }
        if(checkBoxTask3.isChecked()){
            checkBoxTask3.setChecked(false);
        }
        if(checkBoxTask4.isChecked()){
            checkBoxTask4.setChecked(false);
        }
        if(checkBoxTask5.isChecked()){
            checkBoxTask5.setChecked(false);
        }

        button2.setVisibility(View.GONE);
        editTextEmail.setVisibility(View.GONE);

        TextView done = (TextView)findViewById(R.id.done);
        done.setText(R.string.notDone);
    }

    public void getTasks(View v){
        task1 = editTextTask1.getText().toString();
        task2 = editTextTask2.getText().toString();
        task3 = editTextTask3.getText().toString();
        task4 = editTextTask4.getText().toString();
        task5 = editTextTask5.getText().toString();

        ArrayList<String> tasks = new ArrayList<String>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);

        sendEmail(tasks);
    }

    public void sendEmail(ArrayList<String> tasks){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //only email should handle this
        intent.putStringArrayListExtra(Intent.EXTRA_TEXT, tasks);
        intent.putExtra(Intent.EXTRA_EMAIL, editTextEmail.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Completed Checklist");
        startActivity(intent);
    }
}