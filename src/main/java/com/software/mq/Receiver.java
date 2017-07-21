package com.software.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;





@RabbitListener(queues = "hello")
public class Receiver {

	private final int instance;
	public Receiver() {
		this.instance=1;
	}
	
	public Receiver(int instance) {
		super();
		this.instance = instance;
	}
	
	@RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public String receive1(String in) throws InterruptedException {
        return receive(in, 1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public String receive2(String in) throws InterruptedException {
		return receive(in, 2);
    }

//	@RabbitHandler
	public String receive(String in, int receiver) throws InterruptedException {
		  StopWatch watch = new StopWatch();
	        watch.start();
	        System.out.println("instance " + receiver + " [x] Received '" + in + "'");
	        doWork(in, receiver);
	        watch.stop();
	        System.out.println("instance " + receiver + " [x] Done in " 
	            + watch.getTotalTimeSeconds() + "s");
	        return   "instance " + receiver + " [x] Received '" + in + "' "+watch.getTotalTimeSeconds() + "s";
		
	}
	private void doWork(String in, int re) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000*re);
            }
        }
    }
}
