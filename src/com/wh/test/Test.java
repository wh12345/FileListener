package com.wh.test;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import com.wh.listener.MyFileListener;

public class Test {
		public static void main(String[] args) throws Exception {
			String rootDir = "G:\\video\\videoDB\\temp";
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
			monitor.start();
		}
}
