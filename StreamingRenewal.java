import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    LocalDate startDate;

    Plan(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract int getDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getDays());
    }
}

class Basic extends Plan {
    Basic(LocalDate date) {
        super(date);
    }

    int getDays() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(LocalDate date) {
        super(date);
    }

    int getDays() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(LocalDate date) {
        super(date);
    }

    int getDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            Plan p;

            if (type.equals("BASIC"))
                p = new Basic(date);
            else if (type.equals("STANDARD"))
                p = new Standard(date);
            else
                p = new Premium(date);

            System.out.println(name + ": " + p.getRenewalDate());
        }
    }
}