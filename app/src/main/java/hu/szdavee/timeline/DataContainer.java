package hu.szdavee.timeline;

/**
 * Created by david on 2015.01.04..
 */
public class DataContainer {

    private long mStartTime;
    private long mEndTime;
    private long mName;

    public DataContainer(long mStartTime, long mEndTime, long mName) {
        this.mStartTime = mStartTime;
        this.mEndTime = mEndTime;
        this.mName = mName;
    }

    public long getmStartTime() {
        return mStartTime;
    }

    public void setmStartTime(long mStartTime) {
        this.mStartTime = mStartTime;
    }

    public long getmEndTime() {
        return mEndTime;
    }

    public void setmEndTime(long mEndTime) {
        this.mEndTime = mEndTime;
    }

    public long getmName() {
        return mName;
    }

    public void setmName(long mName) {
        this.mName = mName;
    }
}
