package edu.uoc.elc.tsugi.security.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Xavi Aracil <xaracil@uoc.edu>
 */
@Configuration
@ComponentScan(basePackages = { "edu.uoc.elc.tsugi.security.example.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		super.addViewControllers(registry);
	}
}
