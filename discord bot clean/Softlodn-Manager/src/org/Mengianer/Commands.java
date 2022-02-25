package org.Mengianer;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent event) {
		if (!event.getAuthor().isBot()) {
			Random rnd = new Random();
			
			String[] args = event.getMessage().getContentRaw().split("\\s+");
			
			String[] woman = {"girl", "Frau", "woman", "Madl", "Weibets"};
			
			String[] woman_answer = {"What is that '<woman>'? Never heared that.", "<woman> does not exist at TFO", "<woman> TF IS THAT??ß"};
			
			String[] corona = {"virus", "corona", "impf", "covid"};
			
			String answer_corona = "Sehr geehrter <dcping>, sehr geehrter Dr. 👨‍⚕️ med. Johann Loibner, herzlichen Dank 🙏 für den Artikel 📰, er zeigt von der Bereitschaft 🤝 auch die Lebenserfahrung eines tiefsinnigen Menschen 👨, der seine Berufung und seinen Beruf 👨‍⚕️ immer ernst genommen hat, zu veröffentlichen. Es ist unmöglich in den wenigen Fragestellungen ⁉️ all die Erfahrungen über die übliche Schulmedizin 🧬 hinaus kund zu tun. Es ist schon verwunderlich, dass Südtirol als eine kleine Insel 🏝 im Herzen Europas🇪🇺 an der Pflichtimpfung immer noch festhalten 🖐muss, wenn um die Landesgrenzen 〰herum alle Bewohner FREI ENTSCHEIDEN 📣 können, ob sie das eigene Kind 👧 impfen💉 oder nicht 🚫 impfen lassen. Fazit: Sie würde ja gerne die freie Entscheidung👆 befürworten, bzw. die Pflichtimpfung 💉abschaffen wollen, weil sie in dieser Form keinen Sinn mehr ergibt, allein das Gesetz 📃 kann ohne der erreichten Durchimpfungsrate 📈 nicht geändert werden. Die aktuellen Durchimpfungsraten 📊 des Landes zeigen etwas Erstaunliches 🤯 : Die Durchimpfungsrate im Jahre 2000 stand im Mittel bei 95%. Im Laufe 🏃der letzten 16 Jahr hat dies Rate 📈 stark abgenommen und die zu erwartenden Krankheitsfälle 🤒 haben nicht zugenommen, sondern entgegengesetzt 🔄 auch abgenommen! Es gibt die Polioerkrankung 🤒 zentriert schon noch, nämlich dort, wo Seuchen drohen und im Kongo-Afrika 👨🏿, wo mit DDT versucht wird die Hütten frei von der Malaria 🦠zu halten!  Ich könnte den kritischen Lesern 🥸 nun von zwei aktuellen Impfschäden berichten. Zufällig sind die Eltern 👨‍👩‍👦 beiderseits im Krankenhaus 🏥 tätig, kennen also die Struktur, die Vorteile, die Risiken ⚠️. Vor der Impfung 💉ihrer Kinder 👧 waren sie überzeugte Impfer. Nun sehen sie die Sachlage ganz anders, haben mit den Gerichten 👩‍⚖️ zu kämpfen, weil sie den Schaden 🤕 nachweisen müssen! Geschätzte Grüße 🙋‍♂️👊.";
			
			Message m = event.getMessage();
			
			if (args[0].equalsIgnoreCase(Main.prefix + "info")) {
				EmbedBuilder info_command = new EmbedBuilder();
				info_command.setTitle("Bot v1.0");
				info_command.setDescription("Info");
				info_command.addField("!info", "shows this info :man_shrugging:", false);
				info_command.addField("!sc", "random lightshot screenshot", false);
				info_command.addField("if some message contains 'girl' or 'frau' or something  similar", "random TFO female meme", false);
				info_command.addField("if some message contains 'impfung' or 'corona' or something  similar", "Laner gets angry", false);
				info_command.addField("if some message contains 'rg'", "bad.", false);
				info_command.setColor(0xFB8B01);
				event.getChannel().sendMessageEmbeds(info_command.build()).queue();
			}
			else if (args[0].equalsIgnoreCase(Main.prefix + "sc")) {
				String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
				String url = "https://prnt.sc/";
				for (int i = 0; i < 6; i++) {
					url += abc[rnd.nextInt(abc.length)];
				}
				event.getChannel().sendMessage(url).queue();
			} 
			else if (args[0].equalsIgnoreCase(Main.prefix + "ping")) {
				
				event.getChannel().sendMessage(Main.ping()+"ms").queue();
			}
			else 
			{
				for (int p = 0; p < args.length; p++) {
					if (args[p].toLowerCase().equalsIgnoreCase("rg")) {
						event.getChannel().sendMessage("RG is Bad!").queue();
					}
				}
				for (int u = 0; u < woman.length; u++) {
					if (m.getContentRaw().toLowerCase().contains(woman[u].toLowerCase())) {
						event.getChannel().sendMessage(woman_answer[rnd.nextInt(woman_answer.length)].replace("<woman>", woman[u].toString())).queue();
					}
				}
				for (int t = 0; t < corona.length; t++) {
					if (m.getContentRaw().toLowerCase().contains(corona[t].toLowerCase())) {
						event.getChannel().sendMessage(answer_corona.replace("<dcping>", event.getAuthor().getAsMention().toString())).queue();
					}
				}
			}
		}
	}
}
