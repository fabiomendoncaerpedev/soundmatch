package br.com.soundmatch;

import br.com.soundmatch.main.Main;
import br.com.soundmatch.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoundmatchApplication implements CommandLineRunner {
	@Autowired
	private ArtistRepository artistRepo;

	public static void main(String[] args) {
		SpringApplication.run(SoundmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(this.artistRepo);

		main.showMenu();
	}
}
