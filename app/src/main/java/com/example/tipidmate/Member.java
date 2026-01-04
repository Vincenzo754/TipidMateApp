package com.example.tipidmate;

public class Member {

    private String name;
    private String avatarText;

    public Member(String name, String avatarText) {
        this.name = name;
        this.avatarText = avatarText;
    }

    public String getName() {
        return name;
    }

    public String getAvatarText() {
        return avatarText;
    }
}
