package botelho.gi.service;

import botelho.gi.domain.User;
import botelho.gi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService {
	private Long currentUserID = 1L;

	private final UserRepository userRepository;

	@Autowired
	public CurrentUserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getCurrentUser() {
		return userRepository.findOne(currentUserID);
	}

	public void setCurrentUserToJohn() {
		currentUserID = 1L;
	}

	public void setCurrentUserToDoe() {
		currentUserID = 2L;
	}
}

