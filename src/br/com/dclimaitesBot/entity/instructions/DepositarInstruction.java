package br.com.dclimaitesBot.entity.instructions;

import com.pengrad.telegrambot.request.SendMessage;

import br.com.dclimaitesBot.entity.Cliente;
import br.com.dclimaitesBot.interfaces.Instruction;

public class DepositarInstruction implements Instruction {
	
	private Cliente cliente;
	
	public DepositarInstruction(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String process() {
		// TODO Auto-generated method stub
		return "Valor depositado com sucesso";
	}

}
