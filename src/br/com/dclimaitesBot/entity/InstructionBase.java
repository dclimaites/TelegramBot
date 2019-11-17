package br.com.dclimaitesBot.entity;

import com.pengrad.telegrambot.request.SendMessage;

import br.com.dclimaitesBot.interfaces.Instruction;

public abstract class InstructionBase implements Instruction {
	protected Cliente cliente;
	private Object dado;
	
	public InstructionBase(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public InstructionBase(Cliente cliente, Object dado) {
		this.cliente = cliente;
		this.setDado(dado);
	}
	
	public SendMessage TratarRetornoSendMessage(String mensagem) {
		return new SendMessage(cliente.getChatId(), mensagem);
	}

	public Object getDado() {
		return dado;
	}

	public void setDado(Object dado) {
		this.dado = dado;
	}
}
