import java.util.Scanner;

// Інтерфейс Currency (Валюта)
interface Currency {
    // Метод для переводу суми в гривні
    double convertToUAH();

    // Метод для виводу інформації на екран
    void print();

    @Override
    String toString();

    @Override
    boolean equals(Object obj);
}

// Похідний клас Dollar (Долар)
class Dollar implements Currency {
    private static final double USD_TO_UAH = 41.28; // курс долара до гривні
    private double amount;

    public Dollar(double amount) {
        this.amount = amount;
    }

    @Override
    public double convertToUAH() {
        return amount * USD_TO_UAH;
    }

    @Override
    public void print() {
        System.out.printf("Amount: %.2f USD (%.2f UAH)\n", amount, convertToUAH());
    }

    @Override
    public String toString() {
        return String.format("%.2f USD", amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dollar dollar = (Dollar) obj;
        return Double.compare(dollar.amount, amount) == 0;
    }
}

// Похідний клас Euro (Євро)
class Euro implements Currency {
    private static final double EUR_TO_UAH = 45.16; // курс євро до гривні
    private double amount;

    public Euro(double amount) {
        this.amount = amount;
    }

    @Override
    public double convertToUAH() {
        return amount * EUR_TO_UAH;
    }

    @Override
    public void print() {
        System.out.printf("Amount: %.2f EUR (%.2f UAH)\n", amount, convertToUAH());
    }

    @Override
    public String toString() {
        return String.format("%.2f EUR", amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Euro euro = (Euro) obj;
        return Double.compare(euro.amount, amount) == 0;
    }
}

// Основний клас
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо кількість валют, яку користувач хоче ввести
        System.out.print("Скільки валют ви хочете ввести? ");
        int n = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        Currency[] currencies = new Currency[n];

        // Вводимо кожну валюту
        for (int i = 0; i < n; i++) {
            System.out.print("Введіть тип валюти (USD або EUR): ");
            String currencyType = scanner.nextLine().toUpperCase();

            System.out.print("Введіть суму: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // очистка буфера

            // Визначаємо, яку валюту створити
            if (currencyType.equals("USD")) {
                currencies[i] = new Dollar(amount);
            } else if (currencyType.equals("EUR")) {
                currencies[i] = new Euro(amount);
            } else {
                System.out.println("Невідомий тип валюти. Введіть USD або EUR.");
                i--; // повертаємося до цього кроку знову
            }
        }

        // Виводимо інформацію про кожну введену валюту
        System.out.println("\nІнформація про введені валюти:");
        for (Currency currency : currencies) {
            currency.print();
        }

        scanner.close();
    }
}
