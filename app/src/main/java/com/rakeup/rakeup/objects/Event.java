package com.rakeup.rakeup.objects;

/**
 * Created by emre on 28.08.16.
 */
public class Event {

    private long id;
    private String eventName;
    private String creatorName;     // Remove later.
    private String eventDetail;
    private String eventDate;
    private long createDate;
    private long userId;

    public Event(long id, String eventName, String creatorName) {
        this.id = id;
        this.eventName = eventName;
        this.creatorName = creatorName;
    }

    public Event(long id, String eventName, String creatorName, long userId) {
        this.id = id;
        this.eventName = eventName;
        this.creatorName = creatorName;
        this.userId = userId;
    }

    public Event(long id, String eventName, String creatorName, long userId, long createDate) {
        this.id = id;
        this.eventName = eventName;
        this.creatorName = creatorName;
        this.userId = userId;
        this.createDate = createDate;
    }

    public Event(long id, String eventName, String eventDetail, String eventDate, long createDate, long userId) {
        this.id = id;
        this.eventName = eventName;
        this.eventDetail = eventDetail;
        this.eventDate = eventDate;
        this.createDate = createDate;
        this.userId = userId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public void setUser(long user) {
        this.userId = user;
    }

    public long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getCreatorNameWithByTag() {
        return "by  " + creatorName;
    }

    public String getEventDetail() { return eventDetail; }

    public String getEventDate() {
        return eventDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public long getUser() {
        return userId;
    }
}
