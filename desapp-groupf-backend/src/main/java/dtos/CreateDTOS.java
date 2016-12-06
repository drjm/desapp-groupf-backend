package dtos;

import java.util.ArrayList;
import java.util.List;

import model.Event;
import model.User;

public class CreateDTOS {

	public static UserDTO createUserDTO(User user) {

		UserDTO userDTO = new UserDTO();

		userDTO.setSurname(user.getSurname());
		userDTO.setProfile(user.getProfile());
		userDTO.setNik(user.getNik());
		userDTO.setName(user.getName());
		userDTO.setMyEvents(CreateDTOS.listEventDTO(user.getMyEvents()));
		userDTO.setMessages(user.getMessages());
		userDTO.setMail(user.getMail());
		userDTO.setListFriends(CreateDTOS.listFriendDTO(user.getListFriends()));
		userDTO.setIdUser(user.getIdUser());
		userDTO.setEventsToattend(CreateDTOS.listEventDTO(user.getEventsToattend()));

		return userDTO;
	}

	public static UserDTO createUserDTOSinEventos(User user) {

		UserDTO userDTO = new UserDTO();

		userDTO.setSurname(user.getSurname());
		userDTO.setProfile(user.getProfile());
		userDTO.setNik(user.getNik());
		userDTO.setName(user.getName());
		userDTO.setMyEvents(null);
		userDTO.setMessages(user.getMessages());
		userDTO.setMail(user.getMail());
		userDTO.setListFriends(CreateDTOS.listFriendDTO(user.getListFriends()));
		userDTO.setIdUser(user.getIdUser());
		userDTO.setEventsToattend(null);

		return userDTO;
	}

	public static List<UserDTO> createUserDtoSinEvent(List<User> users) {

		List<UserDTO> dtos = new ArrayList<UserDTO>();

		for (User u : users) {
			if (u != null)
				dtos.add(CreateDTOS.createUserDTOSinEventos(u));

		}

		return dtos;
	}

	public static UserDTO createFriend(User user) {

		UserDTO userDTO = new UserDTO();
		userDTO.setSurname(user.getSurname());
		userDTO.setProfile(user.getProfile());
		userDTO.setNik(user.getNik());
		userDTO.setName(user.getNik());
		userDTO.setMyEvents(null);
		userDTO.setMessages(user.getMessages());
		userDTO.setMail(user.getMail());
		userDTO.setListFriends(null);
		userDTO.setIdUser(user.getIdUser());
		userDTO.setEventsToattend(null);

		return userDTO;

	}

	public static List<UserDTO> listUserDTO(List<User> users) {
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (User u : users) {
			usersDTO.add(CreateDTOS.createUserDTO(u));
		}

		return usersDTO;
	}

	public static List<UserDTO> listFriendDTO(List<User> users) {
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (User u : users) {
			usersDTO.add(CreateDTOS.createFriend(u));
		}

		return usersDTO;
	}

	public static List<EventDTO> listEventDTO(List<Event> events) {
		List<EventDTO> dtos = new ArrayList<EventDTO>();

		for (Event e : events) {
			if (e != null)
				dtos.add(CreateDTOS.createEventDTO(e));
		}

		return dtos;
	}

	public static EventDTO createEventDTO(Event event) {

		EventDTO dto = new EventDTO();
		dto.setAlone(event.getAlone());
		dto.setCantPerson(event.getCantPerson());
		dto.setDate(event.getDate());
		dto.setDescription(event.getDescription());
		dto.setEndTime(event.getEndTime());
		dto.setIdEvent(event.getIdEvent());
		dto.setIdsSuggestionsRelation(event.getIdsSuggestionsRelation());
		dto.setInGruop(event.getInGruop());
		dto.setInTwosome(event.getInTwosome());
		dto.setPlace(event.getPlace());
		dto.setPrice(event.getPrice());
		dto.setStarTime(event.getStarTime());
		dto.setState(event.getState());
		dto.setTitle(event.getTitle());
		dto.setUsers(CreateDTOS.createUserDtoSinEvent(event.getUsers()));
		dto.setDateString(event.getDateString());

		return dto;

	}

}
