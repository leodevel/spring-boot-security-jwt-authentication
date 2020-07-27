package br.com.leodevel.jwtauthentication.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docketBean() {
		
		List<ResponseMessage> defaultErrors = new ArrayList<>();
		
		defaultErrors.add(new ResponseMessageBuilder()
				.code(500)
				.message("Erro 500 - Não identificado")
				.responseModel(new ModelRef("Error"))
				.build());
		
		defaultErrors.add(new ResponseMessageBuilder()
				.code(403)
				.message("Erro 403 - Não autorizado")
				.build());

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.leodevel.aulas.resource")).build()
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, defaultErrors)
				.globalResponseMessage(RequestMethod.POST, defaultErrors)
				.globalResponseMessage(RequestMethod.PUT, defaultErrors)
				.globalResponseMessage(RequestMethod.DELETE, defaultErrors);
		
	}

}