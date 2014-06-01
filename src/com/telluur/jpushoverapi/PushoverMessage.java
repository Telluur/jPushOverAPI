package com.telluur.pushover;

public class PushoverMessage {
    private String message;
    private String device;
    private String title;
    private String url;
    private String url_title;
    private PushoverPriority priority;
    private String timestamp;
    private PushoverSound sound;
    private int retry = 30;
    private int expire = 15 * 60;

    public PushoverMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public PushoverMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDevice() {
        return device;
    }

    public PushoverMessage setDevice(String device) {
        this.device = device;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PushoverMessage setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PushoverMessage setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUrl_title() {
        return url_title;
    }

    public PushoverMessage setUrl_title(String url_title) {
        this.url_title = url_title;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public PushoverMessage setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public PushoverSound getSound() {
        return sound;
    }

    public PushoverMessage setSound(PushoverSound sound) {
        this.sound = sound;
        return this;
    }

    public PushoverPriority getPriority() {
        return priority;
    }

    public PushoverMessage setPriority(PushoverPriority priority) {
        this.priority = priority;
        return this;
    }

    public int getRetry() {
        return retry;
    }

    public PushoverMessage setRetry(int retry) {
        this.retry = retry;
        return this;
    }

    public int getExpire() {
        return expire;
    }

    public PushoverMessage setExpire(int expire) {
        this.expire = expire;
        return this;
    }
}
