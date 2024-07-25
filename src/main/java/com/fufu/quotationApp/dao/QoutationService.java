package com.fufu.quotationApp.dao;

import com.fufu.quotationApp.entity.Qout;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QoutationService {

    private JdbcTemplate jdbcTemplate;

    public QoutationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Qout> get() {
        String sql = "SELECT qouts.title, qouts.author, qouts.text, qouts.id, categories.name, categories.color, categories.id as catgId FROM qouts, categories WHERE categories.id = qouts.category_id";
        List<Map<String, Object>> queryRes = jdbcTemplate.queryForList(sql);

        return queryRes.stream().map(mapa -> new Qout(mapa)).toList();
    }

    public Qout getCertainQuot(int id) {
        String sql = "SELECT * FROM qouts WHERE id = ?";
        Map<String, Object> queryRes = jdbcTemplate.queryForMap(sql, id);
        return new Qout(queryRes);
    }

    public String getCategroyByID(int id) {
        String sql = "SELECT categories.name, categories.id FROM categories WHERE categories.id = ?";

        Map<String, Object> queryRes = jdbcTemplate.queryForMap(sql, id);

        return (String) queryRes.get("name");
    }

    public void save(Qout qout) {
        String sql = "INSERT INTO qouts (author,text,title,category) values (?,?,?,?)";
        jdbcTemplate.update(sql, qout.getAuthor(), qout.getText(), qout.getTitle(), qout.getCategory());
    }

    public void delete(int id) {
        String sql = "DELETE from qouts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(Qout qout) {
        String sql = "UPDATE qouts SET title = ?, author = ?, text= ?, category = ? WHERE id = ?";
        jdbcTemplate.update(sql, qout.getTitle(), qout.getAuthor(), qout.getText(), qout.getCategory(), qout.getId());
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank() || value.isEmpty();
    }

    public void inputValidation(Qout qout) {
        if (qout == null || isBlank(qout.getTitle()) || isBlank(qout.getAuthor()) || isBlank(qout.getText())) {
            throw new RuntimeException("Wrong Input");
        }
    }
}
