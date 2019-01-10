package com.xy.recyclerview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private static final String TAG = MainAdapter.class.getSimpleName();

    private Context mContext;
    private List<StudentBean> mDatas;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public MainAdapter(Context context, List<StudentBean> mDatas) {
        this.mContext = context;
        this.mDatas = mDatas;
    }

    public List<StudentBean> getDataList(){
        return mDatas;
    }

    /**
     * 增加数据
     */
    public void addData(int position) {
        mDatas.add(position, new StudentBean("aaa",0));
        notifyItemInserted(position);//注意这里
    }

    /**
     * 移除数据
     */
    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);//注意这里
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v);
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClickListener.onItemLongClick(v);
                return true;
            }
        });

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_stu_name.setText(mDatas.get(position).name);
        holder.itemView.setTag(position);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position, List<Object> payloads) {

        if (payloads.isEmpty()){
            onBindViewHolder(holder,position);
        }else {

            String payload = (String) payloads.get(0);
            Log.d(TAG, "onBindViewHolder: payload = "+payload);

            if(payload.equals("raise_hand")){

                StudentBean studentBean = mDatas.get(position);
                MyViewHolder viewHolder = holder;

                holder.iv_state.setImageResource(R.drawable.classroom_raise_hand_animlist);
                final AnimationDrawable animationDrawable = (AnimationDrawable) holder.iv_state.getDrawable();
                animationDrawable.start();

                Runnable raiseHandRunnable = new Runnable() {
                    @Override
                    public void run() {

                        DataManager.getDataManager().setSpeakState(0);

                        if (animationDrawable != null){
                            if (animationDrawable.isRunning()){
                                animationDrawable.stop();
                            }
                        }
                        holder.iv_state.setImageResource(R.mipmap.speak_and_write);
                        DataManager.getDataManager().getmHandler().removeCallbacks(this);

                    }
                };

                DataManager.getDataManager().getRunnableMap().put(position+"",raiseHandRunnable);
                DataManager.getDataManager().getmHandler().postDelayed(raiseHandRunnable,8000);


            }else if(payload.equals("audio")){

                StudentBean studentBean = mDatas.get(position);
                MyViewHolder viewHolder = holder;

                holder.iv_state.setImageResource(R.mipmap.classroom_live_audio_connecting);
                final Animation mAudioConnectingAnimation = AnimationUtils.loadAnimation(mContext, R.anim.classroom_livelesson_view_animation_rotate);
                holder.iv_state.startAnimation(mAudioConnectingAnimation);

                final Runnable audioRunnable = new Runnable() {
                    @Override
                    public void run() {

                        DataManager.getDataManager().setSpeakState(0);

                        if (mAudioConnectingAnimation != null){
                                mAudioConnectingAnimation.cancel();
                        }
                        holder.iv_state.setImageResource(R.mipmap.speak_and_write);
                        DataManager.getDataManager().getmHandler().removeCallbacks(this);
                    }
                };

                DataManager.getDataManager().getRunnableMap().put(position+"",audioRunnable);
                DataManager.getDataManager().getmHandler().postDelayed(audioRunnable,5000);
            }
        }


    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_stu_name;
        ImageView iv_state;

        public MyViewHolder(View view) {
            super(view);
            tv_stu_name = (TextView) itemView.findViewById(R.id.tv_stu_name);
            iv_state = (ImageView) itemView.findViewById(R.id.iv_state);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view);

        void onItemLongClick(View view);
    }
}

