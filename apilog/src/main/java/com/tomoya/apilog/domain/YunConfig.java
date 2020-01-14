package com.tomoya.apilog.domain;
import com.tomoya.apilog.util.YunUtil;

import java.io.Serializable;

public class YunConfig implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String serverUrl;
    private String sysId;
    private String pwd;
    private String alias;
    private String version;
    private String path;
    private String tlCertPath;

    public String getServerUrl()
    {
        return this.serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getSysId() {
        return this.sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
        if ((version == null) || ("".equals(version)))
            this.version = "1.0";
    }

    public String getPath()
    {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTlCertPath() {
        return this.tlCertPath;
    }

    public void setTlCertPath(String tlCertPath) {
        this.tlCertPath = tlCertPath;
    }

    public YunConfig()
    {
    }

    public YunConfig(String serverUrl, String sysId, String pwd, String alias, String version, String path, String tlCertPath) {
        this.serverUrl = serverUrl;
        this.sysId = sysId;
        this.pwd = pwd;
        this.alias = alias;
        this.version = version;
        this.path = path;
        this.tlCertPath = tlCertPath;
    }

    public YunConfig(String serverUrl, String sysId, String pwd, String alias, String version, String path, String tlCertPath, String gwCertPath)
    {
        this.serverUrl = serverUrl;
        this.sysId = sysId;
        this.pwd = pwd;
        this.alias = alias;
        this.version = version;
        this.path = path;
        this.tlCertPath = tlCertPath;
    }

    public void validate() {
        YunUtil.assertNotNull(this.serverUrl, "property serverUrl must be configured");
        YunUtil.assertNotNull(this.sysId, "property sysId must be configured");
        YunUtil.assertNotNull(this.pwd, "property pwd must be configured");
        YunUtil.assertNotNull(this.alias, "property alias must be configured");
        YunUtil.assertNotNull(this.path, "property path must be configured");
        YunUtil.assertNotNull(this.tlCertPath, "property tlCertPath must be configured");
    }
}