package br.com.soundmatch.main;

import java.util.Scanner;

public class Main {
    public void showMenu() {
        Scanner reading = new Scanner(System.in);

        System.out.println("""
                ################ SOUNDMATCH ###################
                
                1 - Register Artist
                2 - Register Music
                3 - List Musics
                4 - Search Music by Artists
                
                """);


    }
}
