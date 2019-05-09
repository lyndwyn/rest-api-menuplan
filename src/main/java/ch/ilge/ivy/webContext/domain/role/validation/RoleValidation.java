package ch.ilge.ivy.webContext.domain.role.validation;

import java.io.IOException;

import org.springframework.validation.Errors;

import ch.ilge.ivy.config.validation.ExtendedValidation;
import ch.ilge.ivy.config.validation.annotation.ValidateField;
import ch.ilge.ivy.config.validation.annotation.Validation;
import ch.ilge.ivy.webContext.domain.role.dto.RoleDTO;

/**
 * This class validates the Entity Role
 *
 * @author Laura Steiner
 */
@Validation(RoleDTO.class)
public class RoleValidation extends ExtendedValidation {
	
	/**
	 * @throws IOException
	 */
	public RoleValidation() throws IOException {
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
		validateStringLength(errors, field, value, 3, 50, "role-length");
		validateAlphanumeric(errors, field, value);
	}
	
}
