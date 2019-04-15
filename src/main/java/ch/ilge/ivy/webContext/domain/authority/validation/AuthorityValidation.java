package ch.ilge.ivy.webContext.domain.authority.validation;

import java.io.IOException;

import org.springframework.validation.Errors;

import ch.ilge.ivy.config.validation.ExtendedValidation;
import ch.ilge.ivy.config.validation.annotation.ValidateField;
import ch.ilge.ivy.config.validation.annotation.Validation;
import ch.ilge.ivy.webContext.domain.authority.dto.AuthorityDTO;

/**
 * This class validates the Entity Authority
 *
 * @author Laura Steiner
 */
@Validation(AuthorityDTO.class)
public class AuthorityValidation extends ExtendedValidation {
	
	/**
	 * @throws IOException
	 */
	public AuthorityValidation() throws IOException {
		super();
	}
	
	/**
	 * This method validates the name-field.
	 *
	 * @param  error Stores and exposes information about data-binding and
	 *                   validation
	 *                   errors for a specific object.
	 * @param  field Field which gets validated.
	 * @param  value Value from the field which gets validated.
	 * @return       boolean If validation is successful or not.
	 */
	@ValidateField("name")
	public void validateName(Errors errors, String field, String value) {
		validateStringLength(errors, field, value, 3, 50, "authority-length");
		validateAlphanumeric(errors, field, value);
	}
	
}
