package com.software.config;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.software.mq.Receiver;
import com.software.mq.Sender;

@Profile({ "tut1", "hello-world" })
@Configuration
public class AppConfig {

	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("tut.fanout");
	}

	// permet de faire le routage selon la liaison prè-définie
	@Bean
	public DirectExchange direct() {
		return new DirectExchange("tut.direct");
	}

	@Bean
	public TopicExchange topic() {
		return new TopicExchange("tut.topic");
	}

	// @Bean
	// public Queue hello() {
	// return new Queue("hello");
	// }

	@Profile("receiver")

	private static class ReceiverConfig {

		@Bean
		public Queue autoDeleteQueue1() {
			return  QueueBuilder.nonDurable("foo")
			        .autoDelete()
			        .exclusive()
			        .withArgument("foo", "bar")
			        .build();
		}

		@Bean
		public Queue autoDeleteQueue2() {
			return new AnonymousQueue();
		}

		// liaison avec exchange fanout
		// @Bean
		// public Binding binding1(FanoutExchange fanout, Queue
		// autoDeleteQueue1) {
		// return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
		// }
		//
		// @Bean
		// public Binding binding2(FanoutExchange fanout, Queue
		// autoDeleteQueue2) {
		// return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
		// }
		// liaison avec exchange direct
//		@Bean
//		public Binding binding1a(DirectExchange direct, Queue autoDeleteQueue1) {
//
//			return BindingBuilder.bind(autoDeleteQueue1).to(direct).with("orange");
//		}
//
//		@Bean
//		public Binding binding1b(DirectExchange direct, Queue autoDeleteQueue1) {
//
//			return BindingBuilder.bind(autoDeleteQueue1).to(direct).with("black");
//		}
//
//		@Bean
//		public Binding binding2a(DirectExchange direct, Queue autoDeleteQueue2) {
//			return BindingBuilder.bind(autoDeleteQueue2).to(direct).with("green");
//		}
//
//		@Bean
//		public Binding binding2b(DirectExchange direct, Queue autoDeleteQueue2) {
//			return BindingBuilder.bind(autoDeleteQueue2).to(direct).with("black");
//		}
		
		//liaison avec exchange topic
		
		@Bean
        public Binding binding1a(TopicExchange topic, 
            Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1)
                .to(topic)
                .with("*.orange.*");
        }

        @Bean
        public Binding binding1b(TopicExchange topic, 
            Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2)
                .to(topic)
                .with("*.*.rabbit");
        }

        @Bean
        public Binding binding2a(TopicExchange topic, 
            Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2)
                .to(topic)
                .with("lazy.#");
        }

		@Bean
		public Receiver receiver() {
			return new Receiver(1);
		}

		// @Bean
		// public Receiver receiver2() {
		// return new Receiver(2);
		// }

	}

	@Profile("sender")
	@Bean
	public Sender sender() {
		return new Sender();
	}

}
