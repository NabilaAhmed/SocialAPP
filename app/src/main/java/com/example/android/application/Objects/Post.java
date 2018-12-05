package com.example.android.application.Objects;

/**
 * Created by nabila on 30/09/2018.
 */

public class Post {
    String PostID;
    String Post_Content;
    String Post_Owner;
    String PostSharers;

    public Post(String postID, String post_Content, String post_Owner, String postSharers) {
        PostID = postID;
        Post_Content = post_Content;
        Post_Owner = post_Owner;
        PostSharers = postSharers;
    }

    public void setPostID(String postID) {
        PostID = postID;
    }

    public void setPost_Content(String post_Content) {
        Post_Content = post_Content;
    }

    public void setPost_Owner(String post_Owner) {
        Post_Owner = post_Owner;
    }

    public void setPostSharers(String postSharers) {
        PostSharers = postSharers;
    }

    public Post() {

    }

    public String getPostID() {
        return PostID;
    }

    public String getPost_Content() {
        return Post_Content;
    }

    public String getPost_Owner() {
        return Post_Owner;
    }

    public String getPostSharers() {
        return PostSharers;
    }
}
