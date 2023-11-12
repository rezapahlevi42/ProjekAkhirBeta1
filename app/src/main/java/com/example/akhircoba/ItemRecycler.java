package com.example.akhircoba;

public class ItemRecycler {
    private String key, judul, isi;

    public ItemRecycler(String key, String judul, String isi){
        this.key = key;
        this.judul = judul;
        this.isi = isi;
    }

    public ItemRecycler() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
