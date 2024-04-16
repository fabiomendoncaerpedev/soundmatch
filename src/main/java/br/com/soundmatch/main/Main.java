package br.com.soundmatch.main;

import br.com.soundmatch.exceptions.NotFoundException;
import br.com.soundmatch.models.Artist;
import br.com.soundmatch.models.ArtistType;
import br.com.soundmatch.models.Music;
import br.com.soundmatch.repository.ArtistRepository;
import br.com.soundmatch.repository.MusicRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner reading = new Scanner(System.in);
    private final ArtistRepository artistRepo;
    private final MusicRepository musicRepo;

    public Main(ArtistRepository artistRepo, MusicRepository musicRepo) {
        this.artistRepo = artistRepo;
        this.musicRepo = musicRepo;
    }

    public void showMenu() {
        String renderedMenu = renderMenu();
        int chosenOption = -1;

        while (chosenOption != 0) {
            System.out.println(renderedMenu);
            chosenOption = this.reading.nextInt();

            switch (chosenOption) {
                case 1:
                    registerArtist();
                    break;
                case 2:
                    registerMusic();
                    break;
                case 3:
                    listMusics();
                    break;
                case 4:
                    listMusicsByArtist();
                    break;
                default:
                    System.out.println("Invalid Option");
            }

        }
    }

    private void listMusicsByArtist() {
        List<Music> musicList = new ArrayList<>();

        try {
            Artist artist = this.searchArtist();
            musicList = musicRepo.findByArtist(artist);
            musicList.forEach(System.out::println);
        } catch (NotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void listMusics() {
        List<Music> musicList = musicRepo.findAll();
        musicList.forEach(System.out::println);
    }

    private Artist searchArtist() throws NotFoundException {
        List<Artist> artistList = new ArrayList<>();
        String artistName;

        while (artistList.size() != 1) {
            System.out.println("Enter Artist Name: ");
            artistName = this.reading.next();

            artistList = artistRepo.findByNameContainingIgnoreCase(artistName);

            if (artistList.size() > 1) {
                System.out.println("\nThe following Artists were retrieved by your search parameters:\n");
                artistList.forEach(System.out::println);
                System.out.println("\nPlease be more specific in your search...\n");
            } else if (artistList.isEmpty()) {
                throw new NotFoundException("No artist was found with parameters provided!!!");
            }
        }

        return artistList.get(0);
    }

    private void registerMusic() {
        Music music = new Music();

        try {
            Artist artist = this.searchArtist();
            music.setArtist(artist);

            System.out.println("Enter Music Name: ");
            music.setName(this.reading.next());

            musicRepo.save(music);
            System.out.println("Music inserted successfully!!!");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
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
                4 - List Musics by Artist
                
                0 - Exit
                
                """;
    }
}
