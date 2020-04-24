package lesson6;

import java.io.*;
import java.util.Scanner;

public class HomeWork6 {
    public static void main(String[] args) {

        try {
            createTextFile(new FileOutputStream("file1.txt"), "Added the JSON utility functions JSON_STORAGE_SIZE() and \n" +
                    "JSON_STORAGE_FREE(). JSON_STORAGE_SIZE() returns the storage space in bytes \n" +
                    "used for the binary representation of a JSON document prior to any partial \n" +
                    "update (see previous item). JSON_STORAGE_FREE() shows the amount of space \n" +
                    "remaining in a table column of type JSON after it has been partially updated \n" +
                    "using JSON_SET() or JSON_REPLACE(); this is greater than zero if the binary \n" +
                    "representation of the new value is less than that of the previous value.");

            createTextFile(new FileOutputStream("file2.txt"), "As of MySQL 8.0.13, user-created temporary tables and internal temporary \n" +
                    "tables created by the optimizer are stored in session temporary tablespaces \n" +
                    "that are allocated to a session from a pool of temporary tablespaces. When a \n" +
                    "session disconnects, its temporary tablespaces are truncated and released back \n" +
                    "to the pool. In previous releases, temporary tables were created in the global \n" +
                    "temporary tablespace (ibtmp1), which did not return disk space to the operating \n" +
                    "system after temporary tables were dropped.\n" + "\n" +
                    "The innodb_temp_tablespaces_dir variable defines the location where session \n" +
                    "temporary tablespaces are created. The default location is the #innodb_temp \n" +
                    "directory in the data directory.\n" + "\n" +
                    "The INNODB_SESSION_TEMP_TABLESPACES table provides metadata about session \n" +
                    "temporary tablespaces.\n" + "\n" +
                    "The global temporary tablespace (ibtmp1) now stores rollback segments for \n" +
                    "changes made to user-created temporary tables.\n");

            concatenateFiles();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void concatenateFiles() throws IOException {
        copyPasteFile(new FileOutputStream("file3.txt"), new FileInputStream("file1.txt"));
        copyPasteFile(new FileOutputStream("file3.txt", true), new FileInputStream("file2.txt"));
    }

    private static void copyPasteFile(FileOutputStream fos, FileInputStream fis) throws IOException {
        Scanner scanner = new Scanner(fis);
        PrintStream ps = new PrintStream(fos);

        while (scanner.hasNext())
            ps.println(scanner.nextLine());

        fis.close();
        fos.close();
        scanner.close();
        ps.close();
    }

    private static void createTextFile(FileOutputStream fos, String str) throws IOException {

        PrintStream ps = new PrintStream(fos);
        ps.println(str);
        ps.close();
        fos.close();
    }
}
