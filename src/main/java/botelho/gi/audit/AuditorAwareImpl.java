package botelho.gi.audit;

import botelho.gi.domain.User;
import botelho.gi.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<User> {
	private final CurrentUserService currentUserService;

	@Autowired
	public AuditorAwareImpl(final CurrentUserService currentUserService) {
		this.currentUserService = currentUserService;
	}

	@Override
	public User getCurrentAuditor() {
		return currentUserService.getCurrentUser();
	}
}
