package ro.mindit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import ro.mindit.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/////////// UTILITY METHODS//////////////////////////////////////////////////////////////

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private static final class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUser_name(rs.getString("user_name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			return user;
		}
	}

	private SqlParameterSource getSqlParameterSourceByModel(User user) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (user != null) {
			parameterSource.addValue("id", user.getId());
			parameterSource.addValue("user_name", user.getUser_name());
			parameterSource.addValue("password", user.getPassword());
			parameterSource.addValue("email", user.getEmail());
		}
		return parameterSource;
	}

	////////// DAO METHODS//////////////////////////////////////////////////////////////////
	
	public List<User> listUsers() {
		String sql = "select * from users";
		List<User> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSourceByModel(null), new UserMapper());
		return list;
	}

	public void addUser(User user) {
		String sql = "insert into users(user_name,password,email) values (:user_name, :password, :email)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSourceByModel(user));
	}

	public boolean userExists(String user_name, String password) {
		List<User> userList = listUsers();
		for (User user : userList) {
			if (user_name.equals(user.getUser_name()) && password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
