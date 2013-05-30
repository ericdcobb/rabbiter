package com.cobb;

public class Send {
	public final static String QUEUE_NAME = "test";
	public final static String HOST = "localhost";
	
	public static void main(String args[]) throws Exception{
	
		if (args[0].equals("--send")) {
			new Message(args[1]);
		} else if (args[0].equals("--listen")) {
			new Receiver().initialize();
		}
	}
}
