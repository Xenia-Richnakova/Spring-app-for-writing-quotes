package com.fufu.quotationApp.dao;

import com.fufu.quotationApp.entity.Category;
import com.fufu.quotationApp.entity.Qout;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    private JdbcTemplate jdbcTemplate;

    public CategoryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Category category) {
        String sql = "INSERT INTO categories (name) values (?)";
        jdbcTemplate.update(sql, category.getName());
    }

    public List<Category> get() {
        String sql = "SELECT * from categories";
        List<Map<String, Object>> queryRes = jdbcTemplate.queryForList(sql);

        return queryRes.stream().map( elem -> new Category(elem)).toList();
    }

    public Category getCertainCategory(int id) {
        String sql = "SELECT * from categories WHERE id = ?";
        Map<String, Object> queryRes = jdbcTemplate.queryForMap(sql, id);

        return new Category(queryRes);
    }

}
