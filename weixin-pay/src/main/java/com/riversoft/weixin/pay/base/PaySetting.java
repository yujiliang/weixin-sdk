package com.riversoft.weixin.pay.base;

import com.riversoft.weixin.common.exception.WxRuntimeException;
import com.riversoft.weixin.common.util.XmlObjectMapper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 商户信息
 *
 * Created by exizhai on 11/22/2015.
 */
public class PaySetting {

    private static Logger logger = LoggerFactory.getLogger(PaySetting.class);

    private static PaySetting defaultPaySetting = null;

    private static Map<String, PaySetting> paySettingMap = new HashMap<>();

    private static String[] defaultClasspathFile = new String[]{"wx-pay-settings-test.xml", "wx-pay-settings.xml"};

    public static void setDefault(PaySetting paySetting) {
        PaySetting.defaultPaySetting = paySetting;
    }

    public static PaySetting defaultSetting() {
        if (defaultPaySetting == null) {
            loadFromSystemProperties();
        }

        for (String aDefaultClasspathFile : defaultClasspathFile) {
            defaultPaySetting = paySettingMap.get(aDefaultClasspathFile);
            if (defaultPaySetting == null) {
                loadFromClasspath(aDefaultClasspathFile);
                defaultPaySetting = paySettingMap.get(aDefaultClasspathFile);
            }
            if (defaultPaySetting != null) {
                break;
            }
        }
        if (defaultPaySetting == null) {
            throw new WxRuntimeException(999, "当前系统没有设置缺省的商户信息,请使用setDefault方法或者在classpath下面创建wx-pay-settings.xml文件.");
        }
        return defaultPaySetting;
    }

    public static PaySetting getSetting(String classpathFile) {
        PaySetting paySetting = paySettingMap.get(classpathFile);
        if (paySetting == null) {
            loadFromClasspath(classpathFile);
            paySetting = paySettingMap.get(classpathFile);
        }

        if (paySetting == null) {
            throw new WxRuntimeException(999, "当前系统没有设置商户信息,请在classpath下面创建"+classpathFile+"文件.");
        }
        return paySetting;
    }

    private static void loadFromSystemProperties() {
        if(System.getProperties().contains("payconfig")) {
            logger.info("loading pay configuration from system properties...");
            String xml = System.getProperties().getProperty("payconfig", "");
            logger.info("payconfig: {}", xml);
            if(xml == null || "".equals(xml)) {
                return;
            } else {
                try {
                    PaySetting setting = XmlObjectMapper.defaultMapper().fromXml(xml, PaySetting.class);
                    defaultPaySetting = setting;
                } catch (IOException e) {
                }
            }
        }
    }

    private static void loadFromClasspath(String classpathFile) {
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(classpathFile);
            if (inputStream != null) {
                String xml = IOUtils.toString(inputStream);
                PaySetting setting = XmlObjectMapper.defaultMapper().fromXml(xml, PaySetting.class);
                paySettingMap.put(classpathFile, setting);
            }
        } catch (IOException e) {
            logger.error("read settings from "+classpathFile+" failed:", e);
        }

    }

//    private static void loadFromClasspath() {
//        try {
//            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("wx-pay-settings-test.xml");
//
//            if (inputStream == null) {
//                inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("wx-pay-settings.xml");
//            }
//
//            if (inputStream != null) {
//                String xml = IOUtils.toString(inputStream);
//                PaySetting setting = XmlObjectMapper.defaultMapper().fromXml(xml, PaySetting.class);
//                defaultPaySetting = setting;
//            }
//        } catch (IOException e) {
//            logger.error("read settings from wx-pay-settings-test.xml or wx-pay-settings.xml failed:", e);
//        }
//    }


    /**
     * 商户ID
     */
    private String mchId;

    /**
     * 商户的appId
     */
    private String appId;

    /**
     * 子商户号
     */
    private String subMchId;

    /**
     * 子商户公众账号ID
     */
    private String subAppId;

    /**
     * 秘钥
     */
    private String key;

    /**
     * 证书位置
     */
    private String certPath;

    /**
     * 证书密码
     */
    private String certPassword;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaySetting that = (PaySetting) o;

        if (!mchId.equals(that.mchId)) return false;
        return !(appId != null ? !appId.equals(that.appId) : that.appId != null);

    }

    @Override
    public int hashCode() {
        int result = mchId.hashCode();
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        return result;
    }
}
