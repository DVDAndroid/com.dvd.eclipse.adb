package com.dvd.eclipse.adb.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;

import com.dvd.eclipse.adb.instance.Commands;

public class IPtab extends AbstractHandler {

	public IPtab() {
	}

	public Object execute(ExecutionEvent event) {

		Commands.adbComm("connect 192.168.107.132:5555");
		return null;
	}
}