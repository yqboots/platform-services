package com.yqboots.commerce;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {CommerceApplication.class})
@EntityScan(basePackageClasses = {CommerceApplication.class})
@EnableJpaAuditing
@EnableJpaRepositories(basePackageClasses = {CommerceApplication.class})
public class CommerceAutoConfiguration {
}
