package ch.ilge.ivy.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class handles the SpringFox/Swagger configuration
 *
 * @author Laura Steiner
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfiguration {
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("ch.ilge.ivy.webContext.domain")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Ivy - REST API Menuplan").description("Ivy - The Menuplan REST API")
				.termsOfServiceUrl("").contact(new Contact("Noser Young", "Lorem Ipsum1", "zuerich@noseryoung.ch")).license("")
				.licenseUrl("").version("1.0").build();
	}
	
}