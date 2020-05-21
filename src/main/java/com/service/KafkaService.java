package com.controller.service;

public interface KafkaService {

	void sendMessage(String topic, String message);
	
	void sendMessage(String topic, String message, String partnerSystem, String partnerUserId, String tenantId, String kafkaEnv);
	
	void sendMessageToKafkaErrorTopic(String topic, String message, String partnerSystem, String partnerUserId, String tenantId,
			String kafkaEnv, Integer retryCount);
}
