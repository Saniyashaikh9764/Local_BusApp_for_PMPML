package com.example.asus.mybus;

public class Users
{
String userid,usersbusid,userfare,noofseats,usrs,udest;

    public String getUserid() {
        return userid;
    }

    public String getUsersbusid() {
        return usersbusid;
    }

    public String getUserfare() {
        return userfare;
    }

    public String getNoofseats() {
        return noofseats;
    }

    public String getUsrs() {
        return usrs;
    }

    public String getUdest() {
        return udest;
    }

    public Users(String userid, String usersbusid, String userfare, String noofseats, String usrs, String udest) {
        this.userid = userid;
        this.usersbusid = usersbusid;
        this.userfare = userfare;
        this.noofseats = noofseats;

        this.usrs = usrs;
        this.udest = udest;
    }

    public Users() {
}
}
