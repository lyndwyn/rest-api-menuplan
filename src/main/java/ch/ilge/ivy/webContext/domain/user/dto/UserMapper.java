package ch.ilge.ivy.webContext.domain.user.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.ilge.ivy.webContext.domain.user.User;

/**
 * This class maps the entity users to dto's and reverse.
 * 
 * @author Laura Steiner
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface UserMapper {
	
	User fromDTO(UserDTO userDTO);
	
	UserDTO toDTO(User users);

	List<User> fromDTOs(List<UserDTO> userDTOs);
	
	List<UserDTO> toDTOs(List<User> users);
	
	Set<User> fromDTOs(Set<UserDTO> userDTOs);
	
	Set<UserDTO> toDTOs(Set<User> users);
	
}
