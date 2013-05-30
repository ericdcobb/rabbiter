package com.cobb;

public class Send {
	public final static String QUEUE_NAME = "reach.order.123";
	public final static String HOST = "54.214.251.160";
	
	public static void main(String args[]) throws Exception{
	
		if (args[0].equals("--send")) {
			new Message(args[1]);
		} else if (args[0].equals("--listen")) {
			new Receiver().initialize();
		}
	}
}
