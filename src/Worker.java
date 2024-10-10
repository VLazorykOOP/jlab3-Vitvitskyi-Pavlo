import java.util.ArrayList;
import java.util.Scanner;

// Суперклас Worker (Робітник)
abstract class Worker {
    protected String name;
    protected int age;
    protected String position;
    protected int experience;

    public Worker(String name, int age, String position, int experience) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.experience = experience;
    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Position: " + position);
        System.out.println("Experience: " + experience + " years");
    }
}

// Підклас HR (Кадри)
class HR extends Worker {
    private String hrSpecialization;

    public HR(String name, int age, String position, int experience, String hrSpecialization) {
        super(name, age, position, experience);
        this.hrSpecialization = hrSpecialization;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("HR Specialization: " + hrSpecialization);
    }
}

// Підклас Engineer (Інженер)
class Engineer extends Worker {
    private String engineeringField;

    public Engineer(String name, int age, String position, int experience, String engineeringField) {
        super(name, age, position, experience);
        this.engineeringField = engineeringField;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Engineering Field: " + engineeringField);
    }
}

// Підклас Administration (Адміністрація)
class Administration extends Worker {
    private String department;

    public Administration(String name, int age, String position, int experience, String department) {
        super(name, age, position, experience);
        this.department = department;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Department: " + department);
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Скільки робітників ви хочете додати? ");
        int workerCount = sc.nextInt();
        sc.nextLine(); // очищення буфера після введення числа

        for (int i = 0; i < workerCount; i++) {
            System.out.println("Введіть інформацію про робітника #" + (i + 1));

            System.out.print("Ім'я: ");
            String name = sc.nextLine();

            System.out.print("Вік: ");
            int age = sc.nextInt();
            sc.nextLine(); // очищення буфера

            System.out.print("Посада: ");
            String position = sc.nextLine();

            System.out.print("Досвід роботи (років): ");
            int experience = sc.nextInt();
            sc.nextLine(); // очищення буфера

            System.out.print("Тип робітника (HR, Engineer, Administration): ");
            String workerType = sc.nextLine();

            switch (workerType.toLowerCase()) {
                case "hr":
                    System.out.print("HR спеціалізація: ");
                    String hrSpecialization = sc.nextLine();
                    workers.add(new HR(name, age, position, experience, hrSpecialization));
                    break;
                case "engineer":
                    System.out.print("Інженерна спеціалізація: ");
                    String engineeringField = sc.nextLine();
                    workers.add(new Engineer(name, age, position, experience, engineeringField));
                    break;
                case "administration":
                    System.out.print("Відділ: ");
                    String department = sc.nextLine();
                    workers.add(new Administration(name, age, position, experience, department));
                    break;
                default:
                    System.out.println("Невідомий тип робітника. Спробуйте знову.");
                    i--; // повторний ввід для цього робітника
                    break;
            }
            System.out.println("----------------------");
        }

        // Виводимо інформацію про всі об'єкти в масиві
        System.out.println("\nІнформація про введених робітників:");
        for (Worker worker : workers) {
            worker.show();
            System.out.println("----------------------");
        }

        sc.close();
    }
}
