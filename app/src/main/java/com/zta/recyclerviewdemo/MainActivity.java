package com.zta.recyclerviewdemo;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.zta.recyclerviewdemo.Fragments.AddNewNameDialogFragment;
import com.zta.recyclerviewdemo.Model.NameItem;
import com.zta.recyclerviewdemo.RecyclerviewAdapter.NamesRecyclerviewAdapter;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements AddNewNameDialogFragment.OnNewNameAddedListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.rv_names_list)
    RecyclerView namesRecyclerView;


    private NamesRecyclerviewAdapter namesRecyclerviewAdapter;
    private LinearLayoutManager recyclerViewLayoutManager;
    private AddNewNameDialogFragment addNewNameDialogFragment;

    private ArrayList<NameItem> nameItemArrayList;



    @OnClick(R.id.fab)
    public void onFloatingButtonClick(){
        addNewNameDialogFragment= AddNewNameDialogFragment.newInstance();
        FragmentManager fragmentManager= getFragmentManager();
        addNewNameDialogFragment.show(fragmentManager, AddNewNameDialogFragment.ADD_NEW_NAME_DIALOG_FRAGMENT_TAG);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        //add data in nameItemArrayList
        addDummyDataInList();
        // display data  in recyclerView
        populateRecyclerView();

    }


    /**
     * displays data in RecyclerView
     */
    private void populateRecyclerView(){
        namesRecyclerviewAdapter= new NamesRecyclerviewAdapter(MainActivity.this, nameItemArrayList);
        recyclerViewLayoutManager = new LinearLayoutManager(MainActivity.this);

        namesRecyclerView.setLayoutManager(recyclerViewLayoutManager);
        namesRecyclerView.setAdapter(namesRecyclerviewAdapter);

    }


    /**
     * Adds dummy data in @link nameItemArrayList
     */
    private void addDummyDataInList(){

        if (nameItemArrayList== null || nameItemArrayList.size()<=0){
            nameItemArrayList= new ArrayList<NameItem>();
        }

        NameItem nameItemObj= new NameItem("Chirs", "Kam");
        nameItemArrayList.add(nameItemObj);

        nameItemObj= new NameItem("Mickle", "Jordan");
        nameItemArrayList.add(nameItemObj);

        nameItemObj= new NameItem("Harvey", "Spector");
        nameItemArrayList.add(nameItemObj);

        nameItemObj= new NameItem("Victor", "Martin");
        nameItemArrayList.add(nameItemObj);

        nameItemObj= new NameItem("Mark", "Wah");
        nameItemArrayList.add(nameItemObj);

        nameItemObj= new NameItem("James", "Smith");
        nameItemArrayList.add(nameItemObj);
    }


    @Override
    public void onNewNameAddition(NameItem newNameItem) {

        if (nameItemArrayList== null || nameItemArrayList.size()<=0){
            nameItemArrayList= new ArrayList<NameItem>();
        }
        nameItemArrayList.add(newNameItem);

        namesRecyclerviewAdapter.notifyDataSetChanged();
        namesRecyclerView.scrollToPosition(nameItemArrayList.size()-1);
    }
}
