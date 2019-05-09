package ch.ilge.ivy.webContext.domain.role;

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
import ch.ilge.ivy.webContext.domain.role.dto.RoleDTO;
import ch.ilge.ivy.webContext.domain.role.dto.RoleMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity role.
 * 
 * @author Laura Steiner
 *
 */
@RestController
@RequestMapping("/roles")
@Api(
		value = "Role Controller",
		description = "This class holds all REST endpoints targeted towards the entity Role",
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
@PreAuthorize("hasAuthority('MASTER')")
public class RoleController {

	private RoleService roleService;
	
	private RoleMapper roleMapper;
	
	private GenericValidator genericValidator;
	
	/**
	 * 
	 * @param roleService
	 * @param roleMapper
	 * @param genericValidator
	 */
	@Autowired
	public RoleController(RoleService roleService, RoleMapper roleMapper, GenericValidator genericValidator) {
		this.roleService = roleService;
		this.roleMapper = roleMapper;
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
	 * This method returns the requested role
	 *
	 * @param  id Id of the requested role
	 * @return    ResponseEntity with the role that was requested
	 */
	@ApiOperation(
		value = "This endpoint returns the requested role",
		response = RoleDTO.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Id of requested role",
			required = true
		) }
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<RoleDTO> getById(@PathVariable Long id) {
		Role role =  roleService.findById(id).get();
		return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.OK);
	}
	
	/**
	 * This method returns all roles
	 * 
	 * @return
	 */
	@ApiOperation(
		value = "This endpoint returns all roles",
		response = RoleDTO.class
	)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<Iterable<RoleDTO>> getAll() {
		List<Role> roles = roleService.findAll();
		return new ResponseEntity<>(roleMapper.toDTOs(roles), HttpStatus.OK);
	}
	
	/**
	 * This method creates an role
	 *
	 * @return ResponseEntity with the role that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an role",
		response = RoleDTO.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "Role",
			value = "The role to be created",
			required = true
		) }
	)
	@PostMapping({ "", "/" })
	public ResponseEntity<RoleDTO> create(@Valid @RequestBody RoleDTO roleDTO) {
		// ensure roleID is null
		roleDTO.setId(null);
		
		// save role
		Role role = roleMapper.fromDTO(roleDTO);
		roleService.save(role);
		return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested role
	 *
	 * @param  id   Id of the role that should get updated
	 * @param  role role entity to which the requested role should get updated to
	 * @return      ResponseEntity with the updated role
	 */
	@ApiOperation(
		value = "This endpoint updates the requested role",
		response = Void.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "Role",
			value = "The logged in role",
			required = true
		) }
	)
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<RoleDTO> updateById(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
		// ensure ID's are the same
		roleDTO.setId(id);
		
		// save role
		Role role = roleMapper.fromDTO(roleDTO);
		roleService.update(role);
		return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested role
	 *
	 * @param  id Id of the role that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested role",
		response = Void.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Id of requested role",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		roleService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
