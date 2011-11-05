/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-10-23
 * Time: 上午10:50
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public   void changeStr(User str){
        System.out.println("-----------------------------");
        System.out.println(str);
        str= new User("welcome");
        System.out.println(str);
        System.out.println("-----------------------------");
    }
    public static void main1(String[] args) {
         Test t=new Test();
        User str=new User("1234");
        System.out.println(str);
        t.changeStr(str);
        System.out.println(str);
    }



     static boolean foo(char c) {
       System.out.print(c);
       return true;
    }
    public static void main(String[] argv) {
       int i = 0;
       //for(65;88&&(i<2);67)
       for (foo('A'); foo('B') && (i < 2); foo('C')) {
           i++;
           foo('D');
       }
        int h=0;
        h++;
          System.out.println(h);
    }
}
class User{

    public String userName;

    public User(String userName){this.userName=userName;}
}