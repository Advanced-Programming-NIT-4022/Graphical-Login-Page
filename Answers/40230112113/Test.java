public class Test {
    public static void main(String[] args) {
        UserStore u = new UserStore();
        User user = new User("hm", "h610", "Hasti_k83");
        u.Save(user);
        System.out.println(u.Read("h610", "Hasti_k83"));
    }
}
