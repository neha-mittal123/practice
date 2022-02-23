package com.factoryDesignPattern;

public class NotificationFactory {

	static Notification  createChannel(String s){
		if(s==null || s.isEmpty())
			return null;
		if(s.equalsIgnoreCase("sms"))
			return new SMSNotificationImpl();
		else if(s.equalsIgnoreCase("push"))
			return new PushNotificationImpl();
		return null;
	}
}
