import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        File f = new File("output.dat");
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(f)))) {
            double v = in.readDouble();
            int n = in.readInt();
            System.out.println(v);
            System.out.println(n);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run2() {
        File f = new File("output.dat");
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
            out.writeDouble(3.5);
            out.writeInt(17);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run1() {
        File file = new File("D:\\IdeaProjects");
        System.out.println("Exists = " + file.exists());
        System.out.println("Directory ? " + file.isDirectory());
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("------------------------");
        File[] files = file.listFiles();
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                if (f1.isDirectory() && !f2.isDirectory()) {
                    return -1;
                } else if (f2.isDirectory() && !f1.isDirectory()) {
                    return 1;
                } else {
                    return f1.getName().compareTo(f2.getName());
                }
            }
        });
        for (File f : files) {
            System.out.print(f.getName()+" ");
            if (f.isDirectory()) {
                System.out.println("dir");
            } else {
                System.out.println(f.length());
            }
        }
        System.out.println("------------------------");
        File[] us = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().startsWith("u");
            }
        });
        for (File u : us) {
            System.out.println(u.getName());
        }
    }
}
