package org.example;

public class Member {
    String _name;
    public String getname() {
        return _name;}
    String _password;
    public String getpassword() {
        return _password;}
    String _email;
    public String getemail() {
        return _email;}
    public Member( String name , String password , String email){
        _name = name;
        _password = password;
        _email = email;
    }
}
