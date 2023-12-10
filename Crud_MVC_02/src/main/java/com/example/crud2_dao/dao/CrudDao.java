package com.example.crud2_dao.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.example.crud2_dao.domain.Crud;


@Component
public class CrudDao {

	@Autowired
	JdbcTemplate db;

	public List<Crud> getEmployee() {
		String sql = "select email, name, address from tb_employees";

		return db.query(sql, (res, rowNum) -> {
			return new Crud(
					res.getString("email"),
					res.getString("name"),
					res.getString("address"));
		});
	}

	public void insertEmployee(Crud crud) {
		String sql = "insert into tb_employees(email,name,address) values(?,?,?)";

		db.update(sql, new Object[] { crud.getEmail(), crud.getName(), crud.getAddress() });
	}

	public Crud getEmployee(String email) {
		String sql = "select  email,name from tb_employees where email = ?";

		List<Crud> crud = db.query(sql,
				new BeanPropertyRowMapper<>(Crud.class),
				new Object[] { email });
		if (crud != null && crud.size() > 0) {
			return crud.get(0);
		} else {
			return null;
		}
	}

	public void updateEmployee(Crud crud) {
		String sql = "update tb_employees set name = ?, address = ? where email = ?";

		db.update(sql, new Object[] { crud.getName(), crud.getAddress(), crud.getEmail() });
	}

	public void deleteEmployee(String email) {
		String sql = "delete from tb_employees where email = ?";

		db.update(sql, new Object[] { email });
	}

	public List<Crud> getEmployees(String name) {
		String sql = "select  email,name from tb_employees where lower(name) like ?";

		return db.query(sql,
				new BeanPropertyRowMapper<>(Crud.class),
				new Object[] { "%" + name + "%" });
	}

}
