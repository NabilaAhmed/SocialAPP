package com.example.android.application.Objects;

public class Client {

    String ClientID;
    String ClientEmail;
    String Level_One;
    String Level_Two;
    String Level_Three;
    String balance;
//List<Post> posts;
    public String getClientID() {
        return ClientID;
    }

    public Client() {
    }

    public Client(String clientID, String clientEmail, String level_One, String level_Two, String level_Three, String balance) {
        ClientID = clientID;
        ClientEmail = clientEmail;
        Level_One = level_One;
        Level_Two = level_Two;
        Level_Three = level_Three;
        this.balance = balance;
//        this.posts = posts;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getClientEmail() {
        return ClientEmail;
    }

    public void setClientEmail(String clientEmail) {
        ClientEmail = clientEmail;
    }

    public String getLevel_One() {
        return Level_One;
    }

    public void setLevel_One(String level_One) {
        Level_One = level_One;
    }




//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }

    public String getLevel_Two() {
        return Level_Two;
    }

    public void setLevel_Two(String level_Two) {
        Level_Two = level_Two;
    }

    public String getLevel_Three() {
        return Level_Three;
    }

    public void setLevel_Three(String level_Three) {
        Level_Three = level_Three;
    }

    public String getbalance() {
        return balance;
    }

    public void setbalance(String balance) {
        balance = balance;
    }

}
