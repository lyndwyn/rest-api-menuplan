package ch.ilge.ivy.webContext.domain.authority;

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
import ch.ilge.ivy.webContext.domain.authority.dto.AuthorityDTO;
import ch.ilge.ivy.webContext.domain.authority.dto.AuthorityMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity authority.
 * 
 * @author Laura Steiner
 *
 */
@RestController
@RequestMapping("/authorities")
@Api(
		value = "Authority Controller",
		description = "This class holds all REST endpoints targeted towards the entity authority",
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
public class AuthorityController {

	private AuthorityService authorityService;
	
	private AuthorityMapper authorityMapper;
	
	private GenericValidator genericValidator;
	
	/**
	 * 
	 */
	public AuthorityController() {}
	
	
	/**
	 * 
	 * @param authorityService
	 * @param authorityMapper
	 * @param genericValidator
	 */
	@Autowired
	public AuthorityController(
			AuthorityService authorityService, AuthorityMapper authorityMapper, GenericValidator genericValidator) {
		super();
		this.authorityService = authorityService;
		this.authorityMapper = authorityMapper;
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
	 * This method returns the requested authority
	 *
	 * @param  id Id of the requested authority
	 * @return    ResponseEntity with the authority that was requested
	 */
	@ApiOperation(
	value = "This endpoint returns the requested authority",
	response = AuthorityDTO.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Authority ID",
			required = true
		) }
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<AuthorityDTO> getById(@PathVariable long id) {
		Authority authority = authorityService.findById(id).get();
		return new ResponseEntity<>(authorityMapper.toDTO(authority), HttpStatus.OK);
	}
	
	/**
	 * This method returns all authorities
	 * 
	 * @return
	 */
	@ApiOperation(
		value = "This endpoint returns all authorities",
		response = AuthorityDTO.class
	)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<Iterable<AuthorityDTO>> getAll() {
		List<Authority> authorities = authorityService.findAll();
		return new ResponseEntity<>(authorityMapper.toDTOs(authorities), HttpStatus.OK);
	}
	
	/**
	 * This method creates an authority
	 *
	 * @return ResponseEntity with the authority that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an authority",
		response = AuthorityDTO.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "authority",
			value = "Authority Object",
			required = true
		) }
	)
	@PostMapping({ "", "/" })
	public ResponseEntity<AuthorityDTO> create(@Valid @RequestBody AuthorityDTO authorityDTO) {
		// ensure authorityID is null
		authorityDTO.setId(null);
		
		// save authority
		Authority authority = authorityMapper.fromDTO(authorityDTO);
		authorityService.save(authority);
		return new ResponseEntity<>(authorityMapper.toDTO(authority), HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested authority
	 *
	 * @param  id   Id of the authority that should get updated
	 * @param  authority authority entity to which the requested authority should get updated to
	 * @return      ResponseEntity with the updated authority
	 */
	@ApiOperation(
		value = "This endpoint updates the requested authority",
		response = Void.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "authority",
			value = "Authority Object",
			required = true
		) }
	)
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<AuthorityDTO> updateById(@PathVariable Long id, @Valid @RequestBody AuthorityDTO authorityDTO) {
		// ensure authorityID's are the same
		authorityDTO.setId(id);
		
		// update entity
		Authority authority = authorityMapper.fromDTO(authorityDTO);
		authorityService.update(authority);
		return new ResponseEntity<>(authorityMapper.toDTO(authority), HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested authority
	 *
	 * @param  id Id of the authority that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested authority",
		response = Void.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Authority ID",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		authorityService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
