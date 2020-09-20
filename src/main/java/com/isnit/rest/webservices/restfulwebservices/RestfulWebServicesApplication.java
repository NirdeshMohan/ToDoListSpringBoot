package com.isnit.rest.webservices.restfulwebservices;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
@ComponentScan({"com.isnit.rest.webservices.restfulwebservices*"})
@EntityScan("com.isnit.rest.webservices.restfulwebservices.model*")
@EnableJpaRepositories("com.isnit.rest.webservices.restfulwebservices*")


public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasenames("messages");
		return bundleMessageSource;
	}
	
	@Bean
	  public LinkDiscoverers discoverers(){
	    return new LinkDiscoverers(SimplePluginRegistry.create(Arrays.asList(new CollectionJsonLinkDiscoverer())));
	  }

}
