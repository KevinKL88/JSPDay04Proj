package com.lkl.entity;

public class Computer {
    private int cid;
    private String cBrand;
    private String cModel;
    private String cCpu;
    private String cGpu;

    public Computer() {
    }

    public Computer(int cid, String cBrand, String cModel, String cCpu, String cGpu) {
        this.cid = cid;
        this.cBrand = cBrand;
        this.cModel = cModel;
        this.cCpu = cCpu;
        this.cGpu = cGpu;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getcBrand() {
        return cBrand;
    }

    public void setcBrand(String cBrand) {
        this.cBrand = cBrand;
    }

    public String getcModel() {
        return cModel;
    }

    public void setcModel(String cModel) {
        this.cModel = cModel;
    }

    public String getcCpu() {
        return cCpu;
    }

    public void setcCpu(String cCpu) {
        this.cCpu = cCpu;
    }

    public String getcGpu() {
        return cGpu;
    }

    public void setcGpu(String cGpu) {
        this.cGpu = cGpu;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cid=" + cid +
                ", cBrand='" + cBrand + '\'' +
                ", cModel='" + cModel + '\'' +
                ", cCpu='" + cCpu + '\'' +
                ", cGpu='" + cGpu + '\'' +
                '}';
    }
}
