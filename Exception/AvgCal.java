public class AvgCal {
    public static double average(String[] numbers) throws NullPointerException, NumberFormatException {
        if (numbers == null) {
            throw new NullPointerException("Array is null");
        }

        double sum = 0;
        int count = 0;
        for (String number : numbers) {
            if (number == null) {
                throw new NullPointerException("Element is null");
            }
            try {
                double num = Double.parseDouble(number);
                sum += num;
                count++;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Element is incorrectly formatted: " + number);
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        return sum / count;
    }

    public static void main(String[] args) {
        String[] numbers = {"0", "20", "30","88",""};
        try {
            double avg = average(numbers);
            System.out.println("Average: " + avg);
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
