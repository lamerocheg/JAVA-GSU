package by.gsu.ybychkou;

import java.security.SecureRandom;
import java.util.Scanner;

public class Otdely implements Printable {
    private String      adress;
    private Sotrudnik[] sotrudniki;

    public Otdely() {
        this.sotrudniki = new Sotrudnik[5];
        for (int i = 0; i < this.sotrudniki.length; i++) {
            this.sotrudniki[i] = new Sotrudnik();
        }
        this.adress = new String[] {"Lenina 1", "Pobedi 3", "Kojara 3"}[new SecureRandom()
                .nextInt(3)];
    }

    public Otdely(final String adress, final Sotrudnik[] sotrudniki) {
        super();
        this.adress = adress;
        this.sotrudniki = sotrudniki;
    }

    public static Otdely getInstanceFromConsole() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("VVOD OTDELA :\n Vvedite adres: ");
        final String tmp1 = scanner.nextLine();
        System.out.print(" Vvedite kollichestvo sotrudnikov: ");
        final Integer tmp2 = scanner.nextInt();
        final Sotrudnik[] tmp3 = new Sotrudnik[tmp2 >= 0 ? tmp2 : 5];
        for (Sotrudnik sotr : tmp3) {
            sotr = tmp2 > 0 ? Sotrudnik.getInstanceFromConsole() : new Sotrudnik();
        }
        return new Otdely(tmp1, tmp3);

    }

    public static Otdely getInstanceFromFile(final Scanner scanner) {
        final String tmp1 = scanner.nextLine();
        final Integer tmp2 = scanner.nextInt();
        final Sotrudnik[] tmp3 = new Sotrudnik[tmp2 >= 0 ? tmp2 : 5];
        for (Sotrudnik sotr : tmp3) {
            sotr = tmp2 > 0 ? Sotrudnik.getInstanceFromFile(scanner) : new Sotrudnik();
        }

        return new Otdely(tmp1, tmp3);

    }

    public static void main(final String[] args) {
        new Otdely().print(0);
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return this.adress;
    }

    /**
     * @return the sotrudniki
     */
    public Sotrudnik[] getSotrudniki() {
        return this.sotrudniki;
    }

    /**
     * print data with Header
     */

    @Override
    public void printArrays(final int level) {
        Printable.printArray(this.sotrudniki, level);
    }

    /**
     * @param adress
     *            the adress to set
     */
    public void setAdress(final String adress) {
        this.adress = adress;
    }

    /**
     * @param sotrudniki
     *            the sotrudniki to set
     */
    public void setSotrudniki(final Sotrudnik[] sotrudniki) {
        this.sotrudniki = sotrudniki;
    }
}
