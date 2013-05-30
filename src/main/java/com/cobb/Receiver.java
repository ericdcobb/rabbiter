package com.cobb;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Receiver {
	public void initialize() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(Send.HOST);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(Send.QUEUE_NAME, true, false, false, null);
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(Send.QUEUE_NAME, true, consumer);
		
		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println("Got message: "+message);
		}
		
	}
}
