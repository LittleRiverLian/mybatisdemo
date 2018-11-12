package com.ljs.etl.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("ScheduleService")
public class ScheduleService {

//    @Scheduled(cron = "0/5 * * * * ?")
    public void schTest1() {
        Date date = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sim.format(date);
        System.out.println("这是spring定时器1，每五秒执行一次,当前时间：" + dateStr);
    }
}