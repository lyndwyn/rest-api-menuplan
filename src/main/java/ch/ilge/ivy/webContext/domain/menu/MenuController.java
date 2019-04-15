package ch.ilge.ivy.webContext.domain.menu;

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
import ch.ilge.ivy.webContext.domain.menu.dto.MenuDTO;
import ch.ilge.ivy.webContext.domain.menu.dto.MenuMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity menu.
 * 
 * @author Laura Steiner
 *
 */
@RestController
@RequestMapping("/menus")
@Api(
		value = "Menu Controller",
		description = "This class holds all REST endpoints targeted towards the entity menus",
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
@PreAuthorize("hasAuthority('EDIT')")
public class MenuController {

	private MenuService menuService;
	
	private MenuMapper menuMapper;
	
	private GenericValidator genericValidator;
	
	/**
	 * 
	 */
	public MenuController() {}
	
	/**
	 * 
	 * @param menuService
	 * @param menuMapper
	 * @param genericValidator
	 */
	@Autowired
	public MenuController(MenuService menuService, MenuMapper menuMapper, GenericValidator genericValidator) {
		this.menuService = menuService;
		this.menuMapper = menuMapper;
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
	 * This method returns the requested menu
	 *
	 * @param  id Id of the requested menu
	 * @return    ResponseEntity with the menu that was requested
	 */
	@ApiOperation(
	value = "This endpoint returns the requested menu",
	response = MenuDTO.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Id of requested menu",
			required = true
		) }
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<MenuDTO> getById(@PathVariable long id) {
		Menu menu = menuService.findById(id).get();
		return new ResponseEntity<>(menuMapper.toDTO(menu), HttpStatus.OK);
	}
	
	/**
	 * This method returns all menus
	 * 
	 * @return
	 */
	@ApiOperation(
		value = "This endpoint returns all menus",
		response = MenuDTO.class
	)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<Iterable<MenuDTO>> getAll() {
		List<Menu> menus = menuService.findAll();
		return new ResponseEntity<>(menuMapper.toDTOs(menus), HttpStatus.OK);
	}
	
	/**
	 * This method creates an menu
	 *
	 * @return ResponseEntity with the menu that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an menu",
		response = MenuDTO.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "menu",
			value = "The menu to be created",
			required = true
		) }
	)
	@PostMapping({ "", "/" })
	public ResponseEntity<MenuDTO> create(@Valid @RequestBody MenuDTO menuDTO) {
		// ensure menuID is null
		menuDTO.setId(null);
		
		// save menu
		Menu menu = menuMapper.fromDTO(menuDTO);
		menuService.save(menu);
		return new ResponseEntity<>(menuMapper.toDTO(menu), HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested menu
	 *
	 * @param  id   Id of the menu that should get updated
	 * @param  menu menu entity to which the requested menu should get updated to
	 * @return      ResponseEntity with the updated menu
	 */
	@ApiOperation(
		value = "This endpoint updates the requested menu",
		response = Void.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "menu",
			value = "The logged in menu",
			required = true
		) }
	)
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<MenuDTO> updateById(@PathVariable Long id, @Valid @RequestBody MenuDTO menuDTO) {
		// ensure menuID's are the same
		menuDTO.setId(id);
		
		// update entity
		Menu menu = menuMapper.fromDTO(menuDTO);
		menuService.update(menu);
		return new ResponseEntity<>(menuMapper.toDTO(menu), HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested menu
	 *
	 * @param  id Id of the menu that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested menu",
		response = Void.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Id of requested menu",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		menuService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
