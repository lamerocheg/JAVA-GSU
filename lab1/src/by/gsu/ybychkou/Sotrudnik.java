package by.gsu.ybychkou;

import java.security.SecureRandom;
import java.util.Scanner;

public class Sotrudnik extends Printable {
    private String         fio;
    private String         doljnost;
    private Integer        zarplata;
    private Podkluchenie[] podkluchenia;

    public Sotrudnik() {
        super();
        this.fio = new String[] {"Ivanov Ivan Ivanovich",
                "Petrov Petr Petrovich"}[new SecureRandom().nextInt(2)];
        this.doljnost = new String[] {"Kassir", "Menejer", "Director"}[new SecureRandom()
                .nextInt(3)];
        this.zarplata = new SecureRandom().nextInt(200) + 200;
        this.podkluchenia = new Podkluchenie[5];
        for (int i = 0; i < 5; i++) {
            this.podkluchenia[i] = new Podkluchenie();
        }
    }

    public Sotrudnik(final String fio, final String doljnost, final Integer zarplata,
            final Podkluchenie[] pokl) {
        super();
        this.fio = fio;
        this.doljnost = doljnost;
        this.zarplata = zarplata;
        this.podkluchenia = pokl;
    }

    public static Sotrudnik getInstanceFromConsole() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("VVOD SOTRUDNIKA :\n Vvedite fio: ");
        final String fio = scanner.nextLine();
        System.out.print(" Vvedite doljnost: ");
        final String dolj = scanner.nextLine();
        System.out.print(" Vvedite zarplatu: ");
        final Integer zarpl = scanner.nextInt();
        System.out.print(" Vvedite kollichestvo podklucheniy: ");
        final Integer kolPodkl = scanner.nextInt();
        final Podkluchenie[] podkl = new Podkluchenie[kolPodkl >= 0 ? kolPodkl : 5];
        for (Podkluchenie pod : podkl) {
            pod = kolPodkl > 0 ? Podkluchenie.getInstanceFromConsole() : new Podkluchenie();
        }
        return new Sotrudnik(fio, dolj, zarpl, podkl);
    }

    public static Sotrudnik getInstanceFromFile(final Scanner scanner) {
        final String fio = scanner.nextLine();
        final String dolj = scanner.nextLine();
        final Integer zarpl = scanner.nextInt();
        final Integer kolPodkl = scanner.nextInt();
        final Podkluchenie[] podkl = new Podkluchenie[kolPodkl >= 0 ? kolPodkl : 5];
        for (Podkluchenie pod : podkl) {
            pod = kolPodkl > 0 ? Podkluchenie.getInstanceFromFile(scanner) : new Podkluchenie();
        }
        return new Sotrudnik(fio, dolj, zarpl, podkl);

    }

    /**
     * @return the doljnost
     */
    public String getDoljnost() {
        return this.doljnost;
    }

    /**
     * @return the fio
     */
    public String getFio() {
        return this.fio;
    }

    /**
     * @return the podkluchenia
     */
    public Podkluchenie[] getPodkluchenia() {
        return this.podkluchenia;
    }

    /**
     * @return the zarplata
     */
    public Integer getZarplata() {
        return this.zarplata;
    }

    /**
     * @param doljnost
     *            the doljnost to set
     */
    public void setDoljnost(final String doljnost) {
        this.doljnost = doljnost;
    }

    /**
     * @param fio
     *            the fio to set
     */
    public void setFio(final String fio) {
        this.fio = fio;
    }

    /**
     * @param podkluchenia
     *            the podkluchenia to set
     */
    public void setPodkluchenia(final Podkluchenie[] podkluchenia) {
        this.podkluchenia = podkluchenia;
    }

    /**
     * @param zarplata
     *            the zarplata to set
     */
    public void setZarplata(final Integer zarplata) {
        this.zarplata = zarplata;
    }

}
