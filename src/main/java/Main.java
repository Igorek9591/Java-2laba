import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        MatchParser p = new MatchParser();
        Scanner s = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Сколько у вас будет переменных?\nЧтобы выйти, напечатайте -1");
            int n = Integer.parseInt(s.nextLine());
            if(n != -1) {
                for (int i = 0; i < n; i++) {
                    System.out.println("Введите имя переменной");
                    String name = s.nextLine();
                    System.out.println("Введите значение переменной");
                    Double val = Double.parseDouble(s.nextLine());
                    p.setVariable(name, val);
                }
                System.out.println("Введите формулу");
                String stmnt = s.nextLine();
                try {
                    System.out.println(stmnt + "=" + p.Parse(stmnt));
                } catch (Exception e) {
                    System.err.println("Error while parsing " + stmnt + " with message: " + e.getMessage());
                }
                p.clearVariables();
            }
            else flag = false;
        }
    }
}
