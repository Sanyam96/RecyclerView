package com.example.sanyam.recylerview;

import android.content.Context;
import android.net.sip.SipAudioCall;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by sanyam on 22/7/16.
 */

public class RCVAdapter extends RecyclerView.Adapter<RCVAdapter.OurHolder> {

    public class OurHolder extends RecyclerView.ViewHolder{

        TextView tv1;
        TextView tv2;
        Button b;

        public OurHolder(View itemView) {
            super(itemView);
            tv1 = (TextView)itemView.findViewById(R.id.batchName);
            tv2 = (TextView)itemView.findViewById(R.id.batchStrength);
            b = (Button)itemView.findViewById(R.id.button);
        }
    }

    Context mContext;
    ArrayList<Batch> batches;
    BatchListInterface listener;

    public interface BatchListInterface{
        void batchClicked(Batch b);
    }

    public RCVAdapter(Context context, ArrayList<Batch> batches, BatchListInterface m) {
        mContext = context;
        this.batches = batches;

        listener = m;
    }

    @Override
    public OurHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_item, parent, false);
        return new OurHolder(v);
        //return null;
    }

    @Override
    public void onBindViewHolder(OurHolder holder, final int position) {
        final Batch b = batches.get(position);
        holder.tv1.setText(b.name);
        holder.tv2.setText(b.strength + "");
        //final Batch b1 = batches.get(position);
        holder.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              done by holder
//              but we want to do it by activity
//                                                                  do with listener!!!!!
//                batches.remove(position);
//                RCVAdapter.this.notifyDataSetChanged();

                //listener.batchClicked(batches.get(position));
                listener.batchClicked(b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return batches.size();
        //return 0;
    }
}
