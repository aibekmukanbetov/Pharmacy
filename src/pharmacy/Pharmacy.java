package pharmacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pharmacy implements Method{

    private String name;
    private  String address;
    private List<Medicines> medicines;
    private List<Worker> workers;


    public Pharmacy(String name, String address, List<Medicines> medicines, List<Worker> workers) {
        this.name = name;
        this.address = address;
        this.medicines = medicines;
        this.workers = workers;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Medicines> getMedicines() {
        return medicines;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    @Override
    public String toString() {
        return "Pharmacy{" + " name: " + name + ", address: " + address + ", medicines= " + medicines +  ", workers= " + workers + '}';
    }



    @Override
    public List<Medicines> getAllMedicinesByPharmacyName() {
        List<Medicines> result = new ArrayList<>();
            result.addAll(medicines);
        return result;
    }
    // получить все лекарства по имени аптеки


    @Override
    public List<String> getAllSortedWorkersNameByPharmacyAddress(){
        List<String> result = new ArrayList<>();
            for (Worker worker : workers) {
                result.add(String.valueOf(worker));
            }
            Collections.sort(result);
        return result;
    } // Нужно вывести отсортированные  по имени работников аптеки

    @Override
   public void addMedicinesToPharmacy(Medicines medicine){
            List<Medicines> medicines1 = new ArrayList<>();
            medicines1.addAll(medicines);
            medicines1.add(medicine);
            for (Medicines med: medicines1){
                 System.out.println(med);
            }
    }// добавить лекарства в аптеку


    @Override
    public void addWorkerToPharmacy(Worker worker) {
            List<Worker> workers1 = new ArrayList<>();
            workers1.addAll(workers);
            if (workers1.equals(worker.getEmail())){
                System.out.println("Работник с таким логином уже существует");
            } else {
                workers1.add(worker);
            }
    }

    @Override
    public void updateMedicinePrice(String medicineName, int newPrice){
        for (Medicines medicines1 : medicines) {
        if (medicines1.getName().equals(medicineName)) {
            medicines1.setPrice(newPrice);
            break;
        }
    }
        System.out.println(medicines);

} // обновить цену лекарства

    @Override
   public void  deleteMedicineByName(String medicineName){
        for (Medicines medName: medicines) {
            if(medName.getName().equals(medicineName)){
                medicines.remove(medName);
            }
        }
        System.out.println(medicines);
    } // удалить лекарсво по названию

    @Override
   public void deleteWorkerByName(String workerName){
        for (Worker worker: workers) {
            if (worker.getName().equals(workerName)){
                workers.remove(worker);
            }
        }
        System.out.println(workers);
    } // удалить работника по имени

@Override
    public  Pharmacy getPharmacyByWorkerName(String workerName ) {
        for (Worker worker : workers) {
            if (worker.getName().equals(workerName)) {
                return this;
            }
        }
        return null;
    }



}
