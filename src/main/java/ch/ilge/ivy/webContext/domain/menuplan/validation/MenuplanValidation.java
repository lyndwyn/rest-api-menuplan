package ch.ilge.ivy.webContext.domain.menuplan.validation;

import java.io.IOException;

import org.springframework.validation.Errors;

import ch.ilge.ivy.config.validation.ExtendedValidation;
import ch.ilge.ivy.config.validation.annotation.ValidateField;
import ch.ilge.ivy.config.validation.annotation.Validation;
import ch.ilge.ivy.webContext.domain.menuplan.dto.MenuplanDTO;

/**
 * This class validates the Entity Menuplan.
 *
 * @author Laura Steiner
 */
@Validation(MenuplanDTO.class)
public class MenuplanValidation extends ExtendedValidation {
	
	/**
	 * @throws IOException
	 */
	public MenuplanValidation() throws IOException {
		super();
	}
	
	/**
	 * This method validates the calendar_week-field. It checks if the calendar_week is 
	 * between 0-52 and if its empty or has whitespace.
	 * 
	 * @param errors  error Stores and exposes information about data-binding and
	 *                   validation
	 *                   errors for a specific object.
	 * @param field  Field which gets validated.
	 * @param value  Value of the field which gets validated.
	 * @return       boolean If validation is successful or not.
	 */
	@ValidateField("calendarWeek")
	public void calendarWeek(Errors errors, String field, Integer value) {
		if (value < 0 || value > 52) {
			errors.rejectValue(field, messageReader.getStringProperty("menuplan-calendar-week"));
		}
	}
	
}
