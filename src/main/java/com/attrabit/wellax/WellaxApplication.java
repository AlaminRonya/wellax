package com.attrabit.wellax;

import com.attrabit.wellax.jwt_token.dto.RegisterRequest;
import com.attrabit.wellax.jwt_token.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.attrabit.wellax.jwt_token.model.Role.*;

@SpringBootApplication
public class WellaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WellaxApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var subAdmin = RegisterRequest.builder()
					.firstname("Sub Admin")
					.lastname("Sub Admin")
					.email("sub.admin@mail.com")
					.password("password")
					.role(SUB_ADMIN)
					.build();
			System.out.println("Sub Admin token: " + service.register(subAdmin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Manager")
					.lastname("Manager")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

			var user = RegisterRequest.builder()
					.firstname("User")
					.lastname("User")
					.email("user@mail.com")
					.password("password")
					.role(USER)
					.build();
			System.out.println("User token: " + service.register(user).getAccessToken());

			var doctor = RegisterRequest.builder()
					.firstname("Doctor")
					.lastname("Doctor")
					.email("doctor@mail.com")
					.password("password")
					.role(DOCTOR)
					.build();
			System.out.println("Doctor token: " + service.register(doctor).getAccessToken());

			var patient = RegisterRequest.builder()
					.firstname("Patient")
					.lastname("Patient")
					.email("patient@mail.com")
					.password("password")
					.role(PATIENT)
					.build();
			System.out.println("Patient token: " + service.register(patient).getAccessToken());

		};
	}

}
