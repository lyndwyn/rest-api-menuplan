package ch.ilge.ivy.webContext.domain.menuplan;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import ch.ilge.ivy.webContext.domain.menu.Menu;
import ch.ilge.ivy.webContext.domain.menu.MenuService;
import ch.ilge.ivy.webContext.domain.menuplan.dto.MenuplanDTO;
import ch.ilge.ivy.webContext.domain.menuplan.dto.MenuplanMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity menuplan.
 * 
 * @author Laura Steiner
 *
 */
@RestController
@RequestMapping("/menuplans")
@Api(
		value = "Menuplan Controller",
		description = "This class holds all REST endpoints targeted towards the entity menuplans",
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
public class MenuplanController {

	private MenuplanService menuplanService;
	
	private MenuService menuService;
	
	private MenuplanMapper menuplanMapper;
	
	private GenericValidator genericValidator;
	
	/**
	 * 
	 */
	public MenuplanController() {}
	
	/**
	 * 
	 * @param menuplanService
	 * @param menuplanMapper
	 * @param genericValidator
	 */
	@Autowired
	public MenuplanController(MenuplanService menuplanService, MenuService menuService, MenuplanMapper menuplanMapper, GenericValidator genericValidator) {
		this.menuplanService = menuplanService;
		this.menuService = menuService;
		this.menuplanMapper = menuplanMapper;
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
	 * This method returns the requested menuplan
	 *
	 * @param  id Id of the requested menuplan
	 * @return    ResponseEntity with the menuplan that was requested
	 */
	@ApiOperation(
	value = "This endpoint returns the requested menuplan",
	response = MenuplanDTO.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Id of requested menuplan",
			required = true
		) }
	)
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<MenuplanDTO> getById(@PathVariable long id) {
		Menuplan menuplan = menuplanService.findById(id).get();
		return new ResponseEntity<>(menuplanMapper.toDTO(menuplan), HttpStatus.OK);
	}
	
	/**
	 * This method returns all menuplans
	 * 
	 * @return
	 */
	@ApiOperation(
		value = "This endpoint returns all menuplans",
		response = MenuplanDTO.class
	)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<Iterable<MenuplanDTO>> getAll() {
		List<Menuplan> menuplans = menuplanService.findAll();
		return new ResponseEntity<>(menuplanMapper.toDTOs(menuplans), HttpStatus.OK);
	}
	
	/**
	 * This method creates an menuplan
	 *
	 * @return ResponseEntity with the menuplan that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an menuplan",
		response = MenuplanDTO.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
				name = "menuplan",
			value = "The menuplan to be created",
			required = true
		) }
	)
	@PostMapping({ "", "/" })
	public ResponseEntity<MenuplanDTO> create(@Valid @RequestBody MenuplanDTO menuplanDTO) {
		// ensure menuplanID is null
		menuplanDTO.setId(null);
		
		// save menuplan
		Menuplan menuplan = menuplanMapper.fromDTO(menuplanDTO);
		menuplanService.save(menuplan);
		return new ResponseEntity<>(menuplanMapper.toDTO(menuplan), HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested menuplan
	 *
	 * @param  id   Id of the menuplan that should get updated
	 * @param  menuplan menuplan entity to which the requested menuplan should get updated to
	 * @return      ResponseEntity with the updated menuplan
	 */
	@ApiOperation(
		value = "This endpoint updates the requested menuplan",
		response = Void.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "menuplan",
			value = "The logged in menuplan",
			required = true
		) }
	)
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('EDIT')")
	public @ResponseBody ResponseEntity<MenuplanDTO> updateById(@PathVariable Long id, @Valid @RequestBody MenuplanDTO menuplanDTO) {
		// ensure menuplanID's are the same
		menuplanDTO.setId(id);
		
		// update entity
		Menuplan menuplan = menuplanMapper.fromDTO(menuplanDTO);
		menuplanService.update(menuplan);
		return new ResponseEntity<>(menuplanMapper.toDTO(menuplan), HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested menuplan
	 *
	 * @param  id Id of the menuplan that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested menuplan",
		response = Void.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			name = "id",
			value = "Id of requested menuplan",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('EDIT')")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		menuplanService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * This method returns a generated menuplan with no orders
	 * 
	 * @return A generated menuplan
	 */
	@ApiOperation(
		value = "This endpoint returns a generated menuplan",
		response = MenuplanDTO.class
	)
	@GetMapping({ "/generate"})
	@PreAuthorize("hasAuthority('EDIT')")
	public @ResponseBody ResponseEntity<MenuplanDTO> generateMenuplan() {
		
		// Get random Menus (from each type five)
		Set<Menu> menus = menuService.getRandomMenus();
		
		// Set current calendar week and menuplan
		Calendar cal = Calendar.getInstance();
	    Date date=cal.getTime();
		cal.setTime(date);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		
		Menuplan menuplan = new Menuplan(week, menus, null) ;
		
		// save generated menuplan
		menuplanService.save(menuplan);
		
		return new ResponseEntity<>(menuplanMapper.toDTO(menuplan), HttpStatus.CREATED);
	}
	
}
