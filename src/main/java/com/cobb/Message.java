package com.cobb;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Message {
	
	public Message(String message) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(Send.HOST);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(Send.QUEUE_NAME, true, false, false, null);
		channel.basicPublish("", Send.QUEUE_NAME, null, message.getBytes());
		
		channel.close();
		connection.close();
	}

}
