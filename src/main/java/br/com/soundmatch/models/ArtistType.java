package br.com.soundmatch.models;

public enum ArtistType {
    SOLO("solo"),
    DOUBLE("dupla"),
    BAND("banda");

    private String artistTypeInPortuguese;

    ArtistType(String artistTypeInPortuguese) {
        this.artistTypeInPortuguese = artistTypeInPortuguese;
    }

    public static ArtistType fromPortuguese(String searchedText) {
        for (ArtistType artistType: ArtistType.values()) {
            if (artistType.artistTypeInPortuguese.equalsIgnoreCase(searchedText)) {
                return artistType;
            }
        }

        throw new IllegalArgumentException("No Artists of the specified type were found");
    }
}
