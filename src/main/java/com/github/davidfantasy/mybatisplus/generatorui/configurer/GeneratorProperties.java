package com.github.davidfantasy.mybatisplus.generatorui.configurer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Fly
 * @Date 2025/2/21 下午3:25
 */
@Component
@ConfigurationProperties(prefix = "generator")
public class GeneratorProperties {
    /**
     * @Description: 数据库连接地址
     */
    private String jdbcUrl;

    /**
     * @Description: 数据库用户名
     */
    private String userName;

    /**
     * @Description: 数据库密码
     */
    private String password;

    /**
     * @Description: 数据库端口
     */
    private Integer port;

    /**
     * @Description: 数据库驱动类名
     */
    private String driverClassName;

    /**
     * @Description: 生成代码的包名
     */
    private String basePackage;

    /**
     * @Description: 表名前缀
     */
    private String tablePrefix;


    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }
}
