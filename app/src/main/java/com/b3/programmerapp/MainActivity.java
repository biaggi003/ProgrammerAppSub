package com.b3.programmerapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Programmer> list;
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("Mode List");
            list.addAll(ProgrammerData.getListData());
            showRecyclerList();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<? extends Programmer> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showSelectedProgrammer(Programmer programmer) {
        Intent intent = new Intent(MainActivity.this, DetailProgrammerActivity.class);
        intent.putExtra(DetailProgrammerActivity.EXTRA_NAME, programmer.getName());
        intent.putExtra(DetailProgrammerActivity.EXTRA_REMARKS, programmer.getRemarks());
        intent.putExtra(DetailProgrammerActivity.EXTRA_CONTENT, programmer.getContent());
        intent.putExtra(DetailProgrammerActivity.EXTRA_PHOTO, programmer.getPhoto());
        intent.putExtra(DetailProgrammerActivity.EXTRA_LAHIR, programmer.getLahir());
        intent.putExtra(DetailProgrammerActivity.EXTRA_WAFAT, programmer.getWafat());
        intent.putExtra(DetailProgrammerActivity.EXTRA_PENDIDIKAN, programmer.getPendidikan());
        startActivity(intent);
        Toast.makeText(this, "Kamu memilih " + programmer.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListProgrammerAdapter listProgrammerAdapter = new ListProgrammerAdapter(this);
        listProgrammerAdapter.setListProgrammer(list);
        rvCategory.setAdapter(listProgrammerAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedProgrammer(list.get(position));
            }
        });
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridProgrammerAdapter gridProgrammerAdapter = new GridProgrammerAdapter(this);
        gridProgrammerAdapter.setListProgrammer(list);
        rvCategory.setAdapter(gridProgrammerAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedProgrammer(list.get(position));
            }
        });
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewProgrammerAdapter cardViewProgrammerAdapter = new CardViewProgrammerAdapter(this);
        cardViewProgrammerAdapter.setListProgrammer(list);
        rvCategory.setAdapter(cardViewProgrammerAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedProgrammer(list.get(position));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, new ArrayList<Parcelable>());
        outState.putInt(STATE_MODE, mode);
    }
}
