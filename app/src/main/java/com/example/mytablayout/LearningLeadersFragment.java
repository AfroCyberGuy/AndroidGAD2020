package com.example.mytablayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytablayout.app.APIUtils;
import com.example.mytablayout.app.UserService;
import com.example.mytablayout.model.Student;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningLeadersFragment extends Fragment {


    UserService userService;
    List<Student> studentList = new ArrayList<>();

    RecyclerView recyclerView;



    private View view;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userService = APIUtils.getLeadingLearners();




    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view  =  inflater.inflate(R.layout.leading_learners_fragment, container, false);

        recyclerView = view.findViewById(R.id.leadingLearnersList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));




                getLeadingLearners();

        return view;
    }




    private void getLeadingLearners() {

        Call<List<Student>> call = userService.getLearnersHours();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                if (response.isSuccessful()) {

                    studentList = response.body();

                    int cnt = studentList.size();

                    studentList = response.body();

                    recyclerView.setAdapter(new LeadingLearnersAdapter(studentList, R.layout.leading_student_list_item, getContext()));

                    Log.d("LEADING_LEARNERS:", studentList.toString());

                    Log.d("STUDENT_COUNT: ", String.valueOf(studentList.size()));
                }


            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

                Log.e("ERROR", t.getMessage());
            }
        });



    }
}
