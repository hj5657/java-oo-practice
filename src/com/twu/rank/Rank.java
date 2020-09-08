package com.twu.rank;

/**
 * Create by 木水 on 2020/9/8.
 */
public class Rank {
    private Integer id;
    private Integer buyValue=0;
    private String hotSearchName;
    private Integer hotValue=0;
    private Boolean isSuper=false;

    public Integer getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(Integer buyValue) {
        this.buyValue = buyValue;
    }

    public Boolean getSuper() {
        return isSuper;
    }

    public void setSuper(Boolean aSuper) {
        isSuper = aSuper;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotSearchName() {
        return hotSearchName;
    }

    public void setHotSearchName(String hotSearchName) {
        this.hotSearchName = hotSearchName;
    }

    public Integer getHotValue() {
        return hotValue;
    }

    public void setHotValue(Integer hotValue) {
        this.hotValue = hotValue;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", buyValue=" + buyValue +
                ", hotSearchName='" + hotSearchName + '\'' +
                ", hotValue=" + hotValue +
                ", isSuper=" + isSuper +
                '}';
    }
}
