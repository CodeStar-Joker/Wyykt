package com.zjx.wyykt;


import android.os.Handler;

public class CustomCountDownTimer implements Runnable{

    //1.实时回调 这个时候是什么时间 倒计时到几秒 观察者设计模式
    //2.支持动态传入总时间
    //3.每过去一秒 总的时间减去1
    //4.总时间倒计时为0的时候 要回调完成的状态
    private int time;//总秒数
    private int countDownTime; //当前秒数
    private final ICountDownHandler countDownHandler;//自定义逻辑接口
    private final Handler handler;//异步处理
    private boolean isRun;//开关
    public CustomCountDownTimer(int time,ICountDownHandler countDownHandler){
        handler = new Handler();
        this.time = time;
        this.countDownTime = time;
        this.countDownHandler = countDownHandler;
    }
    //观察者回调接口 也叫ioc数据回调
    //具体实现的逻辑
    @Override
    public void run() {
        if(isRun){
            if(countDownHandler != null){
                countDownHandler.onTicker(countDownTime);
            }
            if (countDownTime == 0){
                cancel();
                if(countDownHandler != null){
                    countDownHandler.onFinish();
                }
            }else{
                countDownTime = time --;
                handler.postDelayed(this,1000);
            }
        }
    }

    public void start(){//开始
        isRun = true;
        handler.post(this);//调用run方法
    }
    public void cancel(){//结束
        isRun = false;
        handler.removeCallbacks(this);
    }

    interface ICountDownHandler{
        void onTicker(int time);//数据回调
        void onFinish();//完成回调
    }

}
