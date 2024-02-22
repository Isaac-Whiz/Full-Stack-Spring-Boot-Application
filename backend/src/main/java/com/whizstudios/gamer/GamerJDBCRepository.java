package com.whizstudios.gamer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GamerJDBCRepository implements GamerDAO{

    private final JdbcTemplate jdbcTemplate;
    private final GamerRowMapper gamerRowMapper;

    public GamerJDBCRepository(JdbcTemplate jdbcTemplate, GamerRowMapper gamerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.gamerRowMapper = gamerRowMapper;
    }

    @Override
    public Optional<Gamer> findGamerById(long id) {
        var sql = """
                  SELECT id, age, name, email, gender FROM gamer WHERE id = ?
                  """;
        return jdbcTemplate.query(sql, gamerRowMapper, id).stream().findFirst();
    }

    @Override
    public List<Gamer> findGamers() {
        var sql = """
                  SELECT id, age, name, email, gender FROM gamer;
                  """;
//        SELECT id, age, name, email FROM gamer;
        return jdbcTemplate.query(sql, gamerRowMapper);
    }

    @Override
    public void saveGamer(Gamer gamer) {
        var sql = """
                  INSERT INTO gamer VALUES(?, ?, ?, ?, ?)
                  """;
//        jdbcTemplate.update(sql, gamer.getName(), gamer.getEmail());
        jdbcTemplate.update(sql, gamer.getId(), gamer.getAge(), gamer.getName(), gamer.getEmail(), gamer.getGender());
    }

    @Override
    public boolean existsGamerWithEmail(String email) {
        var sql = """
                  SELECT id, age, name, email, gender FROM gamer WHERE email = ?
                  """;
        return !jdbcTemplate.query(sql, gamerRowMapper, email).isEmpty();
    }

    @Override
    public boolean existsGamerById(long id) {
        var sql = """
                  SELECT id, age, name, email, gender FROM gamer WHERE id = ?
                  """;
//        return jdbcTemplate.queryForObject(sql, Integer.class, id) == 0;
        return !jdbcTemplate.query(sql, gamerRowMapper, id).isEmpty();
    }

    @Override
    public void deleteGamerById(long id) {
        var sql = """
                  DELETE FROM gamer WHERE id = ?
                  """;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateGamer(Gamer update) {
        if (update.getName() != null) {
            var sql = """
                      UPDATE gamer SET name = ? WHERE id = ?
                      """;
            jdbcTemplate.update(sql, update.getName(), update.getId());
        }

//        if (update.getAge() != null) {
//            var sql = """
//                      UPDATE gamer SET age = ? WHERE id = ?
//                      """;
//            jdbcTemplate.update(sql, update.getAge(), update.getId());
//        }

        if (update.getEmail() != null) {
            var sql = """
                      UPDATE gamer SET email = ? WHERE id = ?
                      """;
            jdbcTemplate.update(sql, update.getEmail(), update.getId());
        }
    }

    @Override
    public void deleteAllGamers() {
        var sql = """
                  DELETE FROM gamer;
                  """;
        jdbcTemplate.execute(sql);
    }
}
