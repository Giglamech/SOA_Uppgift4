import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebhookManager {
    String url;
    String requestContent;

    String canvasUrl = "https://ltu.instructure.com/api/v1/";
    String canvasToken = "3755~buPUF77WBixkcXA6X5yfMnnCGOiPwOtPQW4a8Vw2i96ihLZoaWy23wIEZsTXhrL7";

    String testUrl = "https://webhook.site/55fe39a4-02dc-4cb0-801d-a156ab01b970";

    String timeEditUrl = "https://cloud.timeedit.net/ltu/web/schedule1/ri105656X45Z0XQ6Z36g1Y40y3036Y32107gQY6Q547520876YQ837.json";

    public String getCanvas(String userId, String endDate) throws IOException {
        requestContent = "end_date=" + endDate;
        url = canvasUrl + "users/" + userId + "/calendar_events";
        return sendGET(url, requestContent, canvasToken);
    }

    public String postCanvas(String content) throws IOException {
        requestContent = content;
        url = canvasUrl+ "calendar_events";
        return sendPOST(url, requestContent, canvasToken);
    }

    public String getTimeEdit(String content) throws IOException {
        requestContent = "";
        url = timeEditUrl;
        return sendGET(url, requestContent, "");
    }


    private String sendGET(String url, String query, String authorizationToken) throws IOException {

        if (query != "") {
            url = url + "?" + query;
        }
        HttpURLConnection connection = createConnection(url, "GET", authorizationToken);

        int responseCode = connection.getResponseCode();
        System.out.println("GET Response code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            return readResponse(connection);
        } else {
            System.out.println("GET request failed");
            return null;
        }
    }

    private String sendPOST(String url, String content, String authorizationToken) throws IOException {
        HttpURLConnection connection = createConnection(url, "POST", authorizationToken);

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = content.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("POST response code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            return readResponse(connection);
        } else {
            System.out.println("POST request failed");
            return null;
        }


    }

    private HttpURLConnection createConnection(String url, String requestType, String authorizationToken) throws IOException {
        URL destinationUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)destinationUrl.openConnection();

        connection.setRequestMethod(requestType);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        if (authorizationToken != "") {
            connection.setRequestProperty("Authorization", "Bearer " + authorizationToken);
        }
        connection.setDoOutput(true);

        System.out.println("connection.getRequestMethod() = " + connection.getRequestMethod());
        System.out.println("DestinationUrl = " + destinationUrl);
        System.out.println("Authorizaitontoken = " + authorizationToken);
        System.out.println("RequestType = " + requestType);

        return connection;
    }

    private String readResponse(HttpURLConnection connection) throws IOException {
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
