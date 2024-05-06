package com.jingbeifang;

import java.math.BigDecimal;

public class Demo {

    public static void main(String[] args) {
        //1、16+39=55
        BigDecimal countA = testA(2,new BigDecimal(8),3,new BigDecimal(13));
        System.out.println(countA.toString());//输出总价55

        //2、16 + 39+40 = 95
        BigDecimal countB = testB(2,new BigDecimal(8),3,new BigDecimal(13),2,new BigDecimal(20));
        System.out.println(countB.toString());//输出总价95
        //3、3*13*0.8=31.2+16 + 40  = 87.2
        BigDecimal countC = testC(2,new BigDecimal(8),3,new BigDecimal(13),2,new BigDecimal(20));
        System.out.println(countC.toString());//输出87.2
        //4、3*13*0.8=31.2+16 + 60 = 107.2-10 = 97.2
        BigDecimal countD = testD(2,new BigDecimal(8),3,new BigDecimal(13),3,new BigDecimal(20));
        System.out.println(countD.toString());//输出97.2
    }

    public static BigDecimal testA(int appleNum,BigDecimal applePrice,int strawNum,BigDecimal strawPrice){
        //苹果总价
        BigDecimal appleCountPrice = applePrice.multiply(BigDecimal.valueOf(appleNum));
        //草莓总价
        BigDecimal strawCountPrice = strawPrice.multiply(BigDecimal.valueOf(strawNum));
        //总价
        BigDecimal count = appleCountPrice.add(strawCountPrice);
        return count;
    }

    public static BigDecimal testB(int appleNum,BigDecimal applePrice,int strawNum,BigDecimal strawPrice,int mangoNum,BigDecimal mangoPrice){
        //苹果总价
        BigDecimal appleCountPrice = applePrice.multiply(BigDecimal.valueOf(appleNum));
        //草莓总价
        BigDecimal strawCountPrice = strawPrice.multiply(BigDecimal.valueOf(strawNum));
        //芒果总价
        BigDecimal mangoCountPrice = mangoPrice.multiply(BigDecimal.valueOf(mangoNum));

        BigDecimal count = appleCountPrice.add(strawCountPrice).add(mangoCountPrice);
        return count;
    }

    public static BigDecimal testC(int appleNum,BigDecimal applePrice,int strawNum,BigDecimal strawPrice,int mangoNum,BigDecimal mangoPrice){
        //苹果总价
        BigDecimal appleCountPrice = applePrice.multiply(BigDecimal.valueOf(appleNum));
        //草莓总价

        BigDecimal strawCountPrice = strawPrice.multiply(new BigDecimal("0.8")).multiply(BigDecimal.valueOf(strawNum));
        //芒果总价
        BigDecimal mangoCountPrice = mangoPrice.multiply(BigDecimal.valueOf(mangoNum));

        BigDecimal count = appleCountPrice.add(strawCountPrice).add(mangoCountPrice);
        return count;
    }

    public static BigDecimal testD(int appleNum,BigDecimal applePrice,int strawNum,BigDecimal strawPrice,int mangoNum,BigDecimal mangoPrice){
        //苹果总价16
        BigDecimal appleCountPrice = applePrice.multiply(BigDecimal.valueOf(appleNum));
        //草莓总价

        BigDecimal strawCountPrice = strawPrice.multiply(new BigDecimal("0.8")).multiply(BigDecimal.valueOf(strawNum));
        //芒果总价
        BigDecimal mangoCountPrice = mangoPrice.multiply(BigDecimal.valueOf(mangoNum));

        BigDecimal count = appleCountPrice.add(strawCountPrice).add(mangoCountPrice);

        BigDecimal num = count.divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_DOWN);
        count = count.subtract(num.multiply(new BigDecimal(10)));
        return count;
    }


}
