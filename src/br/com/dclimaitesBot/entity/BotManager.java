package br.com.dclimaitesBot.entity;

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import br.com.dclimaitesBot.interfaces.BotManagerInterface;
import java.util.TimerTask;

public class BotManager extends TimerTask {
	private TelegramBot bot;
	private GetUpdatesResponse updatesResponse;
	private SendResponse sendResponse;
	private BaseResponse baseResponse;
	private int Id;
	private int i;
	private int offSet;

	public BotManager() {
		bot = TelegramBotAdapter.build("988597064:AAHDM9tK1-wt52z4rfE8wqsYBFlqogTBZeA");
		Id = (int) (Math.random() * 100);
		offSet = 0;
	}

	@Override
	public void run() {

		try {

			// executa comando no Telegram para obter as mensagens pendentes a partir de um
			// off-set (limite inicial)
			updatesResponse = bot.execute(new GetUpdates().limit(100).offset(offSet));
			// lista de mensagens
			List<Update> updates = updatesResponse.updates();
			// an�lise de cada a��o da mensagem
			for (Update update : updates) {
				i++;
				// atualiza��o do off-set
				offSet = update.updateId() + 1;
				System.out.println("Recebendo mensagem:" + update.message().text());

				SendChatAction sendMessage = new SendChatAction(update.message().chat().id(), ChatAction.typing.name());

				// envio de "Escrevendo" antes de enviar a resposta
				baseResponse = bot.execute(sendMessage);
				// verifica��o de a��o de chat foi enviada com sucesso
				System.out.println("Resposta de Chat ActionEnviada?" + baseResponse.isOk());
				// envio da mensagem de resposta
				sendResponse = bot.execute(new SendMessage(update.message().chat().id(), "N�o entendi..."));
				// verifica��o de mensagem enviada com sucesso
				System.out.println("Mensagem Enviada?" + sendResponse.isOk());
			}

			System.out.println("Finalizou o bot");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}