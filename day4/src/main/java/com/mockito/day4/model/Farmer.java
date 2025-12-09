package com.mockito.day4.model;

public class Farmer {

    private Long id;
    private String name;
    private int n;
    private int p;
    private int k;

    public Farmer(Long id, String name, int n, int p, int k) {
        this.id = id;
        this.name = name;
        this.n = n;
        this.p = p;
        this.k = k;
    }
    public Farmer() {
    }
    
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getN() {
        return n;
    }
    public int getP() {
        return p;
    }
    public int getK() {
        return k;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setN(int n) {
        this.n = n;
    }
    public void setP(int p) {
        this.p = p;
    }
    public void setK(int k) {
        this.k = k;
    }

    // tostring
    @Override
    public String toString() {
        return "Farmer [id=" + id + ", name=" + name + ", n=" + n + ", p=" + p + ", k=" + k + "]";
    }
}