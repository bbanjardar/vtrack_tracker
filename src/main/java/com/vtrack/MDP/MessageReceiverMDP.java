package com.vtrack.MDP;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.vtrack.Data;

@Component
public class MessageReceiverMDP {
	
	@Autowired
	private Data data;
	
	@JmsListener(destination="positionQueue")
	public void processPositionFromQueue(Map<String,String> incomingMessage){
		data.updatePosition(incomingMessage);
		//System.out.println("received message "+ incomingMessage);
	}

}
