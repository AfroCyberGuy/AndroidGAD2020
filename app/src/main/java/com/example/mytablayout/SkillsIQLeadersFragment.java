package com.example.mytablayout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytablayout.app.APIUtils;
import com.example.mytablayout.app.UserService;
import com.example.mytablayout.model.IQStudent;
import com.example.mytablayout.model.Student;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillsIQLeadersFragment extends Fragment {



    UserService userService;
    List<IQStudent> studentList = new ArrayList<>();

    RecyclerView recyclerView;



    private View view;

    public SkillsIQLeadersFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userService = APIUtils.getLearnersIQ();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view  =  inflater.inflate(R.layout.skills_iq_learners_fragment, container, false);

        recyclerView = view.findViewById(R.id.skillIQList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getSkillsIQLearners();
        return view;
    }


    private void getSkillsIQLearners() {

        Call<List<IQStudent>> call = userService.getLearnersIq();
        call.enqueue(new Callback<List<IQStudent>>() {
            @Override
            public void onResponse(Call<List<IQStudent>> call, Response<List<IQStudent>> response) {

                if (response.isSuccessful()) {

                    studentList = response.body();

                    int cnt = studentList.size();

                    studentList = response.body();

                    recyclerView.setAdapter(new IQLearnersAdapter(studentList, R.layout.iq_student_list_item, getContext()));

                    Log.d("LEADING_LEARNERS:", studentList.toString());

                    Log.d("STUDENT_COUNT: ", String.valueOf(studentList.size()));
                }


            }

            @Override
            public void onFailure(Call<List<IQStudent>> call, Throwable t) {

                Log.e("ERROR", t.getMessage());
            }
        });



    }
}
