package com.example.sanyam.recylerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RCVAdapter.BatchListInterface {

    RecyclerView recyclerView;
    RCVAdapter adapter;
    ArrayList<Batch> batches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        batches = new ArrayList<>();
        batches.add(new Batch("JAVA", 40));
        batches.add(new Batch("CPP", 40));
        batches.add(new Batch("Android", 40));
        batches.add(new Batch("RUBYonRAILS", 40));
        batches.add(new Batch("IPC", 40));
        batches.add(new Batch("JAVA", 40));
        batches.add(new Batch("CPP", 40));
        batches.add(new Batch("Android", 40));
        batches.add(new Batch("RUBYonRAILS", 40));
        batches.add(new Batch("IPC", 40));
        batches.add(new Batch("JAVA", 40));
        batches.add(new Batch("CPP", 40));
        batches.add(new Batch("Android", 40));
        batches.add(new Batch("RUBYonRAILS", 40));
        batches.add(new Batch("IPC", 40));
        batches.add(new Batch("JAVA", 40));
        batches.add(new Batch("CPP", 40));
        batches.add(new Batch("Android", 40));
        batches.add(new Batch("RUBYonRAILS", 40));
        batches.add(new Batch("IPC", 40));

        adapter = new RCVAdapter(this,batches, this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN ,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT){

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int i = viewHolder.getAdapterPosition();
                int j = target.getAdapterPosition();
                Batch first = batches.get(i);
                Batch second = batches.get(j);
                batches.set(i,second);
                batches.set(j,first);
                adapter.notifyItemMoved(j,i);
                return true;
                //return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                batches.remove(position);
                adapter.notifyItemRemoved(position);

            }
        };

        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);


    }

    @Override
    public void batchClicked(Batch b) {
        int i = batches.indexOf(b);
        batches.remove(b);
        //adapter.notifyDataSetChanged();
        adapter.notifyItemRemoved(i);
    }
}
