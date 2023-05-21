package pharmacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Medicines medicines1 = new Medicines("A", 100, 38);
        Medicines medicines2 = new Medicines("S", 456, 47);
        Medicines medicines3 = new Medicines("P", 789, 54);
        Medicines medicines4 = new Medicines("I", 55, 26);
        Medicines medicines5 = new Medicines("R", 76, 57);
        Medicines medicines6 = new Medicines("I", 346, 20);
        Medicines medicines7 = new Medicines("N", 1000, 10);
        List<Medicines> medicine1 = new ArrayList<>();
                medicine1.add(medicines1);
                medicine1.add(medicines2);
                medicine1.add(medicines3);
        List<Medicines> medicine2 = new ArrayList<>();
                medicine2.add(medicines4);
                medicine2.add(medicines5);
        List<Medicines> medicine3 = new ArrayList<>();
                medicine3.add(medicines6);
                medicine3.add(medicines7);

        Worker worker1 = new Worker("Aizada", 24, "aizada@gmail.com");
        Worker worker2 = new Worker("Aikanysh", 37, "aikanysh@gmail.com");
        Worker worker3 = new Worker("Akylai", 443, "akylai@gmail.com");
        Worker worker4 = new Worker("Aibek", 32, "aibek@gmail.com");
        Worker worker5 = new Worker("Abil", 23, "abil@gmail.com");
        List<Worker> workers1 = new ArrayList<>();
                workers1.add(worker1);
                workers1.add(worker2);
        List<Worker> workers2 = new ArrayList<>();
                workers2.add(worker3);
                workers2.add(worker4);
        List<Worker> workers3 = new ArrayList<>();
                workers3.add(worker5);

        Pharmacy pharmacy1 = new Pharmacy("Apteka","Bishkek", medicine1, workers1);
        Pharmacy pharmacy2 = new Pharmacy("Neman","Naryn", medicine2, workers2);
        Pharmacy pharmacy3 = new Pharmacy("Farm","Kyrgyzstan", medicine3, workers3);
        List<Pharmacy> pharmacies = new ArrayList<>();
                pharmacies.add(pharmacy1);
                pharmacies.add(pharmacy2);
                pharmacies.add(pharmacy3);

        String word;
        do {
            System.out.println("--------------------------------------");
            System.out.println("1. Для получения всех лекарств по имени аптеки");
            System.out.println("2. Для получения работников по адрессу аптеки");
            System.out.println("3. Для добавления лекарства в аптеку");
            System.out.println("4. Для добавления работников в аптеку");
            System.out.println("5. Для обновления цены лекарств");
            System.out.println("6. Для удаления лекарства по названию");
            System.out.println("7. Для удаления работника по имени");
            System.out.println("8. Для получения аптеки по имени работника");
            System.out.println("exit");
            System.out.println("--------------------------------------");
            Scanner scanner =new Scanner(System.in);
            word = scanner.nextLine();
            switch (word) {
                case "1":
                    System.out.println("Введите название аптеки");
                    Scanner scan1 = new Scanner(System.in);
                    String namePharmacy = scan1.nextLine();
                    if (namePharmacy.equals(pharmacy1.getName())) {
                        System.out.println(pharmacy1.getAllMedicinesByPharmacyName());
                    } else if (namePharmacy.equals(pharmacy2.getName())) {
                        System.out.println(pharmacy2.getAllMedicinesByPharmacyName());
                    } else if (namePharmacy.equals(pharmacy3.getName())){
                        System.out.println(pharmacy3.getAllMedicinesByPharmacyName());
                    } else {
                        System.out.println("Аптека с таким именем нет");
                    }
                    break;
                case "2":
                    System.out.println("Ведите адресс аптеки ");
                    Scanner scan2 = new Scanner(System.in);
                    String pharmacyAddress = scan2.nextLine();
                    if (pharmacyAddress.equals(pharmacy1.getAddress())){
                        System.out.println(pharmacy1.getAllSortedWorkersNameByPharmacyAddress());
                    } else if (pharmacyAddress.equals(pharmacy2.getAddress())) {
                        System.out.println(pharmacy2.getAllSortedWorkersNameByPharmacyAddress());
                    } else if (pharmacyAddress.equals(pharmacy3.getAddress())) {
                        System.out.println(pharmacy3.getAllSortedWorkersNameByPharmacyAddress());
                    } else {
                        System.out.println("Аптека с таким адрессом не существует");
                    }
                    break;
                case "3":
                    System.out.print("Введите название лекарства: ");
                    Scanner scan3 = new Scanner(System.in);
                    String name = scan3.nextLine();
                    System.out.print("Введите цену лекарства: ");
                    Scanner scan4 =new Scanner(System.in);
                    int price = scan4.nextInt();
                    System.out.print("Введите количество лекарств: ");
                    Scanner scan5 = new Scanner(System.in);
                    int count = scan5.nextInt();
                    Medicines medicines =new Medicines(name, price,count);
                    System.out.println("Введите название аптеки куда вы хотите добавить");
                    Scanner scan6 =new Scanner(System.in);
                    String namePharm = scan6.nextLine();
                    if (namePharm.equals(pharmacy1.getName())) {
                        pharmacy1.addMedicinesToPharmacy(medicines);
                    } else if (namePharm.equals(pharmacy2.getName())){
                        pharmacy2.addMedicinesToPharmacy(medicines);
                    } else if (namePharm.equals(pharmacy3.getName())) {
                        pharmacy3.addMedicinesToPharmacy(medicines);
                    } else {
                        System.out.println("Аптеки с таким именем нет");
                    }
                    break;
                case "4":
                    System.out.print("Введите имя работника: ");
                    Scanner scannerName = new Scanner(System.in);
                    String workName = scannerName.nextLine();
                    System.out.print("Введите возраст работника: ");
                    Scanner scannerAge = new Scanner(System.in);
                    int workAge = scannerAge.nextInt();
                    System.out.print("Введите электронную почту работника: ");
                    Scanner scannerEmail = new Scanner(System.in);
                    String workEmail = scannerEmail.nextLine();
                    Worker worker = new Worker(workName,workAge,workEmail);
                    System.out.println("Введите название аптеки куда вы хотите добавить: ");
                    Scanner scannerPharmacyName = new Scanner(System.in);
                    String pharmacyName = scannerPharmacyName.nextLine();
                    if (pharmacyName.equals(pharmacy1.getName())){
                        pharmacy1.addWorkerToPharmacy(worker);
                    } else if (pharmacyName.equals(pharmacy2.getName())) {
                        pharmacy2.addWorkerToPharmacy(worker);
                    } else if (pharmacyName.equals(pharmacy3.getName())) {
                        pharmacy3.addWorkerToPharmacy(worker);
                    } else {
                        System.out.println("Аптеки с таким именем нет");
                    }
                    break;
                case "5":
                    System.out.println("Введите название аптеки где вы хотите поменять цену лекарства: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String namePhar = scanner1.nextLine();
                    if (namePhar.equals(pharmacy1.getName())){
                        System.out.println("Все лекарства: ");
                        System.out.println(pharmacy1.getAllMedicinesByPharmacyName());
                        System.out.println("Введите название лекарства для указания новых цен");
                        Scanner scanner2 = new Scanner(System.in);
                        String nameMedicine = scanner2.nextLine();
                        System.out.println("Укажите новую цену: ");
                        Scanner scanner3 = new Scanner(System.in);
                        int newPrice = scanner3.nextInt();
                        pharmacy1.updateMedicinePrice(nameMedicine, newPrice);
                    } else if (namePhar.equals(pharmacy2.getName())) {
                        System.out.println("Все лекарства: ");
                        System.out.println(pharmacy2.getAllMedicinesByPharmacyName());
                        System.out.println("Введите название лекарства для указания новых цен");
                        Scanner scanner4 = new Scanner(System.in);
                        String nameMedicine = scanner4.nextLine();
                        System.out.println("Укажите новую цену: ");
                        Scanner scanner5 = new Scanner(System.in);
                        int newPrice = scanner5.nextInt();
                        pharmacy2.updateMedicinePrice(nameMedicine, newPrice);
                    } else if (namePhar.equals(pharmacy3.getName())) {
                        System.out.println("Все лекарства: ");
                        System.out.println(pharmacy3.getAllMedicinesByPharmacyName());
                        System.out.println("Введите название лекарства для указания новых цен");
                        Scanner scanner6 = new Scanner(System.in);
                        String nameMedicine = scanner6.nextLine();
                        System.out.println("Укажите новую цену: ");
                        Scanner scanner7 = new Scanner(System.in);
                        int newPrice = scanner7.nextInt();
                        pharmacy3.updateMedicinePrice(nameMedicine, newPrice);
                    }else {
                        System.out.println("Аптеки с таким именем нет");
                    }
                    break;
                case "6":
                    System.out.println("Введите название аптеки где вы хотите удалить лекарства: ");
                    Scanner scanner9 = new Scanner(System.in);
                    String namePh = scanner9.nextLine();
                    if (namePh.equals(pharmacy1.getName())){
                        System.out.println("Все лекарства: ");
                        System.out.println(pharmacy1.getAllMedicinesByPharmacyName());
                        System.out.println("Введите название лекарства которую хотите удалить: ");
                        Scanner scanner10 = new Scanner(System.in);
                        String nameMedicines = scanner10.nextLine();
                        pharmacy1.deleteMedicineByName(nameMedicines);
                    } else if (namePh.equals(pharmacy2.getName())) {
                        System.out.println("Все лекарства: ");
                        System.out.println(pharmacy2.getAllMedicinesByPharmacyName());
                        System.out.println("Введите название лекарства которую хотите удалить: ");
                        Scanner scanner10 = new Scanner(System.in);
                        String nameMedicines = scanner10.nextLine();
                        pharmacy2.deleteMedicineByName(nameMedicines);
                    } else if (namePh.equals(pharmacy3.getName())) {
                        System.out.println("Все лекарства: ");
                        System.out.println(pharmacy3.getAllMedicinesByPharmacyName());
                        System.out.println("Введите название лекарства которую хотите удалить: ");
                        Scanner scanner10 = new Scanner(System.in);
                        String nameMedicines = scanner10.nextLine();
                        pharmacy3.deleteMedicineByName(nameMedicines);
                    } else {
                        System.out.println("Аптеки с таким именем нет");
                    }
                    break;
                case "7":
                    System.out.println("Введите название аптеки где вы хотите удалить работника: ");
                    Scanner scanner11 = new Scanner(System.in);
                    String nameP = scanner11.nextLine();
                    if (nameP.equals(pharmacy1.getName())){
                        System.out.println("Все работники: ");
                        System.out.println(pharmacy1.getAllSortedWorkersNameByPharmacyAddress());
                        System.out.println("Введите имя работника которую хотите удалить: ");
                        Scanner scanner10 = new Scanner(System.in);
                        String nameWorker = scanner10.nextLine();
                        pharmacy1.deleteWorkerByName(nameWorker);
                    } else if (nameP.equals(pharmacy2.getName())) {
                        System.out.println("Все работники: ");
                        System.out.println(pharmacy2.getAllSortedWorkersNameByPharmacyAddress());
                        System.out.println("Введите имя работника которую хотите удалить: ");
                        Scanner scanner10 = new Scanner(System.in);
                        String nameWorker = scanner10.nextLine();
                        pharmacy2.deleteWorkerByName(nameWorker);
                    } else if (nameP.equals(pharmacy3.getName())) {
                        System.out.println("Все работники: ");
                        System.out.println(pharmacy3.getAllSortedWorkersNameByPharmacyAddress());
                        System.out.println("Введите имя работника которую хотите удалить: ");
                        Scanner scanner10 = new Scanner(System.in);
                        String nameWorker = scanner10.nextLine();
                        pharmacy3.deleteWorkerByName(nameWorker);
                    } else {
                        System.out.println("Аптеки с таким именем нет");
                    }
                    break;
                case "8":
                    List<Pharmacy> pharmacyList = new ArrayList<>();
                    pharmacyList.add(pharmacy1);
                    pharmacyList.add(pharmacy2);
                    pharmacyList.add(pharmacy3);
                    System.out.println("Введите имя работника: ");
                    Scanner scanner12 =new Scanner(System.in);
                    String nameWork = scanner12.nextLine();
                    for (Pharmacy pharmacy: pharmacyList) {
                        System.out.println(pharmacy.getPharmacyByWorkerName(nameWork));
                    }
                    break;
                case "exit":
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Не правильно выбран режим");
            }

        }while (!word.equals("exit"));
    }
}
