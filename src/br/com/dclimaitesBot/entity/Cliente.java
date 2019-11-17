package br.com.dclimaitesBot.entity;

import br.com.dclimaitesBot.interfaces.Instruction;

public class Cliente {
	private long chatId;
	private InstructionBase ultimaInstrucao;
	
	public Cliente(long chatId) {
		this.chatId = chatId;
	}

	public long getChatId() {
		// TODO Auto-generated method stub
		return chatId;
	}

	public InstructionBase getUltimaInstrucao() {
		return ultimaInstrucao;
	}

	public void setUltimaInstrucao(InstructionBase ultimaInstrucao) {
		this.ultimaInstrucao = ultimaInstrucao;
	}
}
