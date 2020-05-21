package com.controller.service.impl;

import org.apache.kafka.common.record.TimestampType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.controller.service.KafkaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaServiceImpl implements KafkaService {
	
	@Value("${spring.kafka.env}")
	private String KAFKA_MESSAGE_ENV;
	
	@Autowired
	private KafkaTemplate KafkaTemplate;
	
	@Override
	public void sendMessage(String topic, String msg) {
		try {
			Message<String> message = MessageBuilder.
					withPayload(msg)
					.setHeader(KafkaHeaders.TOPIC, topic)
					.setHeader(KafkaHeaders.TIMESTAMP_TYPE, TimestampType.CREATE_TIME)
					.setHeader(KafkaHeaders.TIMESTAMP, System.currentTimeMillis())
					.setHeader("env", KAFKA_MESSAGE_ENV)
					.build();
			
		} catch (Exception e) {
//			log.info();
			throw new RuntimeException("");
		}

	}

	@Override
	public void sendMessage(String topic, String message, String partnerSystem, String partnerUserId, String tenantId,
			String kafkaEnv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMessageToKafkaErrorTopic(String topic, String message, String partnerSystem, String partnerUserId,
			String tenantId, String kafkaEnv, Integer retryCount) {
		// TODO Auto-generated method stub

	}

}
