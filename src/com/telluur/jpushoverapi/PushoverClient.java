package com.telluur.jpushoverapi;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class PushoverClient {
    private static final String PUSHOVER_URL = "https://api.pushover.net/1/messages.json";
    private String token;
    private String user;


    public PushoverClient(String token, String user) {
        this.token = token;
        this.user = user;
    }

    public void sendMessage(PushoverMessage pushoverMessage){
        //TODO Queue messages.
        doPost(pushoverMessage);
    }

    public void doPost(PushoverMessage pushoverMessage) {
        try {
            String urlParameters = createUrlParameter(pushoverMessage);
            System.out.println("JPushoverAPI | Requestmessage: \t\t" + urlParameters);
            HttpsURLConnection connection = (HttpsURLConnection) new URL(PUSHOVER_URL).openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
            connection.setUseCaches(false);

            DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
            writer.writeBytes(urlParameters);
            writer.flush();

            System.out.println("JPushoverAPI | Responsemessage: \t" + connection.getResponseCode() + "/" + connection.getResponseMessage());
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println("JPushoverAPI | Responsebody: \t\t" + line);
            }
            System.out.println("-------------------------------------------------------------");

            writer.close();
            reader.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String createUrlParameter(PushoverMessage pushoverMessage) {
        StringBuilder result = new StringBuilder();
        result.append("token=" + token + "&user=" + user + "&message=" + pushoverMessage.getMessage());

        if (pushoverMessage.getDevice() != null) {
            result.append("&device=" + pushoverMessage.getDevice());
        }
        if (pushoverMessage.getTitle() != null) {
            result.append("&title=" + pushoverMessage.getTitle());
        }
        if (pushoverMessage.getUrl() != null) {
            result.append("&url=" + pushoverMessage.getUrl());
        }
        if (pushoverMessage.getUrl_title() != null) {
            result.append("&url_title=" + pushoverMessage.getUrl_title());
        }
        if (pushoverMessage.getPriority() != null) {
            if (pushoverMessage.getPriority() == PushoverPriority.EMERGENCY) {
                result.append("&priority=" + pushoverMessage.getPriority().getValue() + "&retry=" + pushoverMessage.getRetry() + "&expire=" + pushoverMessage.getExpire());
            } else {
                result.append("&priority=" + pushoverMessage.getPriority().getValue());
            }
        }
        if (pushoverMessage.getTimestamp() != null) {
            result.append("&timestamp=" + pushoverMessage.getTimestamp());
        }
        if (pushoverMessage.getSound() != null) {
            result.append("&sound=" + pushoverMessage.getSound().toString().toLowerCase());
        }
        return result.toString();
    }
}
