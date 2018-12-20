package com.example.asus.mybus;

public class Blog {
    private String noofseats;
    private String udest;
    private String userfare;
    private String userid;
    private String userbusid;
    private String usrs;

    public Blog(String noofseats, String udest, String userfare, String userid, String userbusid, String usrs) {
        this.noofseats = noofseats;
        this.udest = udest;
        this.userfare = userfare;
        this.userid = userid;
        this.userbusid = userbusid;
        this.usrs = usrs;
    }

    public String getNoofseats() {
        return noofseats;
    }

    public void setNoofseats(String noofseats) {
        this.noofseats = noofseats;
    }

    public String getUdest() {
        return udest;
    }

    public void setUdest(String udest) {
        this.udest = udest;
    }

    public String getUserfare() {
        return userfare;
    }

    public void setUserfare(String userfare) {
        this.userfare = userfare;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserbusid() {
        return userbusid;
    }

    public void setUserbusid(String userbusid) {
        this.userbusid = userbusid;
    }

    public String getUsrs() {
        return usrs;
    }

    public void setUsrs(String usrs) {
        this.usrs = usrs;
    }
    public Blog()
    {

    }
}
