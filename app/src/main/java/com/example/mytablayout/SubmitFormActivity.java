package com.example.mytablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mytablayout.app.APIUtils;
import com.example.mytablayout.app.UserService;
import com.example.mytablayout.model.Student;
import com.example.mytablayout.model.SubmitStudent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitFormActivity extends AppCompatActivity {

    UserService userService;

    private ImageView imgBack;
    private EditText etStudentName;
    private EditText etStudentLastName;
    private EditText etStudentEmail;
    private EditText etProjectLink;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_form);

        userService = APIUtils.submitStudent();

        imgBack = findViewById(R.id.imgBack);
        etStudentName = findViewById(R.id.etStudentName);
        etStudentLastName = findViewById(R.id.etStudentLastName);
        etStudentEmail = findViewById(R.id.etStudentEmailAddress);
        etProjectLink = findViewById(R.id.etProjectLink);

        btnSubmit = findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etStudentName.getText())){

                    etStudentName.setError("Please enter your name.");
                }else if (TextUtils.isEmpty(etStudentLastName.getText())){

                    etStudentLastName.setError("Please enter your last name.");
                }else  if (TextUtils.isEmpty(etStudentEmail.getText())){

                    etStudentEmail.setError("Please enter your email address.");
                }else if (TextUtils.isEmpty(etProjectLink.getText())) {

                    etProjectLink.setError("Please enter Github project link.");
                }else {


                    submit(etStudentName.getText().toString(),
                            etStudentLastName.getText().toString(),
                            etStudentEmail.getText().toString(),
                            etProjectLink.getText().toString());

                }
            }
        });


        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }

    private void submit(String name, String lastName, String emailAddress, String projectLink) {

        Call<String> call = userService.addStudent(name, lastName, emailAddress, projectLink);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()){

                    Toast.makeText(getApplicationContext(), "Project submitted successfully.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Log.e("ERROR", t.getMessage());
            }
        });
    }


}