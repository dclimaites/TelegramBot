import br.com.dclimaitesBot.entity.BotManager;
import br.com.dclimaitesBot.interfaces.BotManagerInterface;
import java.util.Timer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BotManager bot = new BotManager();
		try {
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(bot, 0, 10000);
			
			System.out.println("Finalizou");
			
		} catch (Exception e) {
			System.out.println("Erro na execu��o do BOT");
			System.out.println(e);
		}
	}

}