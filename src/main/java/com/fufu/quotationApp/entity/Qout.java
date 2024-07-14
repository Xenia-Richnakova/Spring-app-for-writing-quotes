package com.fufu.quotationApp.entity;

import java.util.Map;

public class Qout {

    private String author;
    private String text;
    private String title;
    private int id;

    public Qout() {
    }

    public Qout(Map<String, Object> mapa) {
        author = (String) mapa.get("author");
        text = (String) mapa.get("text");
        title = (String) mapa.get("title");
        id = (int) mapa.get("id");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Qout{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String toHTML() {
        return "\n" +
                "\n" +
                "<div style=\"margin: 5px\" class=\"max-w-sm p-6 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700\">\n" +
                "        <h5 class=\"mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white\">" + title + "</h5>\n" +
                "        <p class=\"font-bold tracking-tight text-gray-900 dark:text-white\">" + author + "</p>\n" +
                "    <p class=\"mb-3 font-normal text-gray-700 dark:text-gray-400\">" + text + "</p>\n" +
                "    <button hx-delete=\"/qouts/" + id +"\" type=\"button\" class=\"focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900\">Delete</button>" +
                "    <a href=\"/editQuot/" + id +"\" type=\"button\" class=\"focus:outline-none text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-900\">Edit</a>" +
                "</div>\n";

    }


}
