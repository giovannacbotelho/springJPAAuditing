package botelho.gi.config;

import botelho.gi.audit.AuditorAwareImpl;
import botelho.gi.domain.User;
import botelho.gi.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"botelho.gi.repository"})
@EnableTransactionManagement
@EnableJpaAuditing
public class AppConfig {
	@Bean
	public AuditorAware<User> auditorProvider(@Autowired CurrentUserService currentUserService) {
		return new AuditorAwareImpl(currentUserService);
	}
}
