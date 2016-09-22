package by.gsu.ybychkou;

import java.security.SecureRandom;
import java.util.Scanner;

public class Rouming implements Printable {
    private String dateOfStart;
    private String dateOfStop;

    public Rouming() {
        super();
        final SecureRandom rand = new SecureRandom();
        this.dateOfStop = "" + (rand.nextInt(31) + 1) + '.' + (rand.nextInt(12) + 1)
                + (2000 + rand.nextInt(17));
        this.dateOfStart = "" + (rand.nextInt(31) + 1) + '.' + (rand.nextInt(12) + 1)
                + (2000 + rand.nextInt(17));
    }

    public Rouming(final String dateOfStart, final String dateOfStop) {
        super();
        this.dateOfStart = dateOfStart;
        this.dateOfStop = dateOfStop;
    }

    public static Rouming getInstanceFromConsole() {

        final Scanner scanner = new Scanner(System.in);
        System.out.print("VVOD ROUMINGA :\n Vvedite datu nachala: ");
        final String start = scanner.nextLine();
        System.out.print(" Vvedite datu okonchania: ");
        final String stop = scanner.nextLine();
        return new Rouming(start, stop);
    }

    public static Rouming getInstanceFromFile(final Scanner scanner) {
        final String start = scanner.nextLine();
        final String stop = scanner.nextLine();
        return new Rouming(start, stop);

    }

    /**
     * @return the dateOfStart
     */
    public String getDateOfStart() {
        return this.dateOfStart;
    }

    /**
     * @return the dateOfStop
     */
    public String getDateOfStop() {
        return this.dateOfStop;
    }

    @Override
    public void printArrays(final int level) {
    }

    /**
     * @param dateOfStart
     *            the dateOfStart to set
     */
    public void setDateOfStart(final String dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    /**
     * @param dateOfStop
     *            the dateOfStop to set
     */
    public void setDateOfStop(final String dateOfStop) {
        this.dateOfStop = dateOfStop;
    }

}
