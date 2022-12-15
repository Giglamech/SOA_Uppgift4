import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //SKAPA GUI SAKER

        //Används för att göra calls till TimeEdit / Canvas
        WebhookManager webhookManager = new WebhookManager();

        //String jsonInputString = "{\"name\": \"Upendra\", \"job\": \"Programmer\"}";

        String jsonInputString = "{\"context_code\":\"user_98107\"title\":\"API TEST\", \"start_at\":\"2022-12-18T10:15:00Z\", \"end_at\":\"2022-12-18T12:30:00Z\"}";
        System.out.println(webhookManager.postCanvas(jsonInputString));
    }
}