package com.lkl.entity;

public class Phone {
    private int pid;
    private String pbrand;
    private String pmodel;
    private double psize;
    private double pprice;

    public Phone() {
    }

    public Phone(int pid, String pbrand, String pmodel, double psize, double pprice) {
        this.pid = pid;
        this.pbrand = pbrand;
        this.pmodel = pmodel;
        this.psize = psize;
        this.pprice = pprice;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPbrand() {
        return pbrand;
    }

    public void setPbrand(String pbrand) {
        this.pbrand = pbrand;
    }

    public String getPmodel() {
        return pmodel;
    }

    public void setPmodel(String pmodel) {
        this.pmodel = pmodel;
    }

    public double getPsize() {
        return psize;
    }

    public void setPsize(double psize) {
        this.psize = psize;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "pid=" + pid +
                ", pbrand='" + pbrand + '\'' +
                ", pmodel='" + pmodel + '\'' +
                ", psize=" + psize +
                ", pprice=" + pprice +
                '}';
    }
}
