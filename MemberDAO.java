package gym;

import java.sql.*;

public class MemberDAO {

    // ── CREATE ────────────────────────────────────────────
    public void create(Member m) {
        String sql = "INSERT INTO members(name,email,phone,city,plan,start_date,end_date,status) "
                   + "VALUES(?,?,?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.name);
            ps.setString(2, m.email);
            ps.setString(3, m.phone);
            ps.setString(4, m.city);
            ps.setString(5, m.plan);
            ps.setDate  (6, m.startDate);
            ps.setDate  (7, m.endDate);
            ps.setString(8, m.status);
            ps.executeUpdate();
            System.out.println("Member added!");

        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    // ── READ ALL ──────────────────────────────────────────
    public void readAll() {
        String sql = "SELECT * FROM members";
        try (Connection con = DBConnection.getConnection();
             Statement st   = con.createStatement();
             ResultSet rs   = st.executeQuery(sql)) {

            System.out.println("\n--- All Members ---");
            boolean found = false;
            while (rs.next()) {
                found = true;
                Member m = map(rs);
                System.out.println(m);
            }
            if (!found) System.out.println("No members found.");

        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    // ── READ BY ID ────────────────────────────────────────
    public Member readById(int id) {
        String sql = "SELECT * FROM members WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return map(rs);
            else System.out.println("No member with ID " + id);

        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
        return null;
    }

    // ── UPDATE ────────────────────────────────────────────
    public void update(Member m) {
        String sql = "UPDATE members SET name=?,email=?,phone=?,city=?,"
                   + "plan=?,start_date=?,end_date=?,status=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.name);
            ps.setString(2, m.email);
            ps.setString(3, m.phone);
            ps.setString(4, m.city);
            ps.setString(5, m.plan);
            ps.setDate  (6, m.startDate);
            ps.setDate  (7, m.endDate);
            ps.setString(8, m.status);
            ps.setInt   (9, m.id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Member updated!" : "Member not found.");

        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    // ── DELETE ────────────────────────────────────────────
    public void delete(int id) {
        String sql = "DELETE FROM members WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Member deleted!" : "Member not found.");

        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    // ── Map ResultSet → Member ────────────────────────────
    private Member map(ResultSet rs) throws SQLException {
        Member m    = new Member();
        m.id        = rs.getInt("id");
        m.name      = rs.getString("name");
        m.email     = rs.getString("email");
        m.phone     = rs.getString("phone");
        m.city      = rs.getString("city");
        m.plan      = rs.getString("plan");
        m.startDate = rs.getDate("start_date");
        m.endDate   = rs.getDate("end_date");
        m.status    = rs.getString("status");
        return m;
    }
}