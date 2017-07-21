package com.software.mq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;





public class Sender {
	
	@Autowired
	private  RabbitTemplate template;
//	@Autowired
//    private Queue queue;
	
	@Autowired
    private FanoutExchange fanout;
	
	@Autowired
    private DirectExchange direct;
	
	@Autowired
    private TopicExchange topic;
//	int dots = 0;
//    int count = 0;
//	
//	@Scheduled(fixedDelay = 1000, initialDelay = 500)
//	public void send() {
//		 StringBuilder builder = new StringBuilder("Hello");
//	        if (dots++ == 3) {
//	            dots = 1;
//	        }
//	       for (int i = 0; i < dots; i++) {
//	            builder.append('.');
//	        }
//
//	        builder.append(Integer.toString(++count));
//	        String message = builder.toString();
//        this.template.convertAndSend(fanout.getName(),"", message);
//        System.out.println(" [x] Sent '" + message + "'");
//		
//	}
	
	private int index;

    private int count;

    private final String[] keys0 = {"orange", "black", "green"};
    private final String[] keys = {"quick.orange.rabbit", 
            "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox"};


    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
    	StringBuilder builder = new StringBuilder("Hello to ");
        if (++this.index == keys.length) {
            this.index = 0;
        }
        String key = keys[this.index];
    	try {
    		 
    	        builder.append(key).append(' ');
    	        builder.append(Integer.toString(++this.count));
    	        String message = builder.toString();
    	        String ret = (String) template.convertSendAndReceive(topic.getName(), key,this.count);
    	        System.out.println(" [x] Sent '" + message + "'  "+ret);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(topic.getName()+" "+  key);
		}
       

    }

}
