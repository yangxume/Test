package com.xy.recyclerview;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import java.util.List;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/8/14 17:13
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> data;
    private LayoutInflater inflater;
    private int mLastPosition = -1;
    private int mPosition = 0;
    private Interpolator mInterpolator = new LinearInterpolator();
    private int mDuration = 300;
    private AlphaAnimation mSelectAnimation = new AlphaAnimation();
    private boolean mOpenAnimationEnable = true;

    public MainAdapter(Context context,List<String> datas){

        this.data = datas;
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_layout,parent,false);
        BaseHolder b = new BaseHolder(itemView);
//        ViewHolderHelper holder = ViewHolderHelper.get(mContext, null, parent, R.layout.item_layout, -1);
        return b;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {

        holder.tv.setText(data.get(position));
        if(mOpenAnimationEnable) {
            addAnimation(holder);
        }
    }

    public void updatePosition(int position) {
        mPosition = position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * 添加动画
     * @param holder
     */
    public void addAnimation(RecyclerView.ViewHolder holder) {
        if (mOpenAnimationEnable) {
            if (holder.getLayoutPosition() > mLastPosition) {
                AlphaAnimation animation = null;
                if (mSelectAnimation != null) {
                    animation = mSelectAnimation;
                }
                for (Animator anim : animation.getAnimators(holder.itemView)) {
                    startAnim(anim);

                }
                mLastPosition = holder.getLayoutPosition();
            }
        }
    }

    /**
     * 开启动画
     * @param animator
     */
    private void startAnim(Animator animator) {
        animator.setDuration(mDuration).start();
        animator.setInterpolator(mInterpolator);
    }

    /**
     * 设置动画效果
     * @param animation
     */
    public void setAnimation(BaseAnimation animation){
        this.mOpenAnimationEnable = true;
        this.mSelectAnimation = animation;
    }

    static class BaseHolder extends RecyclerView.ViewHolder {

        private TextView tv;

        public BaseHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

}

