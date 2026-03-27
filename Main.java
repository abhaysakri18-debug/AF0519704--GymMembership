package gym;

import java.sql.Date;
import java.util.Scanner;

public class Main {

    static MemberDAO dao = new MemberDAO();
    static Scanner sc    = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Travel Gym Membership System ===");
        int choice;
        do {
            System.out.println("\n1.Add  2.View All  3.View by ID  4.Update  5.Delete  0.Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addMember();
                case 2 -> dao.readAll();
                case 3 -> viewById();
                case 4 -> updateMember();
                case 5 -> deleteMember();
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addMember() {
        System.out.print("Name: ");        String name  = sc.nextLine();
        System.out.print("Email: ");       String email = sc.nextLine();
        System.out.print("Phone: ");       String phone = sc.nextLine();
        System.out.print("City: ");        String city  = sc.nextLine();
        System.out.print("Plan (Daily/Weekly/Monthly): "); String plan = sc.nextLine();
        System.out.print("Start (YYYY-MM-DD): "); Date start = Date.valueOf(sc.nextLine());
        System.out.print("End   (YYYY-MM-DD): "); Date end   = Date.valueOf(sc.nextLine());
        dao.create(new Member(name, email, phone, city, plan, start, end));
    }

    static void viewById() {
        System.out.print("Enter ID: ");
        Member m = dao.readById(Integer.parseInt(sc.nextLine()));
        if (m != null) System.out.println(m);
    }

    static void updateMember() {
        System.out.print("Enter ID to update: ");
        Member m = dao.readById(Integer.parseInt(sc.nextLine()));
        if (m == null) return;
        System.out.println("Current: " + m);
        System.out.print("New Name: ");        m.name      = sc.nextLine();
        System.out.print("New Email: ");       m.email     = sc.nextLine();
        System.out.print("New Phone: ");       m.phone     = sc.nextLine();
        System.out.print("New City: ");        m.city      = sc.nextLine();
        System.out.print("New Plan: ");        m.plan      = sc.nextLine();
        System.out.print("New Start Date: ");  m.startDate = Date.valueOf(sc.nextLine());
        System.out.print("New End Date: ");    m.endDate   = Date.valueOf(sc.nextLine());
        System.out.print("Status (ACTIVE/INACTIVE): "); m.status = sc.nextLine();
        dao.update(m);
    }

    static void deleteMember() {
        System.out.print("Enter ID to delete: ");
        dao.delete(Integer.parseInt(sc.nextLine()));
    }
}