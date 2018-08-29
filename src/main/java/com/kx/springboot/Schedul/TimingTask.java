package com.kx.springboot.Schedul;

import org.springframework.stereotype.Component;

@Component
public class TimingTask {

//    @Scheduled(cron = "0 0/1 * * * ?") //第一个定时任务：每隔一分钟访问数据库
//    public void timeTask() throws IOException {  //这里的方法只能是void并且没有参数
//            String is = "";
//            String[] timing = is.split(":");
//            Calendar calendar = Calendar.getInstance();
//            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timing[0])); // 控制时
//            calendar.set(Calendar.MINUTE, Integer.parseInt(timing[1]));       // 控制分
//            calendar.set(Calendar.SECOND, Integer.parseInt(timing[2]));       // 控制秒
//            Date time = calendar.getTime();
//            Date now= new Date();
//            if (now.after(time)) {
//                //第二个定时任务：根据用户设置的时间，来执行任务
//                final Timer timer = new Timer();
//                timer.scheduleAtFixedRate(new TimerTask() {
//                    public void run() {
//                        //需要执行的任务代码
//                        timer.cancel();//任务执行一次之后销毁
//                    }
//
//                }, time, 24 * 60 * 60 * 1000);// 这里设定将延时每天固定执行
//            }
//    }
}

