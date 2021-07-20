package com.hadi.healthinfo;

import android.os.Parcel;
import android.os.Parcelable;

public class Artikel implements Parcelable {
    private String Judul;
    private String Kategori;
    private String Tanggal;
    private String Isi;
    private String Gambar;

    public Artikel(String judul, String kategori, String tanggal, String isi, String gambar) {
        Judul = judul;
        Kategori = kategori;
        Tanggal = tanggal;
        Isi = isi;
        Gambar = gambar;
    }

    protected Artikel(Parcel in) {
        Judul = in.readString();
        Kategori = in.readString();
        Tanggal = in.readString();
        Isi = in.readString();
        Gambar = in.readString();
    }

    public static final Creator<Artikel> CREATOR = new Creator<Artikel>() {
        @Override
        public Artikel createFromParcel(Parcel in) {
            return new Artikel(in);
        }

        @Override
        public Artikel[] newArray(int size) {
            return new Artikel[size];
        }
    };

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getKategori() {
        return Kategori;
    }

    public void setKategori(String kategori) {
        Kategori = kategori;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getIsi() {
        return Isi;
    }

    public void setIsi(String isi) {
        Isi = isi;
    }

    public String getGambar() { return Gambar; }

    public void setGambar(String gambar) { Gambar = gambar; }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Judul);
        dest.writeString(Kategori);
        dest.writeString(Tanggal);
        dest.writeString(Isi);
        dest.writeString(Gambar);
    }
}
