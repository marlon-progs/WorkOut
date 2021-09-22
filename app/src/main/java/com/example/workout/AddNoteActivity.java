package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE =
            "com.codinginflow.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.codinginflow.architectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_DATE =
            "com.codinginflow.architectureexample.EXTRA_DATE";

    private EditText editTextTitle;
    private EditText editTextDescription;
    //private NumberPicker numberPickerPriority;
    //hier eintrag
    private DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        editTextDescription.setText("Default");
        //numberPickerPriority = findViewById(R.id.number_picker_priority);
        //numberPickerPriority.setMinValue(1);
        //numberPickerPriority.setMaxValue(10);

        datePicker=findViewById(R.id.date_picker);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //String currentDate = DateFormat.getDateInstance().format(calendar.getTime());


        datePicker.init(year, month, day, null);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        //int priority = numberPickerPriority.getValue();
        Calendar calendar = Calendar.getInstance();
        calendar.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
        String currentDateString = DateFormat.getDateInstance().format(calendar.getTime());
        Log.i(currentDateString,"currentDateString Value:");

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_DATE, currentDateString);
       // data.putExtra(EXTRA_DATE, calendar.getTimeInMillis());
        //exemple intent.putExtra("myDateKey", myDate.getTimeInMillis());
        setResult(RESULT_OK, data);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}