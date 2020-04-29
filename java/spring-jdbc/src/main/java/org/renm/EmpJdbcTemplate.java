package org.renm;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class EmpJdbcTemplate {
    private String tableName;
    private NamedParameterJdbcTemplate template;

    public EmpJdbcTemplate() {
    }

    public EmpJdbcTemplate(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setTemplate(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public Emp getEmp(Integer eno){
        String SQL = "select * from " + tableName + " where eno = :eno";
//        System.out.println(SQL);
        Map<String, Integer> parameterMap =  new HashMap<String, Integer>();
        parameterMap.put("eno", eno);
//        System.out.println(parameterMap);
        Emp emp = template.queryForObject(SQL, parameterMap, new EmpMapper());
        return emp;
    }
}
