package by.gsu.ybychkou;

import java.security.SecureRandom;
import java.util.Scanner;

public class Podkluchenie implements Printable {
    private String    number;
    private String    fio;
    private String    date;
    private String    tarif;
    private Rouming[] roumingi;
    private Oplata[]  oplaty;

    public Podkluchenie() {
        super();
        final SecureRandom rand = new SecureRandom();
        this.number = "+" + (3750000000L + rand.nextInt(10000000));
        this.fio = new String[] {"Ivanov Ivan Ivanovich", "Starovoitov Sergej Sergeevich",
                "Ganush Anna Sergevna"}[new SecureRandom().nextInt(3)];
        this.date = "" + (rand.nextInt(31) + 1) + '.' + (rand.nextInt(12) + 1)
                + (2000 + rand.nextInt(17));
        this.tarif = new String[] {"Kedy", "Polukedy", "vse vklucheno"}[rand.nextInt(3)];
        this.roumingi = new Rouming[5];
        this.oplaty = new Oplata[5];
        for (int i = 0; i < 5; i++) {
            this.roumingi[i] = new Rouming();
            this.oplaty[i] = new Oplata();
        }

    }

    public Podkluchenie(final String number, final String fio, final String date,
            final String tarif, final Rouming[] roumingi, final Oplata[] oplaty) {
        super();
        this.number = number;
        this.fio = fio;
        this.date = date;
        this.tarif = tarif;
        this.roumingi = roumingi;
        this.oplaty = oplaty;
    }

    public static Podkluchenie getInstanceFromConsole() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("VVOD PODKLUCHENIA :\n Vvedite nomer: ");
        final String number = scanner.nextLine();
        System.out.print(" Vvedite fio: ");
        final String fio = scanner.nextLine();
        System.out.print(" Vvedite datu zakluchenia dogovora: ");
        final String date = scanner.nextLine();
        System.out.print(" Vvedite tarif: ");
        final String tarif = scanner.nextLine();
        System.out.print(" Vvedite kollichestvo roumingov: ");
        final Integer kolRoum = scanner.nextInt();
        final Rouming[] roums = new Rouming[kolRoum >= 0 ? kolRoum : 5];
        for (Rouming roum : roums) {
            roum = kolRoum > 0 ? Rouming.getInstanceFromConsole() : new Rouming();
        }
        System.out.print(" Vvedite kollichestvo oplat: ");
        final Integer kolOplat = scanner.nextInt();
        final Oplata[] oplaty = new Oplata[kolOplat >= 0 ? kolOplat : 5];
        for (Oplata oplata : oplaty) {
            oplata = kolOplat > 0 ? Oplata.getInstanceFromConsole() : new Oplata();
        }
        return new Podkluchenie(number, fio, date, tarif, roums, oplaty);
    }

    public static Podkluchenie getInstanceFromFile(final Scanner scanner) {
        final String number = scanner.nextLine();
        final String fio = scanner.nextLine();
        final String date = scanner.nextLine();
        final String tarif = scanner.nextLine();
        final Integer kolRoum = scanner.nextInt();
        final Rouming[] roums = new Rouming[kolRoum >= 0 ? kolRoum : 5];
        for (Rouming roum : roums) {
            roum = kolRoum > 0 ? Rouming.getInstanceFromFile(scanner) : new Rouming();

        }
        final Integer kolOplat = scanner.nextInt();
        final Oplata[] oplaty = new Oplata[kolOplat >= 0 ? kolOplat : 5];
        for (Oplata oplata : oplaty) {
            oplata = kolOplat > 0 ? Oplata.getInstanceFromFile(scanner) : new Oplata();
        }
        return new Podkluchenie(number, fio, date, tarif, roums, oplaty);
    }

    /**
     * @return the date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * @return the fio
     */
    public String getFio() {
        return this.fio;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * @return the oplaty
     */
    public Oplata[] getOplaty() {
        return this.oplaty;
    }

    /**
     * @return the roumingi
     */
    public Rouming[] getRoumingi() {
        return this.roumingi;
    }

    /**
     * @return the tarif
     */
    public String getTarif() {
        return this.tarif;
    }

    @Override
    public void printArrays(final int level) {
        Printable.printArray(this.roumingi, level);
        Printable.printArray(this.oplaty, level);

    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * @param fio
     *            the fio to set
     */
    public void setFio(final String fio) {
        this.fio = fio;
    }

    /**
     * @param number
     *            the number to set
     */
    public void setNumber(final String number) {
        this.number = number;
    }

    /**
     * @param oplaty
     *            the oplaty to set
     */
    public void setOplaty(final Oplata[] oplaty) {
        this.oplaty = oplaty;
    }

    /**
     * @param roumingi
     *            the roumingi to set
     */
    public void setRoumingi(final Rouming[] roumingi) {
        this.roumingi = roumingi;
    }

    /**
     * @param tarif
     *            the tarif to set
     */
    public void setTarif(final String tarif) {
        this.tarif = tarif;
    }

}
