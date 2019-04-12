package ch.ilge.ivy.webContext.domain.role.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.ilge.ivy.webContext.domain.role.Role;

/**
 * TODO commis
 * @author Laura Steiner
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface RoleMapper {
	
	Role fromDTO(RoleDTO roleDTO);
	
	RoleDTO toDTO(Role role);

	List<Role> fromDTOs(List<RoleDTO> roleDTOs);
	
	List<RoleDTO> toDTOs(List<Role> roles);
	
	Set<Role> fromDTOs(Set<RoleDTO> roleDTOs);
	
	Set<RoleDTO> toDTOs(Set<Role> roles);
	
}