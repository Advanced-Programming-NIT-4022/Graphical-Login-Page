package org.example;

import java.util.ArrayList;

public class Memberarray {
    static ArrayList<Member> members = new ArrayList<>();
    public void addMyMember(String name,String number ,String email){
        Member  member= new Member(name,number,email);
        members.add(member);
    }

}
