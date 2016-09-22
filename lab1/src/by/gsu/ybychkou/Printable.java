package by.gsu.ybychkou;

import java.util.Arrays;

public interface Printable {
    public static void printArray(final Printable[] array, final int level) {
        if (array.length > 0) {
            array[0].printHeader(level + 1);
            for (final Printable p : array) {
                p.printInfo(level + 1);
            }
        }
    }

    public default void print(final int level) {
        this.printHeader(level);
        this.printInfo(level);
    }

    public void printArrays(final int level);

    public default void printHeader(final int level) {
        final StringBuilder result = new StringBuilder()
                .append(new String(new char[level * 5]).replace('\0', ' '));
        Arrays.asList(this.getClass().getDeclaredFields()).stream().forEach(f -> result.append(
                String.format("fio".equals(f.getName()) ? "|%30s|" : "|%13s|", f.getName())));
        System.out.println(result.toString());
    }

    public default void printInfo(final int level) {
        final StringBuilder result = new StringBuilder()
                .append(new String(new char[level * 5]).replace('\0', ' '));
        Arrays.asList(this.getClass().getDeclaredFields()).stream().forEach(f -> {
            try {
                f.setAccessible(true);
                result.append(String.format("fio".equals(f.getName()) ? "|%30s|" : "|%13s|",
                        f.getType().isArray() ? f.getName() + "[]" : f.get(this)));
            } catch (final IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println(result.toString());
        this.printArrays(level);
    }
}
