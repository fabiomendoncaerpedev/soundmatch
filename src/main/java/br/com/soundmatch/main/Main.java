package br.com.soundmatch.main;

import java.util.Scanner;

public class Main {
    public void showMenu() {
        Scanner reading = new Scanner(System.in);
        String renderedMenu = renderMenu();
        Integer chosenOption = -1;

        while (chosenOption != 0) {
            System.out.println(renderedMenu);
            chosenOption = reading.nextInt();

            switch (chosenOption) {
                default:
                    System.out.println("Invalid Option");
            }

        }



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
