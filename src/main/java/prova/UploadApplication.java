package prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UploadApplication{

	@GetMapping("/")
	public String ciao() {
		return "Belli de casa";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UploadApplication.class, args);
	}

}
