package ch.ilge.ivy.webContext.domain.user.validation;

import java.io.IOException;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;

import ch.ilge.ivy.config.validation.ExtendedValidation;
import ch.ilge.ivy.config.validation.annotation.ValidateField;
import ch.ilge.ivy.config.validation.annotation.Validation;
import ch.ilge.ivy.webContext.domain.user.dto.UserDTO;

/**
 * This class validates the Entity Menu
 *
 * @author Laura Steiner
 */
@Validation(UserDTO.class)
public class UserValidation extends ExtendedValidation {
		
	// at least one letter and one number, minimum eight characters
	private static final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]+$");
	
	/**
	 *
	 */
	public UserValidation() throws IOException {
		super();
	}
	
	/**
	 * This method validates the email-field.
	 *
	 * @param  errors Stores and exposes information about data-binding and
	 *                    validation
	 *                    errors for a specific object.
	 * @param  field  Field which gets validated.
	 * @return        boolean If validation is successful or not.
	 */
	@ValidateField("email")
	public void validateUsername(Errors errors, String field, String value) {
		validateStringLength(errors, field, value, 3, 75, "user-email-length");
		validateAlphanumeric(errors, field, value);
	}
	
	/**
	 * This method validates the password-field.
	 *
	 * @param  errors Stores and exposes information about data-binding and
	 *                    validation
	 *                    errors for a specific object.
	 * @param  field  Field which gets validated.
	 * @param  value  Value from the field which gets validated.
	 * @return        boolean If validation is successful or not.
	 */
	@ValidateField("password")
	public void validatePassword(Errors errors, String field, String value) {
		validateRegexMatch(errors, field, value, PASSWORD_REGEX, "user-password-syntax");
		validateStringLength(errors, field, value, 8, 100, "user-password-length");
	}
	
	/**
	 * This method validates the firstName-field.
	 *
	 * @param  errors Stores and exposes information about data-binding and
	 *                    validation
	 *                    errors for a specific object.
	 * @param  field  Field which gets validated.
	 * @param  value  Value from the field which gets validated.
	 * @return        boolean If validation is successful or not.
	 */
	@ValidateField("firstName")
	public void validateFirstName(Errors errors, String field, String value) {
		validateStringLength(errors, field, value, 2, 75, "user-first-name-length");
		validateAlphanumeric(errors, field, value);
	}
	
	/**
	 * This method validates the lastName-field.
	 *
	 * @param  errors Stores and exposes information about data-binding and
	 *                    validation
	 *                    errors for a specific object.
	 * @param  field  Field which gets validated.
	 * @param  value  Value from the field which gets validated.
	 * @return        boolean If validation is successful or not.
	 */
	@ValidateField("lastName")
	public void validateLastName(Errors errors, String field, String value) {
		validateStringLength(errors, field, value, 2, 60, "user-last-name-length");
		validateAlphanumeric(errors, field, value);
	}
	
	/**
	 * This method validates the locked-field. It checks if the locked is 
	 * between 0-1 and if its empty or has whitespace.
	 * 
	 * @param errors  error Stores and exposes information about data-binding and
	 *                   validation
	 *                   errors for a specific object.
	 * @param field  Field which gets validated.
	 * @param value  Value of the field which gets validated.
	 * @return       boolean If validation is successful or not.
	 */
	@ValidateField("locked")
	public void validateLocked(Errors errors, String field, Integer value) {
		if (value < 0 || value > 1) {
			errors.rejectValue(field, messageReader.getStringProperty("user-locked"));
		}
	}
	
	/**
	 * This method validates the enabled-field. It checks if the enabled is 
	 * between 0-1 and if its empty or has whitespace.
	 * 
	 * @param errors  error Stores and exposes information about data-binding and
	 *                   validation
	 *                   errors for a specific object.
	 * @param field  Field which gets validated.
	 * @param value  Value of the field which gets validated.
	 * @return       boolean If validation is successful or not.
	 */
	@ValidateField("enabled")
	public void validateEnabled(Errors errors, String field, Integer value) {
		if (value < 0 || value > 1) {
			errors.rejectValue(field, messageReader.getStringProperty("user-enabled"));
		}
	}
	
	/**
	 * This method validates the livingGroup-field. It checks if the livingGroup is 
	 * between 0-1 and if its empty or has whitespace.
	 * 
	 * @param errors  error Stores and exposes information about data-binding and
	 *                   validation
	 *                   errors for a specific object.
	 * @param field  Field which gets validated.
	 * @param value  Value of the field which gets validated.
	 * @return       boolean If validation is successful or not.
	 */
	@ValidateField("livingGroup")
	public void validateLivingGroup(Errors errors, String field, Integer value) {
		if (value < 0 || value > 1) {
			errors.rejectValue(field, messageReader.getStringProperty("user-livingGroup"));
		}
	}
	
}
