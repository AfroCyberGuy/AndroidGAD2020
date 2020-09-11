package com.example.mytablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mytablayout.model.IQStudent;
import com.example.mytablayout.model.Student;

import java.util.List;

public class IQLearnersAdapter extends RecyclerView.Adapter<IQLearnersAdapter.IQLearnersViewHolder> {

    List<IQStudent> iqStudents;
    private int rowLayout;
    private Context context;


    public IQLearnersAdapter(List<IQStudent> iqStudents, int rowLayout, Context context) {
        this.iqStudents = iqStudents;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public IQLearnersAdapter.IQLearnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        return new IQLearnersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IQLearnersAdapter.IQLearnersViewHolder holder, int position) {


        holder.tvStudentName.setText(iqStudents.get(position).getName());
        holder.tvStudentScore.setText(String.format("%s,%s", iqStudents.get(position).getScore(),
                iqStudents.get(position).getCountry()));

        Glide.with(context).load(iqStudents.get(position).getBadgeUrl()).into(holder.imgStudentBadgeImage);


    }

    @Override
    public int getItemCount() {
        return iqStudents.size();
    }

    public class IQLearnersViewHolder extends RecyclerView.ViewHolder {

        TextView tvStudentName;
        TextView tvStudentScore;
        ImageView imgStudentBadgeImage;

        public IQLearnersViewHolder(@NonNull View itemView) {
            super(itemView);

            tvStudentName = itemView.findViewById(R.id.iq_learnerName);
            tvStudentScore = itemView.findViewById(R.id.iq_StudentScore);
            imgStudentBadgeImage = itemView.findViewById(R.id.iq_learnerImg);
        }
    }
}
