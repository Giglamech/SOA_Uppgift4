import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.json.*;


public class Main {
    public static void main(String[] args) throws IOException {

        //SKAPA GUI SAKER

        //Används för att göra calls till TimeEdit / Canvas
        WebhookManager webhookManager = new WebhookManager();

        String canvasTestCreateEventString = "{\"calendar_event\": {\"context_code\":\"user_98107\",\"title\":\"api test\",\"start_at\":\"2022-12-18T10:15:00Z\",\"end_at\":\"2022-12-18T11:45:00Z\"}}";
        String userIDBjorn = "98107";
        String startDate = "2022-11-16T16:00:00Z";
        String endDate = "2023-01-16T16:00:00Z";

        String getCanvasRes = webhookManager.getCanvas(userIDBjorn, startDate, endDate);
        String postCanvasRes = webhookManager.postCanvas(canvasTestCreateEventString);
        String getTimeEditRes = webhookManager.getTimeEdit("");
        System.out.println(getCanvasRes);
        System.out.println();
        System.out.println(postCanvasRes);
        System.out.println();
        System.out.println(getTimeEditRes);
        System.out.println();
        System.out.println(jsonToCalendarEntryList(getTimeEditRes));
        System.out.println();
    }

    public static CalendarEntry[] jsonToCalendarEntryList(String jsonContent) {
        //JSONObject object;

        return null;
    }
}




