package by.gsu.ybychkou;

import java.security.SecureRandom;
import java.util.Scanner;

public class Oplata {
    private String  date;
    private Integer summa;

    public Oplata() {
        super();
        final SecureRandom rand = new SecureRandom();
        this.date = "" + (rand.nextInt(31) + 1) + '.' + (rand.nextInt(12) + 1)
                + (2000 + rand.nextInt(17));
        this.summa = rand.nextInt(10) * 5;
    }

    public Oplata(final String date, final Integer summa) {
        super();
        this.date = date;
        this.summa = summa;
    }

    public static Oplata getInstanceFromConsole() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("VVOD PODKLUCHENIA :\n Vvedite datu: ");
        final String date = scanner.nextLine();
        System.out.print(" Vvedite summu: ");
        final Integer summa = scanner.nextInt();
        return new Oplata(date, summa);
    }

    public static Oplata getInstanceFromFile(final Scanner scanner) {
        final String date = scanner.nextLine();
        final Integer summa = scanner.nextInt();
        return new Oplata(date, summa);
    }

    public static void printHeader() {
    }

    /**
     * @return the date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * @return the summa
     */
    public Integer getSumma() {
        return this.summa;
    }

    public void print() {
        Oplata.printHeader();
        this.printInfo();
    }

    public void printInfo() {
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * @param summa
     *            the summa to set
     */
    public void setSumma(final Integer summa) {
        this.summa = summa;
    }

}
