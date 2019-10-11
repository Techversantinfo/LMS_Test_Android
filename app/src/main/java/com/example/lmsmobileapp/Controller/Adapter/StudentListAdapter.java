package com.example.lmsmobileapp.Controller.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lmsmobileapp.Model.StudentModel.Response;
import com.example.lmsmobileapp.R;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.MyViewHolder> {

    private List<Response> mUserList;
    private Context mContext;

    public StudentListAdapter(Context context ,List<Response> modelList) {
        this.mUserList = modelList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public StudentListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final StudentListAdapter.MyViewHolder holder, final int position) {

        // get the position and check whether it is even or odd.
        // If it is even, set the background color of your layout to grey else white
        if(position%2 == 0){
            holder.containerLayout.setBackgroundResource(R.color.bg_main_grey);
        }else {
            holder.containerLayout.setBackgroundResource(R.color.transparent);
        }

        final Response user = mUserList.get(position);
        if (!user.getFirstName().equals(null) || !user.getLastName().equals(null))
            holder.studentName.setText(user.getFirstName() + " " + user.getLastName());

        if (!user.getGroup().equals(null))
            holder.groupName.setText(user.getGroup());

    }

    @Override
    public int getItemCount() {
        return mUserList == null ? 0 : mUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView studentName, groupName;
        private LinearLayout containerLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            studentName = (TextView) itemView.findViewById(R.id.tvStudentName);
            groupName = (TextView) itemView.findViewById(R.id.tvGroupName);
            containerLayout = (LinearLayout) itemView.findViewById(R.id.containerLayout);
        }
    }
}