package com.Employee.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.domain.AuditorAware;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration

@EnableJpaAuditing

public class JpaConfig {

@Bean

public AuditorAware<String> auditorProvider() {

// Replace with actual user context logic

return () -> Optional.of("system"); // Replace "system" with logic to fetch the current user

}

}
