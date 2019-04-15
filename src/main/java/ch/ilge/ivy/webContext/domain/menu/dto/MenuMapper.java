package ch.ilge.ivy.webContext.domain.menu.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.ilge.ivy.webContext.domain.menu.Menu;


/**
 * TODO commis
 * @author Laura Steiner
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface MenuMapper {
	
	Menu fromDTO(MenuDTO menuDTO);
	
	MenuDTO toDTO(Menu menu);

	List<Menu> fromDTOs(List<MenuDTO> menuDTOs);
	
	List<MenuDTO> toDTOs(List<Menu> menus);
	
	Set<Menu> fromDTOs(Set<MenuDTO> menuDTOs);
	
	Set<MenuDTO> toDTOs(Set<Menu> menus);
	
}