package com.Learning.entity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class Hikari {
    private String poolname;
    private String minimumidle;
    private String idletimeout;
    private String maximumpool;
    private String autocommit;
    private String maxlifetime;
    private String connectiontimeout;

    @Override
    public String toString() {
        return "Hikari{" +
                "poolname='" + poolname + '\'' +
                ", minimumidle='" + minimumidle + '\'' +
                ", idletimeout='" + idletimeout + '\'' +
                ", maximumpool='" + maximumpool + '\'' +
                ", autocommit='" + autocommit + '\'' +
                ", maxlifetime='" + maxlifetime + '\'' +
                ", connectiontimeout='" + connectiontimeout + '\'' +
                ", connectiontestquery='" + connectiontestquery + '\'' +
                '}';
    }

    public String getPoolname() {
        return poolname;
    }

    public void setPoolname(String poolname) {
        this.poolname = poolname;
    }

    public String getMinimumidle() {
        return minimumidle;
    }

    public void setMinimumidle(String minimumidle) {
        this.minimumidle = minimumidle;
    }

    public String getIdletimeout() {
        return idletimeout;
    }

    public void setIdletimeout(String idletimeout) {
        this.idletimeout = idletimeout;
    }

    public String getMaximumpool() {
        return maximumpool;
    }

    public void setMaximumpool(String maximumpool) {
        this.maximumpool = maximumpool;
    }

    public String getAutocommit() {
        return autocommit;
    }

    public void setAutocommit(String autocommit) {
        this.autocommit = autocommit;
    }

    public String getMaxlifetime() {
        return maxlifetime;
    }

    public void setMaxlifetime(String maxlifetime) {
        this.maxlifetime = maxlifetime;
    }

    public String getConnectiontimeout() {
        return connectiontimeout;
    }

    public void setConnectiontimeout(String connectiontimeout) {
        this.connectiontimeout = connectiontimeout;
    }

    public String getConnectiontestquery() {
        return connectiontestquery;
    }

    public void setConnectiontestquery(String connectiontestquery) {
        this.connectiontestquery = connectiontestquery;
    }

    private String connectiontestquery;
}
