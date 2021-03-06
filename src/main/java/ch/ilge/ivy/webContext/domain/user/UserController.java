package ch.ilge.ivy.webContext.domain.user;

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
import ch.ilge.ivy.webContext.domain.user.dto.UserDTO;
import ch.ilge.ivy.webContext.domain.user.dto.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity user.
 * 
 * @author Laura Steiner
 *
 */
@RestController
@RequestMapping("/users")
@Api(
		value = "UserController",
		description = "This class holds all REST endpoints targeted towards the entity user",
		authorizations = { @Authorization(
			value = "predefined authorization scheme",
			scopes = {
					@AuthorizationScope(
						description = "description",
						scope = "predeclared scope"
					) }
		) }
	)
@PreAuthorize("hasAuthority('MASTER')")
public class UserController {
	
	private UserService userService;
	
	private UserMapper userMapper;
	
	private GenericValidator genericValidator;
	
	/**
	 * 
	 */
	public UserController() {
		
	}
	
	/**
	 * @param userService
	 */
	@Autowired
	public UserController(UserService userService, UserMapper userMapper, GenericValidator genericValidator) {
		this.userService = userService;
		this.userMapper = userMapper;
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
	 * This method returns the requested user
	 * 
	 * @param id	Id of the requested user
	 * @return		ResponseEntity with the user that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested user",
			response = UserDTO.class
	)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(
					name = "id",
					value = "Id of requested user",
					required = true
				)}
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<UserDTO> getById(@PathVariable Long id) {
		User user = userService.findById(id).get();
		return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
	}
	
	/**
	 * This method returns all users
	 * 
	 * @return		ResponseEntity with all exsisting users
	 */
	@ApiOperation(
			value = "This endpoint returns all users",
			response = UserDTO.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<UserDTO>> getAll() {
		List<User> users = userService.findAll();
		return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
	}
	
	/**
	 * This method creates an user
	 * 
	 * @return		ResponseEntity with the user that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an user",
		response = UserDTO.class
	)
	@ApiImplicitParams(
			{ @ApiImplicitParam(
				name = "user",
				value = "The user to be created",
				required = true
			)}
	)
	@PostMapping({"", "/"})
	public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDTO) {
		// ensure userID is null
		userDTO.setId(null);
		
		// save user
		User user = userMapper.fromDTO(userDTO);
		userService.save(user);
		return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param id	Id from the user which will get updated
	 * @param user	Updated user
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint updates the requested user",
			response = Void.class
		)
		@ApiImplicitParams(
				{ @ApiImplicitParam(
					name = "user",
					value = "The logged in user",
					required = true
				) }
			)
		@PutMapping("/{id}")
		public @ResponseBody ResponseEntity<UserDTO> updateById(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
		// ensure ID's are the same
		userDTO.setId(id);
		
		// update entity
		User user = userMapper.fromDTO(userDTO);
		userService.update(user);
		return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
		}
	
	/**
	 * This method deletes the requested user
	 *
	 * @param  id Id of the user that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested user",
		response = Void.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Id of requested user",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
