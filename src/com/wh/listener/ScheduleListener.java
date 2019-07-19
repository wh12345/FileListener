package com.wh.listener;

import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class ScheduleListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		String rootDir = "G:\\video\\videoDB";
		// 轮询间隔 5 秒  
        long interval = TimeUnit.SECONDS.toMillis(3); 
        FileAlterationObserver observer = new FileAlterationObserver(  
                rootDir,   
                FileFilterUtils.and(  
                FileFilterUtils.fileFileFilter(),  
                FileFilterUtils.suffixFileFilter(".mp4")),   
                null);  
		observer.addListener(new MyFileListener());  
		FileAlterationMonitor monitor = new FileAlterationMonitor(interval,observer);  
		// 开始监控  
		try {
			monitor.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
