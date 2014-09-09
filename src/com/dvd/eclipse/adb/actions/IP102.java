package com.dvd.eclipse.adb.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;

import com.dvd.eclipse.adb.instance.Commands;

public class IP102 extends AbstractHandler {

	public IP102() {
	}

	public Object execute(ExecutionEvent event) {

		Commands.adbComm("connect 192.168.1.102:5555");
		return null;
	}
}