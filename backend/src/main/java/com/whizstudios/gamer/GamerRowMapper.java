package com.whizstudios.gamer;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GamerRowMapper implements RowMapper<Gamer> {
    @Override
    public Gamer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  new Gamer(
                rs.getInt("id"),
                rs.getInt("age"),
                rs.getString("name"),
                rs.getString("email"),
                Gender.valueOf(rs.getString("gender")));
    }
}
