package br.com.dclimaitesBot.entity;

import java.util.Collection;
import java.util.HashSet;

import com.pengrad.telegrambot.model.Update;

import br.com.dclimaitesBot.entity.instructions.DepositarInstruction;
import br.com.dclimaitesBot.entity.instructions.NaoDefinidoInstruction;
import br.com.dclimaitesBot.interfaces.Instruction;

public class MessageManager {
	private Collection<String> comandosDoUsuario;
	
	public MessageManager() {
		comandosDoUsuario = new HashSet<String>();
		
		comandosDoUsuario.add("/sacar");
		comandosDoUsuario.add("/depositar");
	}
	
	public Instruction TratarMensagem(Update userMessage) {
		String mensagem = userMessage.message().text();
		
		Cliente cliente = new Cliente(userMessage.message().chat().id());
		
		if(comandosDoUsuario.contains(mensagem))
			return new DepositarInstruction(cliente);
		
		return new NaoDefinidoInstruction();
			
	}
	
}
