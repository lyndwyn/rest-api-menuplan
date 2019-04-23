package ch.ilge.ivy.webContext.domain.order.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.ilge.ivy.webContext.domain.order.Orders;



/**
 * This class maps the entity orders to dto's and reverse.
 * 
 * @author Laura Steiner
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface OrderMapper {
	
	Orders fromDTO(OrderDTO orderDTO);
	
	OrderDTO toDTO(Orders order);

	List<Orders> fromDTOs(List<OrderDTO> orderDTOs);
	
	List<OrderDTO> toDTOs(List<Orders> orders);
	
	Set<Orders> fromDTOs(Set<OrderDTO> orderDTOs);
	
	Set<OrderDTO> toDTOs(Set<Orders> orders);
	
}