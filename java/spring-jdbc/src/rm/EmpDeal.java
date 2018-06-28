package rm;

public class EmpDeal {
    EmpJdbcTemplate eTemplate;

    public EmpDeal(EmpJdbcTemplate eTemplate) {
        this.eTemplate = eTemplate;
//        System.out.println("result:");
        Emp emp = eTemplate.getEmp(1);
//        System.out.println("\temp1:");
        System.out.println(emp);
    }
}
