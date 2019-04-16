package ch.ilge.ivy.webContext.domain.menu.validation;

import java.io.IOException;

import org.springframework.validation.Errors;

import ch.ilge.ivy.config.validation.ExtendedValidation;
import ch.ilge.ivy.config.validation.annotation.ValidateField;
import ch.ilge.ivy.config.validation.annotation.Validation;
import ch.ilge.ivy.webContext.domain.menu.dto.MenuDTO;

/**
 * This class validates the Entity Menu
 *
 * @author Laura Steiner
 */
@Validation(MenuDTO.class)
public class MenuValidation extends ExtendedValidation {
	
	/**
	 * @throws IOException
	 */
	public MenuValidation() throws IOException {
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
		validateStringLength(errors, field, value, 3, 50, "menu-name-length");
		validateAlphanumeric(errors, field, value);
	}
	
	/**
	 * This method validates the type-field. It checks if the type is 
	 * between 0-2 and if its empty or has whitespace.
	 * 
	 * @param errors  error Stores and exposes information about data-binding and
	 *                   validation
	 *                   errors for a specific object.
	 * @param field  Field which gets validated.
	 * @param value  Value of the field which gets validated.
	 * @return       boolean If validation is successful or not.
	 */
	@ValidateField("type")
	public void validateEmploymentLevel(Errors errors, String field, Integer value) {
		if (value < 0 || value > 2) {
			errors.rejectValue(field, messageReader.getStringProperty("menu-type"));
		}
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
	@ValidateField("description")
	public void validateDescription(Errors errors, String field, String value) {
		validateStringLength(errors, field, value, 0, 100, "menu-description-length");
		validateAlphanumeric(errors, field, value);
	}
	
}
