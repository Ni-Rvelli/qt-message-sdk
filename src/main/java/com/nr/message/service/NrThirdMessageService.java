package com.nr.message.service;

import com.alibaba.lingyang.quick.tracking.qlc.java.sdk.config.QtGlobalPropertiesConfig;
import com.alibaba.lingyang.quick.tracking.qlc.java.sdk.config.QtSdkConfig;
import com.alibaba.lingyang.quick.tracking.qlc.java.sdk.sender.QtLogSenderHelper;
import com.nr.message.constant.MessageConstant;
import com.nr.message.model.NrMessageConfig;
import com.nr.message.model.NrMessageLog;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.Map;

/**
 * @Description: nr第三方消息服务
 * @Author: nirui
 * @Date: 2023/10/19 11:05
 */
public class NrThirdMessageService {

    /**
     * 添加全局属性
     *
     * @param map
     */
    public static void addGlobalProperties(Map<String, Object> map) {
        if (ObjectUtils.isEmpty(map)) {
            return;
        }
        map.forEach((k, v) -> QtGlobalPropertiesConfig.put(k, v));
    }

    /**
     * 删除全局属性
     *
     * @param list
     */
    public static void removeGlobalProperties(List<String> list) {
        if (list == null) {
            return;
        }
        list.removeIf(o -> o.equals(MessageConstant.NR_CLIENT_ID));
        list.stream().forEach(o -> QtGlobalPropertiesConfig.remove(o));
    }

    /**
     * 清空全部全局属性
     */
    public static void clearGlobalProperties() {
        QtGlobalPropertiesConfig.clear();
    }

    /**
     * 获取全部全局属性
     *
     * @return
     */
    public static Map<String, Object> getAllGlobalProperties() {
        return QtGlobalPropertiesConfig.getAll();
    }

    /**
     * 上报日志
     *
     * @param log
     */
    public static void sendLog(NrMessageLog log) {
        QtLogSenderHelper.sendLog(log.toQtLog());
    }

    /**
     * 上报日志（同步）
     *
     * @param log
     */
    public static void syncSendLog(NrMessageLog log) {
        QtLogSenderHelper.syncSendLog(log.toQtLog());
    }

    /**
     * 上报日志（异步）
     *
     * @param log
     */
    public static void asyncSendLog(NrMessageLog log) {
        QtLogSenderHelper.asyncSendLog(log.toQtLog());
    }

    /**
     * 配置初始化
     *
     * @param appKey
     * @param serviceId
     * @param serviceSecret
     * @param qlcEndpoint
     * @param clientId
     * @param isOpenLod
     */
    public static void initConfig(String clientId, String appKey, String serviceId, String serviceSecret,
                                  String qlcEndpoint, Boolean isOpenLod) {
        // sdk初始化
        QtSdkConfig.setAppKey(appKey);
        QtSdkConfig.setServiceId(serviceId);
        QtSdkConfig.setServiceSecret(serviceSecret);
        QtSdkConfig.setQlcEndpoint(qlcEndpoint);
        QtSdkConfig.setOpenLog(isOpenLod);
        // 设置全局属性
        QtGlobalPropertiesConfig.put(MessageConstant.NR_CLIENT_ID, clientId);
    }

    /**
     * 配置初始化
     * @param clientId
     * @param config
     */
    public static void initConfig(String clientId, NrMessageConfig config){
        NrThirdMessageService.initConfig(clientId,config.getAppKey(),config.getServiceId(),
                config.getServiceSecret(),config.getQlcEndpoint(),config.getOpenLod());
    }
}
