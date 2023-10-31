package com.nr.message.model;

/**
 * @Description: 消息配置类
 * @Author: nirui
 * @Date: 2023/10/25 13:41
 */
public class NrMessageConfig {
    private String appKey;
    private String serviceId;
    private String serviceSecret;
    private String qlcEndpoint;
    private Boolean isOpenLod = true;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceSecret() {
        return serviceSecret;
    }

    public void setServiceSecret(String serviceSecret) {
        this.serviceSecret = serviceSecret;
    }

    public String getQlcEndpoint() {
        return qlcEndpoint;
    }

    public void setQlcEndpoint(String qlcEndpoint) {
        this.qlcEndpoint = qlcEndpoint;
    }

    public Boolean getOpenLod() {
        return isOpenLod;
    }

    public void setOpenLod(Boolean openLod) {
        isOpenLod = openLod;
    }

    @Override
    public String toString() {
        return "NrMessageConfig{" +
                "appKey='" + appKey + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", serviceSecret='" + serviceSecret + '\'' +
                ", qlcEndpoint='" + qlcEndpoint + '\'' +
                ", isOpenLod=" + isOpenLod +
                '}';
    }
}
