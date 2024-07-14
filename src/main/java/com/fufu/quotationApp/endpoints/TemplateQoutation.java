package com.fufu.quotationApp.endpoints;

import com.fufu.quotationApp.entity.Qout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class TemplateQoutation {

    public final static String PostQouteForm = "<div class=\"mb-5\">\n" +
            "        <label for=\"title\" class=\"block mb-2 text-sm font-medium text-gray-900 dark:text-white\">Title</label>\n" +
            "        <input type=\"text\" id=\"title\" name=\"title\" class=\"bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500\">\n" +
            "    </div>\n" +
            "    <div>\n" +
            "        <label for=\"author\" class=\"block mb-2 text-sm font-medium text-gray-900 dark:text-white\">Author</label>\n" +
            "        <input type=\"text\" id=\"author\" name=\"author\" class=\"block w-full p-2 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 text-xs focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500\">\n" +
            "    </div>\n" +
            "    <div class=\"mb-5\">\n" +
            "        <label for=\"text\" class=\"block mb-2 text-sm font-medium text-gray-900 dark:text-white\">Qoute text</label>\n" +
            "        <input type=\"text\" id=\"text\" name=\"text\" class=\"block w-full p-4 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 text-base focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500\">\n" +
            "    </div>\n" +
            "    <button type=\"submit\" class=\"text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800\">Submit</button>\n" +
            "     <h3>Your quote was successfully created!</h3>";

    public static String EditForm(String file,Qout qout) {
        try {
            InputStream is = TemplateQoutation.class.getClassLoader().getResourceAsStream(file);
            Scanner myReader = new Scanner(is);
            StringBuilder htmlFile = new StringBuilder();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                htmlFile.append(data);
            }
            myReader.close();
            // Replace all 3 values from html template
            String res = String.valueOf(htmlFile);
            res = res.replace("$title", qout.getTitle())
                    .replace("$author", qout.getAuthor())
                    .replace("$text", qout.getText())
                    .replace("$id", "" + qout.getId());
            return res;
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    //    public static String EditForm(Qout qout) {
//        return "<div class=\"mb-5\">\n" +
//                "        <label for=\"title\" class=\"block mb-2 text-sm font-medium text-gray-900 dark:text-white\">Title</label>\n" +
//                "        <input type=\"text\" id=\"title\" name=\"title\" value=\"" + qout.getTitle() + " \"  class=\"bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500\">\n" +
//                "    </div>\n" +
//                "    <div>\n" +
//                "        <label for=\"author\" class=\"block mb-2 text-sm font-medium text-gray-900 dark:text-white\">Author</label>\n" +
//                "        <input type=\"text\" id=\"author\" name=\"author\" value=\"" + qout.getAuthor() + " \" class=\"block w-full p-2 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 text-xs focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500\">\n" +
//                "    </div>\n" +
//                "    <div class=\"mb-5\">\n" +
//                "        <label for=\"text\" class=\"block mb-2 text-sm font-medium text-gray-900 dark:text-white\">Qoute text</label>\n" +
//                "        <input type=\"text\" id=\"text\" name=\"text\" value=\"" + qout.getText() + " \"  class=\"block w-full p-4 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 text-base focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500\">\n" +
//                "    </div>\n" +
//                "    <button type=\"submit\" class=\"text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800\">Submit</button>\n";
//    }

}
