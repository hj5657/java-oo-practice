package com.twu.user;

import com.twu.rank.Rank;

import java.util.List;

/**
 * Create by 木水 on 2020/9/7.
 */
public  class People {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 展示热搜
     * @param list
     */
    public void listHotSearch(List<Rank> list) {
        int i=0;
        for(Rank rk:list){
            i++;
            rk.setId(i);
            System.out.println(rk.getId()+" "+rk.getHotSearchName()+" "+rk.getHotValue());
        }
    }

    /**
     * 添加热搜
     * @param list
     * @param hotSearch
     * @param length
     */
    public void addHotSearch(List<Rank> list, String hotSearch,int length) {
        Rank rk=new Rank();
        rk.setHotSearchName(hotSearch);
        rk.setId(length);
        list.add(rk);
    }
}
