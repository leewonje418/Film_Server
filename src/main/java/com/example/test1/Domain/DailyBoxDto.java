package com.example.test1.Domain;
import lombok.Data;
@Data
public class DailyBoxDto {
    private int display;
    private Item[] items;
    @Data
    static class Item {
        public String rnum;
        public String rank;
        public String rankInten;
        public String rankOldAndNew;
        public String movieCd;
        public String movieNm;
        public String openDt;
        public String salesAmt;
        public String salesShare;
        public String salesInten;
        public String salesChange;
        public String salesAcc;
        public String audiCnt;
        public String audiInte;
        public String audiChange;
        public String audiAcc;
        public String scrnCnt;
        public String showCnt;
    }
}
