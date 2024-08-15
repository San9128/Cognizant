package com.Employee.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration

public class PrimaryDataSourceConfig {

@Value("${spring.datasource.primary.url}")

private String url;

@Value("${spring.datasource.primary.driverClassName}")

private String driverClassName;

@Value("${spring.datasource.primary.username}")

private String username;

@Value("${spring.datasource.primary.password}")

private String password;

@Bean

public DataSource primaryDataSource() {

DriverManagerDataSource dataSource = new DriverManagerDataSource();

dataSource.setDriverClassName(driverClassName);

dataSource.setUrl(url);

dataSource.setUsername(username);

dataSource.setPassword(password);

return dataSource;

}

}