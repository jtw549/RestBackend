package com.commerce.app.COMMERCE_WebService.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.commerce.app.COMMERCE_WebService.rest.controller"})
public class MvcConfig {}

