package com.twu.user;

import com.twu.rank.Rank;

import java.util.List;

/**
 * Create by 木水 on 2020/9/8.
 */
public class Admin extends People {
    /**
     * 添加超级热搜
     * @param list
     * @param hotSearchName
     */
    public void addSuperHotSearch(List<Rank> list,String hotSearchName){
        boolean hasHotSearch=false;
        for (Rank rk:list){
            if (rk.getHotSearchName().equals(hotSearchName)){
                rk.setSuper(true);
                hasHotSearch=true;
                break;
            }
        }
        if (!hasHotSearch){
            System.out.println("没有该热搜，请重新添加");
        }
    }
}
