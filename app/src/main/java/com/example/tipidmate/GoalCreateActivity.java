package com.example.tipidmate;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class GoalCreateActivity extends AppCompatActivity {

    private EditText etTitle, etAmount, etDate;
    private Spinner spCategory;

    private final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_create);

        etTitle = findViewById(R.id.et_goal_title);
        etAmount = findViewById(R.id.et_target_amount);
        etDate = findViewById(R.id.et_completion_date);
        spCategory = findViewById(R.id.sp_category);

        ImageView btnBack = findViewById(R.id.btn_back);
        Button btnSetGoal = findViewById(R.id.btn_set_goal);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.goal_categories,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(adapter);

        etDate.setOnClickListener(v -> showDatePicker());
        btnBack.setOnClickListener(v -> finish());

        btnSetGoal.setOnClickListener(v -> {
            if (etTitle.getText().toString().isEmpty()
                    || etAmount.getText().toString().isEmpty()) {
                Toast.makeText(this, "Fill required fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent data = new Intent();
            data.putExtra("goal_title", etTitle.getText().toString());
            data.putExtra("goal_category", spCategory.getSelectedItem().toString());
            data.putExtra("goal_amount", etAmount.getText().toString());

            setResult(RESULT_OK, data);
            finish();
        });
    }

    private void showDatePicker() {
        new DatePickerDialog(this,
                (v, y, m, d) -> {
                    calendar.set(y, m, d);
                    SimpleDateFormat sdf =
                            new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
                    etDate.setText(sdf.format(calendar.getTime()));
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        ).show();
    }
}
