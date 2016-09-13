//  Создать базу данных «Банк» с таблицами «Пользователи», «Транзакции», «Счета» и «Курсы валют». Счет бывает 3-х видов:
//  USD, EUR, UAH. Написать запросы для пополнения счета в нужной валюте, перевода средств с одного счета на другой, конвертации
//  валюты по курсу в рамках счетов одного пользователя. Написать запрос для получения суммарных средств на счету одного
//  пользователя в UAH (расчет по курсу).

package Bank;

import javax.persistence.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bank");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Chose action:");
                System.out.println("1 - Refill;");
                System.out.println("2 - Transfer;");
                System.out.println("3 - Balance check (UAH);");
                String param = sc.nextLine();
                switch (param) {
                    case "1":
                        AccountServiceImpl.refill(em, sc);
                        break;
                    case "2":
                        AccountServiceImpl.transfer(em, sc);
                        break;
                    case "3":
                        AccountServiceImpl.checkBalance(em, sc);
                        break;
                    default:
                        System.out.println("Wrong parameter!");
                        return;
                }
            }
        } finally {
            sc.close();
            em.close();
            emf.close();
        }
    }
}