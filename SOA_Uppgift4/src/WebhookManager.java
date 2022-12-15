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

    String canvasUrl = "https://www.ltu.infrastructure.com/api/v1/calendar_events.json";

    String canvasToken = "3755~gllzMIPeJKlBJSFLmmAVkQEbPoC77R7KqtDtWzo0eBPt0aP8KsFVm2cGWIHZpmKB";
    String timeEditToken = "";
    public String getCanvas(String content) throws IOException {
        requestContent = content;
        url = "https://webhook.site/55fe39a4-02dc-4cb0-801d-a156ab01b970"; //Ska vara URL till canvas
        type = "GET";
        return sendRequest(type, canvasUrl, requestContent, canvasToken);
    }

    public String postCanvas(String content) throws IOException {
        requestContent = content;
        url = "https://webhook.site/55fe39a4-02dc-4cb0-801d-a156ab01b970"; //Ska vara URL till canvas
        type = "POST";
        return sendRequest(type, canvasUrl, requestContent, canvasToken);
    }

    public String getTimeEdit(String content) throws IOException {
        requestContent = content;
        url = "https://webhook.site/55fe39a4-02dc-4cb0-801d-a156ab01b970"; //Ska vara URL till timeEdit
        type = "GET";
        return sendRequest(type, url, requestContent, timeEditToken);
    }


    public String postTimeEdit(String content) throws IOException {
        requestContent = content;
        url = "https://webhook.site/55fe39a4-02dc-4cb0-801d-a156ab01b970"; //Ska vara URL till timeEdit
        type = "POST";
        return sendRequest(type, url, requestContent, timeEditToken);
    }

    private String sendRequest(String requestType, String url, String content, String authorziationToken) throws IOException {
        URL destinationUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)destinationUrl.openConnection();
        connection.setRequestMethod(requestType);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization","Bearer <"+authorziationToken+">");
        connection.setDoOutput(true);

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
