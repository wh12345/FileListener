package com.wh.listener;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

public class MyFileListener extends FileAlterationListenerAdaptor{

	@Override
	public void onFileCreate(File file) {
		System.out.println(file.getName());
	}

}
