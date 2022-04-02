import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.Random;

public class Commands extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()) {
            Random rnd = new Random();
            //TODO: Des in a json inni
            String[] args = event.getMessage().getContentRaw().split("\\s+");

            String[] woman = {"girl", "Frau", "woman", "Madl", "Weibets"};

            String[] woman_answer = {"What is that '<woman>'? Never heared that.", "<woman> does not exist at TFO", "<woman> TF IS THAT??ß"};

            String[] corona = {"virus", "corona", "impf", "covid"};

            String[] corona_answer = {"Sehr geehrter <dcping>, sehr geehrter Dr. :man_health_worker: med. Johann Loibner, herzlichen Dank :pray: für den Artikel :newspaper:, er zeigt von der Bereitschaft :handshake: auch die Lebenserfahrung eines tiefsinnigen Menschen :man:, der seine Berufung und seinen Beruf :man_health_worker: immer ernst genommen hat, zu veröffentlichen. Es ist unmöglich in den wenigen Fragestellungen :interrobang: all die Erfahrungen über die übliche Schulmedizin :dna: hinaus kund zu tun. Es ist schon verwunderlich, dass Südtirol als eine kleine Insel :island: im Herzen Europas :flag_eu: an der Pflichtimpfung immer noch festhalten :hand_splayed: muss, wenn um die Landesgrenzen :wavy_dash: herum alle Bewohner FREI ENTSCHEIDEN :mega: können, ob sie das eigene Kind :girl: impfen :syringe: oder nicht :no_entry_sign: impfen lassen. ", "Sie würde ja gerne die freie Entscheidung :point_up_2: befürworten, bzw. die Pflichtimpfung :syringe: abschaffen wollen, weil sie in dieser Form keinen Sinn mehr ergibt, allein das Gesetz :page_with_curl: kann ohne der erreichten Durchimpfungsrate :chart_with_upwards_trend: nicht geändert werden. Die aktuellen Durchimpfungsraten :bar_chart: des Landes zeigen etwas Erstaunliches :exploding_head: : Die Durchimpfungsrate im Jahre 2000 stand im Mittel bei 95%. Im Laufe :person_running: der letzten 16 Jahr hat dies Rate :chart_with_upwards_trend: stark abgenommen und die zu erwartenden Krankheitsfälle :thermometer_face: haben nicht zugenommen, sondern entgegengesetzt :arrows_counterclockwise: auch abgenommen! Es gibt die Polioerkrankung :thermometer_face: zentriert schon noch, nämlich dort, wo Seuchen drohen und im Kongo-Afrika :man_tone5:, wo mit DDT versucht wird die Hütten frei von der Malaria :microbe: zu halten!", "Ich könnte den kritischen Lesern :disguised_face: nun von zwei aktuellen Impfschäden berichten. Zufällig sind die Eltern :family_man_woman_boy: beiderseits im Krankenhaus :hospital: tätig, kennen also die Struktur, die Vorteile, die Risiken :warning:. Vor der Impfung :syringe:ihrer Kinder :girl: waren sie überzeugte Impfer. Nun sehen sie die Sachlage ganz anders, haben mit den Gerichten :woman_judge: zu kämpfen, weil sie den Schaden :head_bandage: nachweisen müssen! Geschätzte Grüße :man_raising_hand: :punch:."};

            Message m = event.getMessage();

            if (args[0].equalsIgnoreCase(Main.prefix + "info")) {
                event.getChannel().sendMessageEmbeds(getInfoEmbed(event).build()).queue();
                System.out.println("\ncommand: " + Main.prefix + "info\nservername: " + m.getGuild().getName() + "\nautor: " + m.getAuthor().getName() + "\nmessage: " + m.getContentRaw() + "\nnickname: " + m.getMember().getEffectiveName() + "\n");
            }
            else if (args[0].equalsIgnoreCase(Main.prefix + "sc")) {
                event.getMessage().replyEmbeds(getScEmbed(ImageUtils.getValidURL()).build()).setActionRow(new ItemComponent[]{Button.primary("sc-1", "another one")}).queue();
                System.out.println("\ncommand: " + Main.prefix + "sc\nservername: " + m.getGuild().getName() + "\nautor: " + m.getAuthor().getName() + "\nmessage: " + m.getContentRaw() + "\nnickname: " + m.getMember().getEffectiveName() + "\n");
            }
            else if (args[0].equalsIgnoreCase(Main.prefix + "ping")) {
                event.getChannel().sendMessage(Main.ping()+"ms").queue();
                System.out.println("\ncommand: " + Main.prefix + "ping\nservername: " + m.getGuild().getName() + "\nautor: " + m.getAuthor().getName() + "\nmessage: " + m.getContentRaw() + "\nnickname: " + m.getMember().getEffectiveName() + "\n");
            }
            else
            {
                for (int p = 0; p < args.length; p++) {
                    if (args[p].toLowerCase().equalsIgnoreCase("rg")) {
                        event.getChannel().sendMessage("RG is Bad!").queue();
                        System.out.println("\ncalled: RG \nservername: " + m.getGuild().getName() + "\nautor: " + m.getAuthor().getName() + "\nmessage: " + m.getContentRaw() + "\n");
                    }
                }
                for (int u = 0; u < woman.length; u++) {
                    if (m.getContentRaw().toLowerCase().contains(woman[u].toLowerCase())) {
                        event.getChannel().sendMessage(woman_answer[rnd.nextInt(woman_answer.length)].replace("<woman>", woman[u].toString())).queue();
                        System.out.println("\ncalled: woman (" + woman[u].toString() + ")\nservername: " + m.getGuild().getName() + "\nautor: " + m.getAuthor().getName() + "\nmessage: " + m.getContentRaw() + "\nnickname: " + m.getMember().getEffectiveName() + "\n");
                    }
                }
                for (int t = 0; t < corona.length; t++) {
                    if (m.getContentRaw().toLowerCase().contains(corona[t].toLowerCase())) {
                        //INFO: Embeds kinnen 6000 chars, normale messages lei 2000 chars
                        EmbedBuilder sc_command = getCoronaEmbed(event, corona_answer);
                        event.getChannel().sendMessageEmbeds(sc_command.build()).queue();
                        System.out.println("\ncalled: corona (" + corona[t].toString() + ")\nservername: " + m.getGuild().getName() + "\nautor: " + m.getAuthor().getName() + "\nmessage: " + m.getContentRaw() + "\nnickname: " + m.getMember().getEffectiveName() + "\n");
                    }
                }
            }
        }
    }

    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getButton().getId().equalsIgnoreCase("sc-1")) {
            event.editMessageEmbeds(getScEmbed(ImageUtils.getValidURL()).build()).setActionRow(new ItemComponent[]{Button.primary("sc-1", "another one")}).queue();
            System.out.println("\nButton: another one\nservername: " + event.getGuild().getName() + "\nautor: " + event.getMember().getUser().getName() + "\nnickname: " + event.getMember().getEffectiveName() + "\n");
        }
    }
    public static EmbedBuilder getInfoEmbed(MessageReceivedEvent event){
        EmbedBuilder info_command = new EmbedBuilder();
        info_command.setTitle("Bot v1.0");
        info_command.setDescription("Info");
        info_command.addField("!info", "shows this info :man_shrugging:", false);
        info_command.addField("!sc", "random lightshot screenshot", false);
        info_command.addField("if some message contains 'girl' or 'frau' or something  similar", "random TFO female meme", false);
        info_command.addField("if some message contains 'impfung' or 'corona' or something  similar", "Laner gets angry", false);
        info_command.addField("if some message contains 'rg'", "bad.", false);
        info_command.setThumbnail("https://i.imgur.com/p0yBD80.png");
        info_command.setColor(0xFB8B01);
        return info_command;
    }
    public static EmbedBuilder getCoronaEmbed(MessageReceivedEvent event, String[] corona_answer){
        EmbedBuilder corona_command = new EmbedBuilder();
        corona_command.addField("", corona_answer[0].replace("<dcping>", event.getAuthor().getAsMention().toString()), false);
        corona_command.addField("Fazit:", corona_answer[1], false);
        corona_command.addField("", corona_answer[2], false);
        corona_command.setThumbnail("https://i.redd.it/7csic62pd9b81.png");
        corona_command.setColor(0xFB8B01);
        return corona_command;
    }
    public static EmbedBuilder getScEmbed(String[] url){
        EmbedBuilder sc_command = new EmbedBuilder();
        sc_command.setTitle("Lightshot Screenshot");
        sc_command.setImage(url[1]);
        sc_command.addField("URL", url[0], false);
        sc_command.setThumbnail("https://i.imgur.com/p0yBD80.png");
        sc_command.setColor(0xFB8B01);
        return sc_command;
    }
}
