package rm;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpMapper implements RowMapper<Emp>{
    @Override
    public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
        Emp emp = new Emp();
        emp.setEno(resultSet.getInt("eno"));
        emp.setEname(resultSet.getString("ename"));
        emp.setJob(resultSet.getString("job"));
        emp.setSalary(resultSet.getInt("salary"));
        return null;
    }
}
