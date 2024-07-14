package com.fufu.quotationApp.entity;

import java.util.Map;

public class Category {

    private String name;
    private int id;

    public Category() {
    }

    public Category(Map<String, Object> map) {
        name = (String) map.get("name");
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

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String toHTML() {
        return "<li>\n" +
                "   <a href=\"#\" class=\"inline-flex items-center px-4 py-3 text-white bg-blue-700 rounded-lg active w-full dark:bg-blue-600\" aria-current=\"page\">\n" +
                this.getName() + "\n" +
                "    </a>\n" +
                "</li>";
    }
}
