package com.github.qcha.interview.tasks.collections;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employe {
    private String id;
    private String managerId;
    public Employe(String id, String managerId){
        this.id = id;
        this.managerId = managerId;
    }

    public String getId() {
        return id;
    }

    public String getManagerId() {
        return managerId;
    }
    public static void print(List<Employe> employees){
        StringBuffer sb = new StringBuffer();
        ArrayList<String> sBossList = new ArrayList<String>(); //список Боссов, подчиненных которых, мы ищем
        ArrayList<String> sNextBossList = new ArrayList<String>(); //список подчиненных(они же Боссы еще для кого то)
        ArrayList<String> sNextOneBossList = new ArrayList<String>(); //список подчиненных одного какого-то Босса
        int iLevelCount = 1;
        boolean isExistsLower;
        //поиск самого главного
        for(Employe e : employees) {
            if (e.getManagerId() == "") {
                sBossList.add(e.getId());
                sb.append(e.getId());
            }
        }

        do{ //выполняем, пока есть подчиненные ниже уровнем
            isExistsLower = false;
            for(String sBoss : sBossList){
                for(Employe e : employees){
                    if (e.getManagerId().equals(sBoss)) {
                        sNextOneBossList.add(e.getId());
                        isExistsLower = true;
                    }
                }
                sNextBossList.addAll(sNextOneBossList);//формируем список боссов, одного уровня
                sNextOneBossList.sort(new Comparator<String>() { //сортировка боссов
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                });
                for(String sNextBoss: sNextOneBossList){
                    sb.insert(sb.indexOf(sBoss) + sBoss.length(),"\n");
                    for (int i = 1; i <= iLevelCount; i++) //вставка iLevelCount знаков табуляции
                        sb.insert(sb.indexOf(sBoss) + sBoss.length() + 1, "\t");
                    sb.insert(sb.indexOf(sBoss) + sBoss.length() + iLevelCount + 1,sNextBoss); //вставка подчиненного, сразу после Босса(и табуляций)
                }
                sNextOneBossList.clear();

            }
            sBossList.clear();
            sBossList.addAll(sNextBossList);//для следующей итерации новыми боссами являются подчиненные
            sNextBossList.clear();
            iLevelCount ++;

        }while (isExistsLower);
        System.out.println(sb);

    }
}