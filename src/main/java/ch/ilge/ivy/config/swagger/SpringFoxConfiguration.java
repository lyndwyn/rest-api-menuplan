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
		return new ApiInfoBuilder().title("Ivy - REST API Menuplan").description("<h4>Ivy - The Menuplan REST API</h4>"
				+ "Die Stiftung Ilgenhalde ist eine Institution fuer Menschen mit geistiger und mehrfacher Behinderung mit Sitz in Zuerich. <br />"
				+ "Sie bietet Betreuung und temporaere Wohnmoeglichkeiten fuer Kinder und Jugendliche. Die interne Kantine versorgt taeglich <br />"
				+ "mehrere Wohngruppen, Mitarbeiter und externe Personen. Die Ausschreibung der Menues sowie die Kommunikation spezifischer <br />"
				+ "Wuensche (Mengenangaben, Vegetarisch) seitens Wohngruppen und internen Mitarbeiter, erfolgt gegenwaertig auf physischem Wege. <br />"
				+ "Die Stiftung wuenscht nun eine gewisse Entlastung des gastronomische Personals in ihrer taeglichen Planung. <br />"
				+ "Im Rahmen dieser PA wird die Kandidatin einen Teil dieser Aufgabenstellung uebernehmen.<br />")
				.termsOfServiceUrl("").contact(new Contact("Noser Young", "https://www.noseryoung.ch/", "laura.steiner@nyp.ch")).license("")
				.licenseUrl("").version("1.0").build();
	}
	
}