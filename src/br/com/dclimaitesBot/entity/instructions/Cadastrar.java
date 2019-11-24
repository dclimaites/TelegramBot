package br.com.dclimaitesBot.entity.instructions;

import com.pengrad.telegrambot.request.SendMessage;

import br.com.dclimaitesBot.entity.Cliente;
import br.com.dclimaitesBot.entity.InstructionBase;

public class Cadastrar extends InstructionBase {

	public Cadastrar(Cliente cliente) {
		super(cliente);
	}

	@Override
	public SendMessage processar() {
		// TODO Auto-generated method stub
		return null;
	}

}
