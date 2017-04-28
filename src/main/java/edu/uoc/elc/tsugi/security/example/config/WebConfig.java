package edu.uoc.elc.tsugi.security.example.config;

import edu.uoc.elc.tsugi.security.PreAuthenticatedProcessingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.util.Set;
import java.util.TreeSet;

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

	/*
	@Bean(name="templateEngine")
	SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();

		Set<IDialect> additionalDialects = new TreeSet<>();
		additionalDialects.add(new SpringSecurityDia)
		templateEngine.setAdditionalDialects(additionalDialects);
		return templateEngine;
	}*/
}
