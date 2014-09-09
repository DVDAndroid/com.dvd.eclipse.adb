package com.dvd.eclipse.adb.instance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class Commands {

	public static void adbComm(String arg) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(Runtime.getRuntime()
					.exec("adb " + arg).getInputStream()));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String strLine;
		String text = "";

		// Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				text = text + strLine + "\n";
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Close the input stream
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MessageConsole myConsole = findConsole("ADB");
		MessageConsoleStream out = myConsole.newMessageStream();

		if (arg.contains("connect")) {
			if (text.contains("unable") || text.contains("batch")) {
				out.setColor(new Color(null, 255, 0, 0));
			} else {
				if (text.contains("already")) {
					out.setColor(new Color(null, 255, 255, 0));
				}
			}
		} else {

			if (text.contains("not")) {
				out.setColor(new Color(null, 255, 0, 0));
			} else {
				if (text.contains("already")) {
					out.setColor(new Color(null, 255, 255, 0));
				}
			}
		}

		out.setActivateOnWrite(true);
		if (arg.equals("kill-server")) {
			if (text.equals("")) {
				out.println("Server killed\n");
			}
		}
		if (!text.equals(""))
			out.println(text);

	}

	public static MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

}
