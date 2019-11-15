package br.com.dclimaitesBot.entity;

import java.util.Collection;
import java.util.HashSet;

import com.pengrad.telegrambot.model.Update;

import br.com.dclimaitesBot.interfaces.Instruction;

public class MessageManager {
	private Collection<String> userPossibleQuestions;
	
	public MessageManager() {
		userPossibleQuestions = new HashSet<String>();
		
		userPossibleQuestions.add("Gostaria de depositar?");
		userPossibleQuestions.add("Qual é o valor que gostaria de sacar?");
	}
	
	public Instruction TreateMessage(Update userMessage) {
		String teste;
		Cliente cliente = new Cliente(userMessage.message().chat().id());
		return new DepositarInstruction(cliente);
			
	}
	
}
