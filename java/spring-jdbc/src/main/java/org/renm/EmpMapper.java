package org.renm;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpMapper implements RowMapper<Emp>{
    @Override
    public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
//        System.out.println("mapRow: resultSet:" + resultSet);
        Emp emp = new Emp();
        emp.setEno(resultSet.getInt("eno"));
        emp.setEname(resultSet.getString("ename"));
        emp.setJob(resultSet.getString("job"));
        emp.setSalary(resultSet.getInt("salary"));
        return emp;
    }
}
