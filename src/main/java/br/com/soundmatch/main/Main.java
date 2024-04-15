package br.com.soundmatch.main;

import br.com.soundmatch.models.Artist;
import br.com.soundmatch.models.ArtistType;
import br.com.soundmatch.repository.ArtistRepository;

import java.util.Scanner;

public class Main {
    private Scanner reading = new Scanner(System.in);
    private ArtistRepository artistRepo;

    public Main(ArtistRepository artistRepo) {
        this.artistRepo = artistRepo;
    }

    public void showMenu() {
        String renderedMenu = renderMenu();
        Integer chosenOption = -1;

        while (chosenOption != 0) {
            System.out.println(renderedMenu);
            chosenOption = this.reading.nextInt();

            switch (chosenOption) {
                case 1:
                    registerArtist();
                default:
                    System.out.println("Invalid Option");
            }

        }
    }

    private void registerArtist() {
        Artist artist = new Artist();

        System.out.println("What's artist name: ");
        artist.setName(this.reading.next());
        System.out.println("What's artist type: ");
        artist.setType(ArtistType.fromPortuguese(this.reading.next()));

        this.artistRepo.save(artist);
        System.out.println("Artist inserted successfully!!!");
    }

    private String renderMenu() {
        return """
                ################ SOUNDMATCH ###################
                
                1 - Register Artist
                2 - Register Music
                3 - List Musics
                4 - Search Music by Artists
                
                0 - Exit
                
                """;
    }
}
