package com.example.asus.mybus;

public class getset {
    private String src,dest;

    public getset(String final_src, String final_dest) {
        this.src=final_src;
        this.dest=final_dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }



}
