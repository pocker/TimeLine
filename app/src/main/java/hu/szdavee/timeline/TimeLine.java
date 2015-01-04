package hu.szdavee.timeline;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2015.01.04..
 */
public class TimeLine extends LinearLayout implements Chronometer.OnChronometerTickListener {

    private float mWeightSum = 180;
    private long mUpdateTime;

    private List<DataContainer> mDataList;
    private List<DataContainer> mVisibleData;
    private Chronometer mChronometer;


    public TimeLine(Context context) {
        super(context);
        init();
    }

    public TimeLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimeLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){

        setOrientation(LinearLayout.VERTICAL);
        setWeightSum(mWeightSum);
        
        mVisibleData = new ArrayList<DataContainer>();
        mDataList = new ArrayList<DataContainer>();
        mChronometer = new Chronometer(getContext());
        mChronometer.setOnChronometerTickListener(this);

        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();

    }

    private void update(final long actualTime){

        this.removeAllViews();

        int position = -1;

        for(int i=0;i<mDataList.size();i++){
            if(mDataList.get(i).getmStartTime()<=actualTime && mDataList.get(i).getmEndTime()>=actualTime){
                position = i;
            }else if(mDataList.get(i).getmEndTime() <= actualTime-mWeightSum*60*1000*(1/3)){
                //remove old data
                mDataList.remove(i);
                i--;
            }
        }

        if(position == -1){
            //TODO no visible data add some text or something
            return;
        }



        invalidate();
    }

    @Override
    public void onChronometerTick(final Chronometer chronometer) {
       final long startTime = chronometer.getBase();
       final long actualTime = SystemClock.elapsedRealtime();

        if(actualTime-startTime>=mUpdateTime){
            chronometer.setBase(actualTime);

            update(actualTime);
        }
    }


}
