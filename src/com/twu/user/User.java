package com.twu.user;

import com.twu.rank.Rank;

import java.util.List;

/**
 * Create by 木水 on 2020/9/7.
 */
public class User extends People {
    private Integer ticketNum = 10;

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    /**
     * 购买热搜
     * @param list
     * @param hotSearchName
     * @param buyValue
     * @param id
     */
    public void bugHotSearch(List<Rank> list, String hotSearchName, Integer buyValue, Integer id){
        boolean hasHotSearch=false;
        int tempId;
        for (Rank rk:list){
            if (rk.getHotSearchName().equals(hotSearchName)){
                tempId=rk.getId();
                Rank nrk=new Rank();
                nrk.setHotSearchName(hotSearchName);
                nrk.setBuyValue(buyValue);
                nrk.setId(id);
                nrk.setHotValue(rk.getHotValue());
                nrk.setSuper(rk.getSuper());
                list.set(id-1,nrk);
                list.remove(tempId-1);
                hasHotSearch=true;
                break;
            }
        }
        if (!hasHotSearch){
            System.out.println("没有该热搜，购买失败");
        }

    }

    /**
     * 用户投票
     * @param list
     * @param hotSearchName
     * @param ticketNum
     */
    public boolean vote(List<Rank> list, String hotSearchName,Integer ticketNum){
        boolean hasHotSearch=false;
        for (Rank rk:list){
            if (rk.getHotSearchName().equals(hotSearchName)){
                if (rk.getSuper()){
                    ticketNum*=2;
                }
                rk.setHotValue(ticketNum+rk.getHotValue());
                hasHotSearch=true;
                break;
            }
        }
        //投票成功之后重新进行排序
        if (hasHotSearch) {
            for (int i = 0; i < list.size() -1; i++) {
                Rank rki = list.get(i);
                if (rki.getBuyValue() != 0) {
                    continue;
                }
                for (int j = i+1; j < list.size(); j++) {
                    Rank rkj = list.get(j);
                    if (rkj.getBuyValue() == 0) {
                        if (rki.getHotValue() < rkj.getHotValue()) {
                            Rank tp = rki;
                            list.set(i, rkj);
                            list.set(j, tp);
                        }
                    }
                }
            }
        }else {
            System.out.println("没有该热搜，投票失败");
        }
        return hasHotSearch;
    }
}
