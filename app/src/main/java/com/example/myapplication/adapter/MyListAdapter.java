package com.example.myapplication.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CommentsFragment;
import com.example.myapplication.R;
import com.example.myapplication.apiInterface.SendComment;
import com.example.myapplication.model.Root;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private ArrayList<Root> listdata;
    private Context context;
    RecyclerView recyclerView;
    SendComment sendComment;
    
    public MyListAdapter(ArrayList<Root> listdata, Context context, RecyclerView recyclerView) {
        this.listdata = listdata;
        this.context = context;
        this.recyclerView = recyclerView;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    
    
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.postText.setText(listdata.get(position).post);
        holder.postLayout.setOnClickListener(view ->
        {
            recyclerView.setVisibility(View.INVISIBLE);
            CommentsFragment commentsFragment = new CommentsFragment();
            sendComment.sendCommentList(((ArrayList<String>) listdata.get(position).getComments()));
            FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.slide_down, R.anim.slide_up); // Top Fragment Animation fragmentManager.beginTransaction()
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, commentsFragment).commit();
            
        });
    }
    
    
    @Override
    public int getItemCount() {
        return 9;
    }
    
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView postText;
        public LinearLayout postLayout;
        
        public ViewHolder(View itemView) {
            super(itemView);
            postText = (TextView) itemView.findViewById(R.id.post);
            postLayout = (LinearLayout) itemView.findViewById(R.id.post_layout);
        }
    }
}
