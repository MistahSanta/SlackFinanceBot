package jo;

import com.github.seratch.jslack.api.webhook.WebhookResponse;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Hello world!
 *
 */
public class Main 
{
    private static String webHookUrl = "https://hooks.slack.com/services/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";
    private static String oAuthToken = "xoxb-54260494385-5435480896694-Mn4P6QjzcWn9C2ZSKIzHtlkO";
    private static String slackChannel = "finance_bot";


    public static void main( String[] args )
    {
        Dotenv dotenv = Dotenv.load();
        System.out.println("Secret");
        System.out.println(dotenv.get("TEST"));

        //sendMessage("First Message Test using a bot");
    }

    public static void sendMessage(String message)
    {
        try {
            //Build the string message to be sent 
            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(message);
            //Prepare the message to be sent using payload
            Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();

            // Send message to slack
            WebhookResponse wbResp = Slack.getInstance().send(webHookUrl, payload);
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
