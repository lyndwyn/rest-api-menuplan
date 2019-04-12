package ch.ilge.ivy.webContext.domain.authority.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.ilge.ivy.webContext.domain.authority.Authority;

/**
 * TODO commis
 * @author Laura Steiner
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface AuthorityMapper {
	
	Authority fromDTO(AuthorityDTO authorityDTO);
	
	AuthorityDTO toDTO(Authority authority);

	List<Authority> fromDTOs(List<AuthorityDTO> authorityDTOs);
	
	List<AuthorityDTO> toDTOs(List<Authority> authorities);
	
	Set<Authority> fromDTOs(Set<AuthorityDTO> authorityDTOs);
	
	Set<AuthorityDTO> toDTOs(Set<Authority> authorities);
	
}