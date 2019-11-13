package Rough;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

/**
 * Renaming All The Files By Removing All The Spaces!
 */
class Rough{

    public static void main(String[] args) throws IOException {

        File f = new File("C:\\Users\\Krishna Singh\\Downloads\\CodingEBooks\\");

        // For Renaming The Files
        String[] str = f.list();
        for(String st : str){

            System.out.println("Renaming - "+st);

            String newName = st.replaceAll(" ", "");

            File realName = new File(f.getAbsolutePath() +"\\"+ st);
            System.out.println(realName.getAbsolutePath());

            File expectedName = new File(f.getAbsolutePath() +"\\"+ newName);
            System.out.println(expectedName.getAbsolutePath());

            realName.renameTo(expectedName);

        }



        // For Printing File Names
//        Files.newDirectoryStream(f.toPath(), path -> path.toFile().isFile()).forEach( a -> {
//            String nameold = a.toFile().getAbsolutePath();
//        });



        // Printing Names Of The Files Inside The File f.
        Stream<Path> s =    Files.list(f.toPath());
        s.forEach(a -> {
            String sb = a.toFile().getName();
            // sb = sb.replaceAll(" ", "");
            System.out.println(sb);
        });

    }

}