package pharmacy;

import java.util.List;

public interface Method {

    List<Medicines> getAllMedicinesByPharmacyName();  // получить все лекарства по имени аптеки
    List<String> getAllSortedWorkersNameByPharmacyAddress(); // Нужно вывести отсортированные  по имени работников аптеки
     void addMedicinesToPharmacy(Medicines medicine);// добавить лекарства в аптеку
     void addWorkerToPharmacy(Worker worker); // добавить работнка в аптеку
     void updateMedicinePrice(String medicineName, int newPrice); // обновить цену лекарства
     // через set метод
     void  deleteMedicineByName(String medicineName); // удалить лекарсво по названию
     void deleteWorkerByName(String workerName); // удалить работника по имени

     Pharmacy getPharmacyByWorkerName(String workerName);  // получить аптеку по имени работника
}
