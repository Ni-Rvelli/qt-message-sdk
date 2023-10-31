package com.nr.message.model;

import com.alibaba.lingyang.quick.tracking.qlc.java.sdk.model.QtLog;

import java.util.Map;

/**
 * @Description: 消息实体
 * @Author: nirui
 * @Date: 2023/10/19 11:38
 */
public class NrMessageLog {
    private String deviceId;
    private String uuid;
    private String userId;
    private String eventId;
    private String pageName;
    private String debugKey;
    private Map<String, Object> systemProperties;
    private Map<String, Object> customProperties;
    private Map<String, String> idTracking;
    private Map<String, String> tags;
    private Long serverTimestamp;
    private Long eventTimestamp;

    public Map<String, String> getIdTracking() {
        return this.idTracking;
    }

    public void setIdTracking(Map<String, String> idTracking) {
        this.idTracking = idTracking;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPageName() {
        return this.pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getDebugKey() {
        return this.debugKey;
    }

    public void setDebugKey(String debugKey) {
        this.debugKey = debugKey;
    }

    public Map<String, Object> getSystemProperties() {
        return this.systemProperties;
    }

    public void setSystemProperties(Map<String, Object> systemProperties) {
        this.systemProperties = systemProperties;
    }

    public Map<String, Object> getCustomProperties() {
        return this.customProperties;
    }

    public void setCustomProperties(Map<String, Object> customProperties) {
        this.customProperties = customProperties;
    }

    public Long getServerTimestamp() {
        return this.serverTimestamp;
    }

    public void setServerTimestamp(Long serverTimestamp) {
        this.serverTimestamp = serverTimestamp;
    }

    public Long getEventTimestamp() {
        return this.eventTimestamp;
    }

    public void setEventTimestamp(Long eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private NrMessageLog(Builder builder) {
        this.uuid = builder.uuid;
        this.deviceId = builder.deviceId;
        this.userId = builder.userId;
        this.eventId = builder.eventId;
        this.debugKey = builder.debugKey;
        this.pageName = builder.pageName;
        this.systemProperties = builder.systemProperties;
        this.customProperties = builder.customProperties;
        this.idTracking = builder.idTracking;
        this.serverTimestamp = builder.serverTimestamp;
        this.eventTimestamp = builder.eventTimestamp;
    }

    public static class Builder {
        private String uuid;
        private String deviceId;
        private String userId;
        private String eventId;
        private String pageName;
        private String debugKey;
        private Map<String, Object> systemProperties;
        private Map<String, Object> customProperties;
        private Map<String, String> idTracking;
        private Long serverTimestamp;
        private Long eventTimestamp;

        public Builder() {
        }

        public Builder eventTimestamp(Long eventTimestamp) {
            this.eventTimestamp = eventTimestamp;
            return this;
        }

        public Builder serverTimestamp(Long serverTimestamp) {
            this.serverTimestamp = serverTimestamp;
            return this;
        }

        public Builder idTracking(Map<String, String> idTracking) {
            this.idTracking = idTracking;
            return this;
        }

        public Builder customProperty(Map<String, Object> customProperty) {
            this.customProperties = customProperty;
            return this;
        }

        public Builder systemProperty(Map<String, Object> systemProperty) {
            this.systemProperties = systemProperty;
            return this;
        }

        public Builder debugKey(String debugKey) {
            this.debugKey = debugKey;
            return this;
        }

        public Builder pageName(String pageName) {
            this.pageName = pageName;
            return this;
        }

        public Builder eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public NrMessageLog build() {
            return new NrMessageLog(this);
        }
    }

    public QtLog toQtLog() {
        QtLog qtLog = new QtLog.Builder()
                .idTracking(this.idTracking)
                .deviceId(this.deviceId)
                .userId(this.userId)
                .eventId(this.eventId)
                .pageName(this.pageName)
                .debugKey(this.debugKey)
                .systemProperty(this.systemProperties)
                .customProperty(this.customProperties)
                .serverTimestamp(this.serverTimestamp)
                .eventTimestamp(this.eventTimestamp)
                .uuid(this.uuid)
                .build();
        return qtLog;
    }
}
