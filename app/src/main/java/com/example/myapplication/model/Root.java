package com.example.myapplication.model;
import java.util.List;

public class Root {
    public String post;
    
    @Override
    public String toString() {
        return "Root{" +
                "post='" + post + '\'' +
                ", comments=" + comments +
                '}';
    }
    
    public String getPost() {
        return post;
    }
    
    public void setPost(String post) {
        this.post = post;
    }
    
    public List<String> getComments() {
        return comments;
    }
    
    public void setComments(List<String> comments) {
        this.comments = comments;
    }
    
    public List<String> comments;
}


