package br.edu.ufape.bcc.projetoweb20201;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class Projetoweb20201Application {

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setViewClass(JstlView.class);
		vr.setSuffix(".jsp");
		return vr;
	}

	public static void main(String[] args) {
		SpringApplication.run(Projetoweb20201Application.class, args);
	}

}
