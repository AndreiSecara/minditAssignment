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


import ro.mindit.model.Forum;



@Repository
public class ForumDAOImpl implements ForumDAO {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/////////// UTILITY METHODS//////////////////////////////////////////////////////////////
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private static final class ForumMapper implements RowMapper<Forum> {
		public Forum mapRow(ResultSet rs, int rowNum) throws SQLException {
			Forum forum = new Forum();
			forum.setId(rs.getInt("id"));
			forum.setName(rs.getString("name"));
			return forum;
		}
	}
	
	private SqlParameterSource getSqlParameterSourceByModel(Forum forum) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (forum != null) {
			parameterSource.addValue("id", forum.getId());
			parameterSource.addValue("name", forum.getName());
		}
		return parameterSource;
	}
	
	////////DAO METHODS//////////////////////////////////////////////////////////////////////
	
	public List<Forum> listForums() {
		String sql = "SELECT * FROM forums";
		List<Forum> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSourceByModel(null), new ForumMapper());
		return list;
		
	}

	public void addForum(Forum forum) {
		String sql = "INSERT INTO forums (name) VALUES (:name)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSourceByModel(forum));
	}


	public void deleteForum(int id) {
		String sql="DELETE FROM forums WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSourceByModel(new Forum(id)));
	}

	public boolean forumExists(String name) {
		List<Forum> forumList = listForums();
		for(Forum forum : forumList) {
			if(name.equals(forum.getName())) {
				return true;
			}
		}
		return false;
	}

	public Forum getForumById(int id) {
		String sql = "SELECT * FROM forums WHERE id= :id";
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterSourceByModel((new Forum(id))), new ForumMapper());
	}

}
