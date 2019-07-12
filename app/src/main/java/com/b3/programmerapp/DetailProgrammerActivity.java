package com.b3.programmerapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailProgrammerActivity extends AppCompatActivity {

    public final static String EXTRA_NAME = "extra_name";
    public final static String EXTRA_REMARKS = "extra_remarks";
    public final static String EXTRA_PHOTO = "extra_photo";
    public final static String EXTRA_CONTENT = "extra_content";
    public final static String EXTRA_LAHIR = "extra_lahir";
    public final static String EXTRA_WAFAT = "extra_wafat";
    public final static String EXTRA_PENDIDIKAN = "extra_pendidikan";

    TextView NameDetail, RemarksDetail, ContentDetail, LahirDetail, WafatDetail, PendidikanDetail;
    ImageView imgPhotoDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_programmer);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getIntent().getStringExtra(EXTRA_NAME));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        NameDetail = findViewById(R.id.tv_item_name);
        RemarksDetail = findViewById(R.id.tv_item_remarks);
        imgPhotoDetail = findViewById(R.id.img_item_photo);
        ContentDetail = findViewById(R.id.tv_item_content);
        LahirDetail = findViewById(R.id.tv_item_lahir);
        WafatDetail = findViewById(R.id.tv_item_wafat);
        PendidikanDetail = findViewById(R.id.tv_item_pendidikan);

        String Data1,Data2,Data3,Data4,Data5,Data6,Data7;
        Intent intent = getIntent();

        Data1 = intent.getStringExtra(EXTRA_NAME);
        Data2 = intent.getStringExtra(EXTRA_REMARKS);
        Data3 = intent.getStringExtra(EXTRA_CONTENT);
        Data4 = intent.getStringExtra(EXTRA_PHOTO);
        Data5 = intent.getStringExtra(EXTRA_LAHIR);
        Data6 = intent.getStringExtra(EXTRA_WAFAT);
        Data7 = intent.getStringExtra(EXTRA_PENDIDIKAN);

        NameDetail.setText(Data1);
        RemarksDetail.setText(Data2);
        ContentDetail.setText(Data3);
        Glide.with(this)
                .load(Data4)
                .into(imgPhotoDetail);
        LahirDetail.setText(Data5);
        WafatDetail.setText(Data6);
        PendidikanDetail.setText(Data7);
    }
}