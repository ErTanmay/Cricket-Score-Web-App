package com.tsl.cricket_score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
	
	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/sendScore")
	//@SendTo("/topic/score")
	public String sendMessages(String score) {
		template.convertAndSend("/topic/score", score);
		System.out.println("message >>> " + score);
		return score;
	}
	
	
}
