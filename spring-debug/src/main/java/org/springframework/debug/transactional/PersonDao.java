package org.springframework.debug.transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author kenny
 * @date 2021-12-23
 */
public class PersonDao {

	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource;

	private SessionFactory sessionFactory;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	public void insert() {
		jdbcTemplate.execute("insert into person(`name`) values ('张三');");
	}

	public void update(int id, String name) {
		jdbcTemplate.update("update person set name = '" + name + "' where id = " + id + ";");
	}

	public void updateByHibernate(int id, String name) {
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		getSession().update(person);
	}

	public void find(int id) {
		List<Person> personList = jdbcTemplate.query("select * from person where id = ?;", (rs, rowNum) -> {
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			return p;
		}, new Object[]{id});
		System.out.println(personList.get(0));
	}
}
