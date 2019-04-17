package ch.ilge.ivy.webContext.domain.order;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.ilge.ivy.config.validation.GenericValidator;
import ch.ilge.ivy.webContext.domain.order.dto.OrderDTO;
import ch.ilge.ivy.webContext.domain.order.dto.OrderMapper;
import ch.ilge.ivy.webContext.domain.user.User;
import ch.ilge.ivy.webContext.domain.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity order.
 * 
 * @author Laura Steiner
 *
 */
@RestController
@RequestMapping("/orders")
@Api(
		value = "Order Controller",
		description = "This class holds all REST endpoints targeted towards the entity orders",
		authorizations = {
				@Authorization(
					value = "predefined authorization scheme",
					scopes = {
							@AuthorizationScope(
								description = "description",
								scope = "predeclared scope"
							) }
				) }
	)
@PreAuthorize("hasAuthority('READ')")
public class OrderController {

	private OrderService orderService;
	
	private UserService userService;
	
	private OrderMapper orderMapper;
	
	private GenericValidator genericValidator;
	
	/**
	 * 
	 */
	public OrderController() {}
	
	/**
	 * 
	 * @param orderService
	 * @param orderMapper
	 * @param genericValidator
	 */
	@Autowired
	public OrderController(OrderService orderService, UserService userService, OrderMapper orderMapper, GenericValidator genericValidator) {
		this.orderService = orderService;
		this.userService = userService;
		this.orderMapper = orderMapper;
		this.genericValidator = genericValidator;
	}
	
	/**
	 * This method handles the Validation
	 *
	 * @param dataBinder DataBinder binds data from the web request parameters to
	 *                       JavaBean objects
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringtrimmer);
		
		dataBinder.addValidators(genericValidator);
	}

	/**
	 * This method returns the requested order
	 *
	 * @param  id Id of the requested order
	 * @return    ResponseEntity with the order that was requested
	 */
	@ApiOperation(
	value = "This endpoint returns the requested order",
	response = OrderDTO.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Id of requested order",
			required = true
		) }
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<OrderDTO> getById(@PathVariable long id) {
		Orders order = orderService.findById(id).get();
		return new ResponseEntity<>(orderMapper.toDTO(order), HttpStatus.OK);
	}
	
	/**
	 * This method returns all orders
	 * 
	 * @return
	 */
	@ApiOperation(
		value = "This endpoint returns all orders",
		response = OrderDTO.class
	)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<Iterable<OrderDTO>> getAll() {
		List<Orders> orders = orderService.findAll();
		
		return new ResponseEntity<>(orderMapper.toDTOs(orders), HttpStatus.OK);
	}
	
	/**
	 * This method creates an order
	 *
	 * @return ResponseEntity with the order that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an order",
		response = Orders.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "orders",
			value = "The order to be created",
			required = true
		) }
	)
	@PostMapping({ "", "/" })
	public ResponseEntity<OrderDTO> create(@Valid @RequestBody OrderDTO orderDTO) {
		User currentUser = userService.getPrincipal();
		
		if (!orderService.userHasOrderThisWeek(currentUser)) {
			// ensure orderID is null
			orderDTO.setId(null);
			
			// save order
			Orders order = orderMapper.fromDTO(orderDTO);
			orderService.save(order);
			orderService.assignCurrentUser(order);
			
			return new ResponseEntity<>(orderMapper.toDTO(order), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * This method updates the requested order
	 *
	 * @param  id   Id of the order that should get updated
	 * @param  order order entity to which the requested order should get updated to
	 * @return      ResponseEntity with the updated order
	 */
	@ApiOperation(
		value = "This endpoint updates the requested order",
		response = Orders.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
				name = "orders",
			value = "The logged in order",
			required = true
		) }
	)
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('EDIT')")
	public @ResponseBody ResponseEntity<OrderDTO> updateById(@PathVariable Long id, @Valid @RequestBody OrderDTO orderDTO) {
		// ensure orderID's are the same
		orderDTO.setId(id);
		
		// update entity
		Orders order = orderMapper.fromDTO(orderDTO);
		orderService.update(order);
		return new ResponseEntity<>(orderMapper.toDTO(order), HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested order
	 *
	 * @param  id Id of the order that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested order",
		response = Orders.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Id of requested order",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('EDIT')")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		orderService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping({ "fun" })
	public ResponseEntity<Void> funnyFunFun() {
		/*
		User user = userService.findByEmail(orderService.tescht());
		
		List<Orders> orders = new ArrayList<>(user.getOrders());
		List<Long> orderIds = new ArrayList<>();
		
		for(int i = 0; i < orders.size(); i++) {
			orderIds.add(orders.get(i).getId());
		}
		
		Boolean b = orderService.hasOrderThisWeek(orderIds);
		
		System.out.println("+++HERE answer: "+ b.toString());
		*/
		
		return new ResponseEntity<>( HttpStatus.OK);
	}

}
