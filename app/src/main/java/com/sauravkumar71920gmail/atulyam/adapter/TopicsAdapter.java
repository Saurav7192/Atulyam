package com.sauravkumar71920gmail.atulyam.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.sauravkumar71920gmail.atulyam.R;

import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by Saurav on 06-03-2018.
 */

public class TopicsAdapter  extends RecyclerView.Adapter<TopicsAdapter.TopicCustomViewHolder>{

    Context mContext;
    ArrayList<String> mArraylist;
    ArrayList<GradientDrawable> mGradientDrawables;



    FirebaseDatabase mFirebaseDatabase;
    FirebaseUser mFirebaseUser;
    FirebaseAuth mFirebaseAuth;

   // public  String topicKey = new String();

    public TopicsAdapter(Context context, ArrayList<String> arrayList){
        mArraylist = arrayList;
        mContext = context;
        mGradientDrawables = new ArrayList<>();

        fillGradientList(mContext);

    }


    @Override
    public TopicCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_item_list_view, parent, false);

        return new TopicCustomViewHolder(view);
    }

    private void fillGradientList(Context context){
        mGradientDrawables.add(getTempGradientDrawable(ContextCompat.getColor(context, R.color.gradient_1_start), ContextCompat.getColor(context, R.color.gradient_1_end)));
        mGradientDrawables.add(getTempGradientDrawable(ContextCompat.getColor(context, R.color.gradient_2_start), ContextCompat.getColor(context, R.color.gradient_2_end)));
        mGradientDrawables.add(getTempGradientDrawable(ContextCompat.getColor(context, R.color.gradient_3_start), ContextCompat.getColor(context, R.color.gradient_3_end)));
        mGradientDrawables.add(getTempGradientDrawable(ContextCompat.getColor(context, R.color.gradient_4_start), ContextCompat.getColor(context, R.color.gradient_4_end)));


    }
    public void addTopic(String topic){
        mArraylist.add(topic);
    }


    private GradientDrawable getTempGradientDrawable(int startColor, int endColor) {

        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[]{startColor, endColor});
        drawable.setDither(true);
        drawable.setGradientCenter(drawable.getIntrinsicWidth() / 8, drawable.getIntrinsicHeight() / 2);
        drawable.setCornerRadius(20);
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        drawable.setUseLevel(true);
        return drawable;

    }

    @Override
    public void onBindViewHolder(final TopicCustomViewHolder holder, int position) {

        final String topicName = mArraylist.get(position);
        holder.mTextView.setText(topicName);


        holder.mTopicRelativeLayout.setBackground(mGradientDrawables.get(position%4));

        holder.mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String Sk = new String("Saurav");

                mFirebaseAuth = FirebaseAuth.getInstance();
                mFirebaseUser = mFirebaseAuth.getCurrentUser();

                  //function2();

                Toast.makeText(mContext, "Registered, No need to register again", Toast.LENGTH_SHORT).show();

               mFirebaseDatabase = FirebaseDatabase.getInstance();
               mFirebaseDatabase.getReference("Events").child(topicName).push().setValue(mFirebaseUser);
               holder.mRegisterButton.setText("Registered");

            }

            /*private void function2() {
                SpannableString Sam = data_to_be_uploaded;

                Toast.makeText(mContext,Sam,Toast.LENGTH_SHORT).show();

            }*/
        });


    }




    @Override
    public int getItemCount() {
        return mArraylist.size();
    }

    class TopicCustomViewHolder extends RecyclerView.ViewHolder{


        public AppCompatButton mRegisterButton;

        private TextView mTextView;
        private LinearLayout mTopicRelativeLayout;

        public TopicCustomViewHolder(View itemView){
            super(itemView);

            mTextView = (TextView)itemView.findViewById(R.id.topicTextView);


            mTopicRelativeLayout = (LinearLayout) itemView.findViewById(R.id.topicViewRelativeLayout);

            mRegisterButton = (AppCompatButton) itemView.findViewById(R.id.registerButton);



        }
    }

}
