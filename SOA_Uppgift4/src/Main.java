import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //SKAPA GUI SAKER

        //Används för att göra calls till TimeEdit / Canvas
        WebhookManager webhookManager = new WebhookManager();

        String canvasTestCreateEventString = "{\"calendar_event\": {\"context_code\":\"user_98107\",\"title\":\"api test\",\"start_at\":\"2022-12-18T10:15:00Z\",\"end_at\":\"2022-12-18T11:45:00Z\"}}";
        String userIDBjorn = "98107";
        String endDate = "2023-01-16T16:00:00Z";
        //System.out.println(webhookManager.getCanvas(userIDBjorn, endDate));
        //System.out.println(webhookManager.postCanvas(canvasTestCreateEventString));
        System.out.println(webhookManager.getTimeEdit(""));
    }
}




