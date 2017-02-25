package com.noq.address;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.noq.*"})
@EnableJpaRepositories({"com.noq.*"})
@EntityScan({"com.noq.*"})
@EnableCaching
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();

		Converter<String, String>trimConverter = new Converter<String, String>() {
			@Override
			public String convert(MappingContext<String, String> context) {
				return context.getSource() == null ? null : context.getSource().trim();
			}
		};
		mapper.addConverter(trimConverter);
		return mapper;
	}
}
