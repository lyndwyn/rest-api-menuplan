package ch.ilge.ivy.webContext.domain.menuplan.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.ilge.ivy.webContext.domain.menuplan.Menuplan;


/**
 * TODO commis
 * @author Laura Steiner
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface MenuplanMapper {
	
	Menuplan fromDTO(MenuplanDTO menuplanDTO);
	
	MenuplanDTO toDTO(Menuplan menuplan);

	List<Menuplan> fromDTOs(List<MenuplanDTO> menuplanDTOs);
	
	List<MenuplanDTO> toDTOs(List<Menuplan> menuplans);
	
	Set<Menuplan> fromDTOs(Set<MenuplanDTO> menuplanDTOs);
	
	Set<MenuplanDTO> toDTOs(Set<Menuplan> menuplans);
	
}