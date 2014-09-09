package com.dvd.eclipse.adb.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;

import com.dvd.eclipse.adb.instance.Commands;

public class Kill extends AbstractHandler {

	public String outputCmd;

	public Kill() {
	}

	public Object execute(ExecutionEvent event) {

		Commands.adbComm("kill-server");
		return null;

	}
}