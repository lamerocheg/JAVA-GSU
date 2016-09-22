package by.gsu.ybychkou;

import java.util.Arrays;

public class Printable {
    public void print(final int level) {
        this.printHeader(level);
        this.printInfo(level);
        Arrays.asList(this.getClass().getDeclaredFields()).stream()
                .filter(f -> f.getType().isArray()).forEach(f -> {
                    f.setAccessible(true);
                    try {
                        System.out.println(f.get(this).toString());
                        Arrays.asList(f.get(this)).stream()
                                .forEach(u -> ((Printable) u).printInfo(level));

                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    ;
                });
    }

    public void printHeader(final int level) {
        final StringBuilder result = new StringBuilder()
                .append(new String(new char[level * 3]).replace('\0', ' '));
        Arrays.asList(this.getClass().getDeclaredFields()).stream()
                .forEach(f -> result.append(String.format("|%12s|", f.getName())));
        System.out.println(result.toString());
    }

    public void printInfo(final int level) {
        final StringBuilder result = new StringBuilder()
                .append(new String(new char[level * 3]).replace('\0', ' '));
        Arrays.asList(this.getClass().getDeclaredFields()).stream().forEach(f -> {
            try {
                f.setAccessible(true);
                result.append(String.format("|%12s|",
                        f.getType().isArray() ? f.getName() + "[]" : f.get(this)));
            } catch (final IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println(result.toString());
    }
}
