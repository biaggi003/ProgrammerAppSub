package com.b3.programmerapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Programmer extends AppCompatActivity {
    public String name, remarks, content ,photo, lahir, wafat, pendidikan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getWafat() {
        return wafat;
    }

    public void setWafat(String wafat) {
        this.wafat = wafat;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.content);
        dest.writeString(this.photo);
        dest.writeString(this.lahir);
        dest.writeString(this.wafat);
        dest.writeString(this.pendidikan);
    }

    public Programmer() {
    }
    protected Programmer(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.content = in.readString();
        this.photo = in.readString();
        this.lahir = in.readString();
        this.wafat = in.readString();
        this.pendidikan = in.readString();
    }
    public static final Parcelable.Creator<Programmer> CREATOR = new Parcelable.Creator<Programmer>() {
        @Override
        public Programmer createFromParcel(Parcel source) {
            return new Programmer(source);
        }
        @Override
        public Programmer[] newArray(int size) {
            return new Programmer[size];
        }
    };
}

