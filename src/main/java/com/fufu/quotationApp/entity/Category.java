package com.fufu.quotationApp.entity;

import java.util.Map;

public class Category {

    private String name;
    private String color;
    private int id;

    public Category() {
    }

    public Category(String name, int id, String color) {
        this.name = name;
        this.id = id;
        this.color = color;
    }

    public Category(Map<String, Object> map) {
        name = (String) map.get("name");
        color = (String) map.get("color");
        id = (int) map.get("id");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", id=" + id +
                '}';
    }

    public String toHTML() {
        return "<li>\n" +
                "   <a href=\"#\" style=\"background-color: " + this.getColor() +";\" class=\"inline-flex items-center px-4 py-3 text-white bg-blue-700 rounded-lg active w-full dark:bg-blue-600\" aria-current=\"page\">\n" +
                this.getName() + "\n" +
                "    </a>\n" +
                "</li>";
    }
}
