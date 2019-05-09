package ch.ilge.ivy.webContext.domain.order.validation;

import java.io.IOException;

import org.springframework.validation.Errors;

import ch.ilge.ivy.config.validation.ExtendedValidation;
import ch.ilge.ivy.config.validation.annotation.ValidateField;
import ch.ilge.ivy.config.validation.annotation.Validation;
import ch.ilge.ivy.webContext.domain.order.dto.OrderDTO;

/**
 * This class validates the Entity Orders
 *
 * @author Laura Steiner
 */
@Validation(OrderDTO.class)
public class OrderValidation extends ExtendedValidation {
	
	/**
	 * @throws IOException
	 */
	public OrderValidation() throws IOException {
		super();
	}
	
	/**
	 * This method validates the amountNormal-field. It checks if the amountNormal is 
	 * not under 0 and if its empty or has whitespace.
	 * 
	 * @param errors  error Stores and exposes information about data-binding and
	 *                   validation
	 *                   errors for a specific object.
	 * @param field  Field which gets validated.
	 * @param value  Value of the field which gets validated.
	 * @return       boolean If validation is successful or not.
	 */
	@ValidateField("amountNormal")
	public void validateAmountNormal(Errors errors, String field, Integer value) {
		if (value < 0) {
			errors.rejectValue(field, messageReader.getStringProperty("order-ammount-normal"));
		}
	}
	


	/**
	 * This method validates the amountNopork-field. It checks if the amountNopork is 
	 * not under 0 and if its empty or has whitespace.
	 * 
	 * @param errors  error Stores and exposes information about data-binding and
	 *                   validation
	 *                   errors for a specific object.
	 * @param field  Field which gets validated.
	 * @param value  Value of the field which gets validated.
	 * @return       boolean If validation is successful or not.
	 */
	@ValidateField("amountNopork")
	public void validateAmountVegi(Errors errors, String field, Integer value) {
		if (value < 0) {
			errors.rejectValue(field, messageReader.getStringProperty("order-ammount-nopork"));
		}
	}
	
	/**
	 * This method validates the amountVegi-field. It checks if the amountVegi is 
	 * not under 0 and if its empty or has whitespace.
	 * 
	 * @param errors  error Stores and exposes information about data-binding and
	 *                   validation
	 *                   errors for a specific object.
	 * @param field  Field which gets validated.
	 * @param value  Value of the field which gets validated.
	 * @return       boolean If validation is successful or not.
	 */
	@ValidateField("amountVegi")
	public void validateAmountNoPork(Errors errors, String field, Integer value) {
		if (value < 0) {
			errors.rejectValue(field, messageReader.getStringProperty("order-ammount-vegi"));
		}
	}
	
	/**
	 * This method validates the notice-field.
	 * 
	 * @param  error Stores and exposes information about data-binding and
	 *                   validation
	 *                   errors for a specific object.
	 * @param  field Field which gets validated.
	 * @param  value Value from the field which gets validated.
	 * @return       boolean If validation is successful or not.
	 */
	@ValidateField("notice")
	public void validateDescription(Errors errors, String field, String value) {
		validateStringLength(errors, field, value, 0, 250, "order-notice");
	}
	
}
