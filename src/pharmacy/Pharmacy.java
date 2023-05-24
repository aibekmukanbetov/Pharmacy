package pharmacy;

import java.util.ArrayList;
import java.util.Arrays;
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
        return medicines;
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
        try {
            if (medicine.getPrice()<200){
                throw  new RuntimeException("Цена должен быть больше 200");
            } else {
                medicines.add(medicine);
                for (Medicines med: medicines){
                    System.out.println(med);
                }
            }
        } catch (RuntimeException r){
            System.err.println(r.getMessage());
        }

    }
/*    public void addMedicinesToPharmacy(Medicines medicine){
        Medicines[] medicines1 = new Medicines[medicines.length+1];
        System.arraycopy(medicines, 0, medicines1, 0, medicines.length);
        medicines1[medicines.length] = medicine;
        for (Medicines med: medicines1) {
            System.out.println(Arrays.toString(new Medicines[]{med}));
        }
    }*/
    // добавить лекарства в аптеку


    @Override
    public void addWorkerToPharmacy(Worker worker) {
        try {
            if (isWorkerEmailExists(worker.getEmail())) {
                throw  new RuntimeException("Работник с таким аккаунтом уже существует");
//                System.out.println("Работник с таким аккаунтом уже существует");
            } else {
                workers.add(worker);
                for (Worker work : workers) {
                    System.out.println(work);
                }
            }
        } catch (RuntimeException run){
            System.err.println(run.getMessage());
        }
    }
    private boolean isWorkerEmailExists(String email) {
        for (Worker worker : workers) {
            if (worker.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateMedicinePrice(String medicineName, int newPrice){
        for (Medicines medicines1 : medicines) {
            try {
                if (medicines1.getPrice()==newPrice){
                    throw new RuntimeException("Введите другую цену чем прошлый");
                }
        } catch (RuntimeException e){
                System.err.println(e.getMessage());
            }
            if (medicines1.getName().equals(medicineName)) {
                medicines1.setPrice(newPrice);
                break;
            }

    }
        System.out.println(medicines);

} // обновить цену лекарства

    @Override
   public void  deleteMedicineByName(String medicineName){
/*        for (Medicines medName: medicines) {
            if(medName.getName().equals(medicineName)){
                medicines.remove(medName);
            }
        }*/
        for (int i=0; i<=medicines.size(); i++) {
            if(medicines.get(i).getName().equals(medicineName)){
                medicines.remove(medicines.get(i));
            }
        }
        System.out.println(medicines);
    } // удалить лекарсво по названию

    @Override
   public void deleteWorkerByName(String workerName){
  /*      for (Worker worker: workers) {
            if (worker.getName().equals(workerName)){
                workers.remove(worker);
            }
        }*/
        for (int i =0; i<=workers.size(); i++) {
            if (workers.get(i).getName().equals(workerName)){
                workers.remove(workers.get(i));
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

