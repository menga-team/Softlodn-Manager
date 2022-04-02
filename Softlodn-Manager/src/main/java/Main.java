import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

//info: dear trash isch fe a 1 Klassler gecod.. zomekopiert wordn. Wennda kuen Herzinfarkt kriegen willsch, schau net weiter..

public class Main {

    public static JDA jda;

    public static String prefix = "!";

    private static String token = "SGFoYSwgYmlzY2ggNSBoZWFkLi4gKGJyYXVjaCByZWFsZSBsw6RuZ2Up"; //64

    public static void main(String[] args) throws LoginException {
        jda = JDABuilder.createDefault(token).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("RGler-Ban-Speedrun"));
        jda.addEventListener(new Commands());
    }
    public static long ping() {
        return jda.getGatewayPing();
    }
}
