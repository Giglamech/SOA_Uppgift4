import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebhookManager {
    String url;
    String type;
    String requestContent;

    String canvasUrl = "https://ltu.instructure.com/api/v1/";
    String canvasToken = "3755~buPUF77WBixkcXA6X5yfMnnCGOiPwOtPQW4a8Vw2i96ihLZoaWy23wIEZsTXhrL7";

    String testUrl = "https://webhook.site/55fe39a4-02dc-4cb0-801d-a156ab01b970";

    String timeEditUrl = "";
    String timeEditToken = "";
    public String getCanvas(String userId, String endDate) throws IOException {
        requestContent = "{\"calendar_event\": {\"end_date\":\"" + endDate + "\"}";
        url = canvasUrl + "users/" + userId + "/calendar_events";
        url = "https://ltu.instructure.com/api/v1/users/98107/calendar_events";
        url = testUrl;
        type = "GET";
        return sendRequest(type, url, requestContent, canvasToken);
    }

    public String postCanvas(String content) throws IOException {
        requestContent = content;
        url = canvasUrl+ "calendar_events";
        type = "POST";
        return sendRequest(type, url, requestContent, canvasToken);
    }

    public String getTimeEdit(String content) throws IOException {
        requestContent = content;
        url = timeEditUrl;
        type = "GET";
        return sendRequest(type, url, requestContent, timeEditToken);
    }

    public String postTimeEdit(String content) throws IOException {
        requestContent = content;
        url = timeEditUrl;
        type = "POST";
        return sendRequest(type, url, requestContent, timeEditToken);
    }

    private String sendRequest(String requestType, String url, String content, String authorizationToken) throws IOException {
        URL destinationUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)destinationUrl.openConnection();
        connection.setRequestMethod(requestType);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + authorizationToken);
        connection.setDoOutput(true);
        System.out.println("connection.getRequestMethod() = " + connection.getRequestMethod());
        System.out.println("DestinationUrl = " + destinationUrl);
        System.out.println("Content = " + content);
        System.out.println("Authorizaitontoken = " + authorizationToken);
        System.out.println("RequestType = " + requestType);

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = content.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        StringBuilder response = new StringBuilder();
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }
        return response.toString();
    }
}
