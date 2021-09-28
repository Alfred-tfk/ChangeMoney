package smallchangeapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类时完成零钱通的各个功能的类
 * 使用OOP（现象对象编程）
 * 将各个给你对应一个方法
 */
public class SmallChangeSysOOP {
    //属性
    //定义相关的变量
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    //2.完成零钱通明细
    //思路:(1) 可以把收益入账和消费，保存到数组（2）可以使用对象（3）简单的话可以使用String拼接
    String details = "-----------零钱通明细-----------\n";

    //3.完成收益入账   完成功能驱动程序员增加新的变化和代码
    //思路：定义新的变量
    double money = 0;
    double balabce = 0;
    Date date = null;//date是java.util.Date类型,表明日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//可以用于日期格式化

    //4.消费
    //定义新的变量
    String note = "";

    //先完成显示菜单，并可以选择
    public void mainMenu(){
        do {
            System.out.println("===========零钱通菜单===========");
            System.out.println("\t\t\t1.零钱通明细");
            System.out.println("\t\t\t2.收益入账");
            System.out.println("\t\t\t3.消费");
            System.out.println("\t\t\t4.退     出");
            System.out.println("请选择(1-4):");
            key = scanner.next();

            //使用switch分支控制
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        }
        while (loop);
        System.out.println("======退出了零钱通项目======");
    }

    //完成零钱通明细
    public void detail(){
        System.out.println(details);
    }

    //完成收益入账
    public void income(){
        System.out.println("收益入账金额:");
        money = scanner.nextDouble();
        //money 的值范围应该校验
        //思路:找出不正确金额的条件，给出提示，就直接break
        if (money <= 0) {
            System.out.println("收益入账金额需要大于0");
            return;//退出方法，不再执行后面的代码
        }
        balabce += money;
        //拼接收益入账信息到details
        date = new Date();//获取当前日期
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balabce;
    }

    //消费
    public void pay(){
        System.out.println("消费金额");
        money = scanner.nextDouble();
        //money 的值范围应该校验
        if (money <= 0 || money > balabce) {
            System.out.println("消费金额一个在0-" + balabce);
            return;
        }
        System.out.println("消费说明:");
        note = scanner.next();
        balabce -= money;
        //拼接消费信息到details
        date = new Date();//获取当前日期
        details += "\n" + note + "\t+" + money + "\t" + sdf.format(date) + "\t" + balabce;
    }

    //退出
    public void exit(){
        //用户输入4退出时，给出提示“你确定要退出吗？y/n”，必须输入正确的y/n
        //否则循环输入指令,直到输入y或者n
        //思路:
        //(1)定义一个变量choice,接受用户的输入
        //(2)使用while + break，来处理接收到的输入时y或者n
        //(3)退出while后，在判断choice时y还是n，就可以绝ing是否退出
        //(4)建议一段代码完成一个小功能，尽量不要混在一起
        String choice = "";
        while (true) {//要求用户必须输入y/n，否则就一直循环
            System.out.println("你确定要退出吗？y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }
        //当用户退哦出while，进行判断
        if (choice.equals("y")) {
            loop = false;
        }
    }
}
