package ch.ilge.ivy.webContext.domain.role;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class RoleController {

	private RoleService roleService;
	
	private RoleMapper roleMapper;
	
	/**
	 * 
	 * @param roleService
	 */
	@Autowired
	public RoleController(RoleService roleService, RoleMapper roleMapper) {
		this.roleService = roleService;
		this.roleMapper = roleMapper;
	}
	
	/**
	 * This method returns the requested role
	 *
	 * @param  id Id of the requested role
	 * @return    ResponseEntity with the role that was requested
	 */
	@ApiOperation(
		value = "This endpoint returns the requested role",
		response = Role.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested role",
			required = true
		) }
	)
	@GetMapping("/{id}")
	public ResponseEntity<RoleDTO> getById(@PathVariable Long id) {
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
		response = Role.class
	)
	@GetMapping({ "", "/" })
	public ResponseEntity<List<RoleDTO>> getAll() {
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
		response = Role.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
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
		response = Role.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The logged in role",
			required = true
		) }
	)
	@PutMapping("/{id}")
	public ResponseEntity<RoleDTO> updateById(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
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
		response = Role.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
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
