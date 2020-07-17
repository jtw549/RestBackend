package com.sthuf.app.STHUF_WebService.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sthuf.app.STHUF_WebService.rest.controller"})
public class MvcConfig {}

