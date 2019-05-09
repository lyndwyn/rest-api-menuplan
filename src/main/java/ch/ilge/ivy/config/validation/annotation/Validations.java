package ch.ilge.ivy.config.validation.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Moritz Lauper
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
@Component
public @interface Validations {
	Validation[] value();
}
