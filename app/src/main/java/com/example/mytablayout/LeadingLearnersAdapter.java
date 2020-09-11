package com.example.mytablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mytablayout.model.Student;

import java.util.List;

public class LeadingLearnersAdapter extends RecyclerView.Adapter<LeadingLearnersAdapter.StudentsViewHolder> {

    List<Student> students;
    private int rowLayout;
    private Context context;


    public LeadingLearnersAdapter(List<Student> students, int rowLayout, Context context) {
        this.students = students;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public LeadingLearnersAdapter.StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        return new StudentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadingLearnersAdapter.StudentsViewHolder holder, int position) {

        holder.tvStudentName.setText(students.get(position).getName());
        holder.tvStudentHoursCountry.setText(String.format("%s,%s", students.get(position).getHours(),
                students.get(position).getCountry()));

        Glide.with(context).load(students.get(position).getBadgeUrl()).into(holder.imgStudentBadgeImage);

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout studentsLayout;
        TextView tvStudentName;
        TextView tvStudentHoursCountry;
        ImageView imgStudentBadgeImage;


        public StudentsViewHolder(@NonNull View itemView) {
            super(itemView);

            studentsLayout = itemView.findViewById(R.id.leading_item);
            tvStudentName = itemView.findViewById(R.id.learnerName);
            tvStudentHoursCountry = itemView.findViewById(R.id.learningHoursCountry);

            imgStudentBadgeImage = itemView.findViewById(R.id.learnerImg);
        }
    }
}
