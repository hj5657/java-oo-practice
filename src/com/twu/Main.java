package com.twu;

import com.twu.rank.Rank;
import com.twu.user.Admin;
import com.twu.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Rank> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("欢迎来到热搜排行榜系统！");
            boolean flag = false;
            while (true) {
                if (flag == true) {
                    break;
                }
                System.out.println("请输入用户名进行登录");
                String username = sc.nextLine();
                while (true) {
                    if (flag == true) {
                        break;
                    }
                    if ("admin".equals(username)) {
                        flag = opAdmin();
                    } else {
                        flag = opUser(username);
                    }
                }
            }
        }
    }

    public static boolean opAdmin() {
        boolean flag = false;
        Admin admin = new Admin();
        System.out.println("Hello,管理员。请输入以下数字选择操作");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("4.退出登录");
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                admin.listHotSearch(list);
                break;
            case 2: {
                System.out.println("请输入要添加的热搜名称：");
                String hotSearchName = sc.nextLine();
                admin.addHotSearch(list, hotSearchName, list.size() + 1);
                break;
            }
            case 3: {
                System.out.println("请输入要添加的超级热搜名称：");
                String hotSearchName = sc.nextLine();
                admin.addSuperHotSearch(list, hotSearchName);
                break;
            }
            case 4:
                flag = true;
                break;
            default:
                System.out.println("你输入的数字不符合，请重新输入");
                break;
        }
        return flag;
    }

    public static boolean opUser(String username) {
        boolean flag = false;
        User user = new User();
        user.setName(username);
        System.out.println("Hello," + username + "。请输入以下数字选择操作");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.给热搜事件投票");
        System.out.println("3.添加热搜");
        System.out.println("4.购买热搜");
        System.out.println("5.退出登录");
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                user.listHotSearch(list);
                break;
            case 2: {
                System.out.println("请输入要投票的热搜名称：");
                String hotSearchName = sc.nextLine();
                System.out.println("请输入要投的票数：");
                int ticketNum = sc.nextInt();
                int totalNum = user.getTicketNum();
                if (ticketNum > totalNum || ticketNum < 0) {
                    System.out.println("投票失败，您的票数不够或数目不符合要求");
                } else {
                    boolean voteSuccess = user.vote(list, hotSearchName, ticketNum);
                    if (voteSuccess) {
                        user.setTicketNum(totalNum - ticketNum);
                    }
                }
                break;
            }
            case 3: {
                System.out.println("请输入要添加的热搜名称：");
                String hotSearchName = sc.nextLine();
                user.addHotSearch(list, hotSearchName, list.size() + 1);
                break;
            }
            case 4: {
                System.out.println("请输入要购买的热搜名称：");
                String hotSearchName = sc.nextLine();
                System.out.println("请输入要购买的价格：");
                int buyValue = sc.nextInt();
                System.out.println("请输入要购买的排名：");
                int id = sc.nextInt();
                int preValue = list.get(id - 1).getBuyValue();
                if (preValue < buyValue) {
                    user.bugHotSearch(list, hotSearchName, buyValue, id);
                } else {
                    System.out.println("抱歉，购买该热搜失败，价格不足");
                }
                break;
            }
            case 5:
                flag = true;
                break;
            default:
                System.out.println("你输入的数字不符合，请重新输入");
                break;
        }
        return flag;
    }
}
