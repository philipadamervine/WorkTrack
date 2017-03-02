package com.app.worktracker.worktracker;

/**
 * Created by Philip on 27/02/2017.
 */

public class Employee {
    int id;
    String name, sname, email, job, tel, start, finish, rate, pass;

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setSName(String sname){
        this.sname = sname;
    }
    public String getSName(){
        return this.sname;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setJob(String job){
        this.job = job;
    }
    public String getJob(){
        return this.job;
    }

    public void setTel(String tel){
        this.tel = tel;
    }
    public String getTel(){
        return this.tel;
    }

    public void setStart(String start){
        this.start = start;
    }
    public String getStart(){
        return this.start;
    }

    public void setFinish(String finish){
        this.finish = finish;
    }
    public String getFinish(){
        return this.finish;
    }

    public void setRate(String rate){
        this.rate = rate;
    }
    public String getRate(){
        return this.rate;
    }

    public void setPass(String pass){
        this.pass = pass;
    }
    public String getPass(){
        return this.pass;
    }
}
