package qcha.interview.tasks.collections.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Printer {
    /**
     * Вывод на консоль древовидной структуры компании.
     *
     * @param employees список сотрудников компании.
     */
    public static void print(List<Employee> employees) {
        StringBuilder sb = new StringBuilder();

        //список Боссов, подчиненных которых, мы ищем
        List<String> sBossList = new ArrayList<>();
        //список подчиненных(они же Боссы еще для кого то)
        List<String> sNextBossList = new ArrayList<>();
        //список подчиненных одного какого-то Босса
        List<String> sNextOneBossList = new ArrayList<>();

        int iLevelCount = 1;
        boolean isExistsLower;
        //поиск самого главного
        for (Employee e : employees) {
            if (e.getManagerId().isEmpty()) {
                sBossList.add(e.getId());
                sb.append(e.getId());
            }
        }

        //выполняем, пока есть подчиненные ниже уровнем
        do {
            isExistsLower = false;
            for (String sBoss : sBossList) {
                for (Employee e : employees) {
                    if (e.getManagerId().equals(sBoss)) {
                        sNextOneBossList.add(e.getId());
                        isExistsLower = true;
                    }
                }
                //формируем список боссов, одного уровня
                sNextBossList.addAll(sNextOneBossList);
                //сортировка боссов
                sNextOneBossList.sort(Comparator.reverseOrder());
                for (String sNextBoss : sNextOneBossList) {
                    sb.insert(sb.indexOf(sBoss) + sBoss.length(), "\n");
                    //вставка iLevelCount знаков табуляции
                    for (int i = 1; i <= iLevelCount; i++) {
                        sb.insert(sb.indexOf(sBoss) + sBoss.length() + 1, "\t");
                    }
                    //вставка подчиненного, сразу после Босса(и табуляций)
                    sb.insert(sb.indexOf(sBoss) + sBoss.length() + iLevelCount + 1, sNextBoss);
                }
                sNextOneBossList.clear();

            }
            sBossList.clear();
            //для следующей итерации новыми боссами являются подчиненные
            sBossList.addAll(sNextBossList);
            sNextBossList.clear();
            iLevelCount++;

        } while (isExistsLower);

        System.out.println(sb);
    }
}
