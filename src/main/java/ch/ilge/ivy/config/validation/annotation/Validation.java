package ch.ilge.ivy.config.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/** 
 * This annotation is used for map a validation-class to its entity-class.
 * 
 * @author Moritz Lauper
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = Validations.class)
@Component
public @interface Validation {
	/**
	 * The entity class this Validation can validate
	 * @return
	 */
	Class<?> value();
	
	/**
	 * The names of fields to delegate to other Validation classes
	 * @return
	 */
	String[] delegations() default {};
	
}
