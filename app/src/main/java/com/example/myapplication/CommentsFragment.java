package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.apiInterface.SendComment;
import com.example.myapplication.model.Root;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.Objects;

public class CommentsFragment extends Fragment implements SendComment {
    ArrayList<String> commentArrayList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        return view;
    }
    
    @Override
    public void sendCommentList(ArrayList<String> commentArrayList) {
     this.commentArrayList = commentArrayList;
    }
}