package net.daxxon.employeeManager.repository;

import net.daxxon.employeeManager.employee.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private final String INSERT_SQL = "INSERT INTO employees (firstName, lastName VALUES (?,?)";
  void add(Employee employee) {
    jdbcTemplate.update(INSERT_SQL, employee.getFirstName(), employee.getLastName());
  }

  private final String SELECT_BY_ID_SQL = "select * from employees where id = ?";
  Employee getById(int id) {
    return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new EmployeeMapper(), id);
  }

  private final String SELECT_SQL = "select * from employees";
  List<Employee> get() {
    return jdbcTemplate.query(SELECT_SQL, new EmployeeMapper());
  }

  private final String UPDATE_SQL = "update employees set firstName=?, lastName=? where id=?";
  void update(Employee employee) {
    jdbcTemplate.update(UPDATE_SQL, employee.getFirstName(), employee.getLastName(), employee.getId());
  }


  private final String DELETE_SQL = "delete from employees where id=?";
  void delete(int id) {
    jdbcTemplate.update(DELETE_SQL, id);
  }

  private static class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
      Employee employee = new Employee();
      employee.setId(rs.getInt("id"));
      employee.setFirstName(rs.getString("firstName"));
      employee.setLastName(rs.getString("lastName"));
      return employee;
    }
  }
}