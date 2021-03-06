package Jathon.lib;
import java.util.*;

/**
 * What is new?<br>
 * * Change print() to printx(). If you do not need line break, use printx().
 */

public final class builtin
{
    public final String $version = "0.2.3.0";

    /**
     * This is the builtin file in Jathon. Do not try to initialize instance of this class.<br>
     * You can use this freely.
     */
    private builtin()
    {
    }

    public static void printx(int[] x)
    {
        for (int i = 0; i < x.length; i++)
        {
            if (i != x.length - 1)
            {
                printx(x[i] + ", ");
            }
            else
            {
                printx(x[i]);
            }
        }
    }

    /**
     * An easy function for print data. Shorter than "System.out.println", easier to use (use comma
     * to seperate variables, do not worry about data type).
     * 
     * 
     * @param argument
     * @param e
     * 
     */
    public static void printx(Object... args)
    {
        if (args.length == 0)
        {
            System.out.println();
        }
        else
        {
            for (Object x : args)
            {
                if (x.getClass().isArray())
                {
                    System.out.println();
                }
                else
                {
                    System.out.print(x);
                }
            }
        }
    }
    public static void print()
    {
        System.out.println();
    }
    public static void print(Object... args)
    {
        printx(args);
        print();
    }
    public static void println(IntList arg)
    {
        printx(arg);
        printx();
    }
    public static void println(Object... args)
    {
        printx(args);
        printx();
    }
    public static void printf(String option_str, Object... object_str)
    {
        System.out.printf(option_str, object_str);
    }
    public static void printfl(String option_str, Object... object_str)
    {
        System.out.printf(option_str, object_str);
        printx();
    }
    public static void printa(Object[] x)
    {
        for (Object obj : x)
        {
            printx(obj + " ");
        }
    }
    public static void printx(IntList x)
    {
        printx(x.data);
    }
    public static void print(IntList x)
    {
        printx(x);
        print();
    }
    public static int inted(String x)
    {
        return Integer.parseInt(x);
    }
    public static int inted(float x)
    {
        return (int) x;
    }
    public static int inted(double x)
    {
        return (int) x;
    }
    public static int[] inted(String[] arg)
    {
        int[] ret = new int[arg.length];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = inted(arg[i]);
        }
        return ret;
    }
    public static double doubled(String x)
    {
        return Double.parseDouble(x);

    }
    private static Scanner scanner_s = new Scanner(System.in);
    public static String input()
    {
        return scanner_s.nextLine();
    }
    public static String input(String x)
    {
        printx(x);
        return input();
    }
    public static int inputOneInt()
    {
        return scanner_s.nextInt();
    }
    public static int inputOneInt(String x)
    {
        printx(x);
        return inputOneInt();
    }
    public static int[] sorted(int[] x)
    {
        int[] t = Arrays.copyOf(x, x.length);
        Arrays.sort(t);
        return t;
    }
    public static int[] sorted(IntList x)
    {
        return sorted(x.toArray());
    }
    public static int reversed(int x)
    {
        return inted(reversed(Integer.toString(x)));
    }
    public static String reversed(String s)
    {
        StringBuilder b = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = c.length - 1; i >= 0; i--)
        {
            b.append(c[i]);
        }
        return b.toString();
    }
    // public static <E> E reversed(E[] i)
    // {

    // }

    // Math function.

    // TODO: Wrong randint()
    /**
     * Use system time to return a random number.<br>
     *
     * @return int from 0 to 100 (edge included)
     */
    public static int randint()
    {
        return randint(0, 100);
    }
    /**
     * Use system time to return a random number.<br>
     *
     * @param s The start number of ramdom int
     * @param e The e number of ramdom int
     * @return int from 0 to 100 (edge included)
     */
    public static int randint(int s, int e)
    {
        return inted(Math.sqrt(System.nanoTime() % 1000000000)) % (e - s) + s;
    }
    /**
     * 
     * @param x
     * @return The absolute data of the input number
     */
    public static int abs(int x)
    {
        return x > 0 ? x : -x;
    }

    /**
     * 
     * @param args The data you want to pick.
     * @return The max data from input
     */
    @SafeVarargs
    public static <cmpable extends Number> cmpable max(cmpable... args)
    {
        cmpable r = args[0];
        for (cmpable x : args)
        {
            r = (x.doubleValue() > r.doubleValue() ? x : r);
        }
        return r;
    }

    @SafeVarargs
    public static <cmpable extends Number> cmpable max(cmpable[]... args)
    {
        cmpable r = args[0][0];
        for (cmpable[] c : args)
        {
            r = max(c);
        }
        return r;
    }

    /**
     * 
     * @param args The data you want to pick.
     * @return The min data from input
     */
    @SafeVarargs
    public static <cmpable extends Number> cmpable min(cmpable... args)
    {
        cmpable r = args[0];
        for (cmpable x : args)
        {
            r = (x.doubleValue() < r.doubleValue() ? x : r);
        }
        return r;
    }

    @SafeVarargs
    public static <cmpable extends Number> cmpable min(cmpable[]... args)
    {
        cmpable r = args[0][0];
        for (cmpable[] c : args)
        {
            r = min(c);
        }
        return r;
    }

    public static double pow(double a, double b)
    {
        return Math.pow(a, b);
    }
}
