package gym;

import java.sql.Date;

public class Member {
    int    id;
    String name, email, phone, city, plan, status;
    Date   startDate, endDate;

    public Member() {}

    public Member(String name, String email, String phone,
                  String city, String plan, Date startDate, Date endDate) {
        this.name      = name;
        this.email     = email;
        this.phone     = phone;
        this.city      = city;
        this.plan      = plan;
        this.startDate = startDate;
        this.endDate   = endDate;
        this.status    = "ACTIVE";
    }

    public String toString() {
        return "ID:" + id + " | " + name + " | " + email + " | "
             + city + " | " + plan + " | " + status
             + " | " + startDate + " -> " + endDate;
    }
}