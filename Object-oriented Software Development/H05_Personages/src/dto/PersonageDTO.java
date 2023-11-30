package dto;

public record PersonageDTO(String naam, String omschrijving, int kracht, int snelheid, int lenigheid)
{
    // naam(), omschrijving(), kracht(), snelheid(), lenigheid()

    // constructor 5 arg.

    public PersonageDTO(String naam, String omschrijving) {

        this(naam, omschrijving, 0, 0, 0);
    }

}
