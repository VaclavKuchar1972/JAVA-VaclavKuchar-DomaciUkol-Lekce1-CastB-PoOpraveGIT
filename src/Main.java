import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        // Předem se Ti omlouvám za nadměrné množství poznámek v kódu, ale bylo to v zadání domácího úkolu,
        // jen ta jedna následující je pro mě, ostatní pro Tebe Přemku (tykání) :-) jako pro lektora,
        // aby jsi chápal jak uvažuji, co se týče samotného kódu a HLAVNĚ jestli to uvažování dělám dobře.? Děkuji. VK

        // TENTO KUS ZADÁNÍ ÚKOLU MUSÍM VYŘEŠIT NA KONZULTACI, nemám páru o co jde.
        // Pokud to umíš, můžeš založit novou třídu a údaje o prodejcích zapsat jako atributy této třídy.

        // ZAČÁTEK definice a naplnění potřebných proměnných
        boolean zeroNOdivide = false;

        String name = "VÁCLAV";
        String surname = "KUCHAŘ";
        LocalDate dateBirth = LocalDate.of(1972,4,1);
        LocalDate todayDate = LocalDate.now();
        String dealerCity = "Praha";
        String dealerCountry = "Česká republika";
        int[] dealerIPaddress = {192,168,2,135};
        String dealerVehicleRgPlate = "1AJ 2698";
        // Toto proměnná je jednoznačně nekdůležitější proměnná ke splenění domácího úkolu, šlo by to zobrazit i bez ní,
        // ale pořádek v programování musí být, jinak se z toho všichni POse.... :D
        BigDecimal dealerAverageNbCarrotsSoldPerContractInKg = null;

        // Tady jsem váhal, co tam dát, Double i Long mi přišli zbytečně moc, tak kdyžtak na konzultaci... :-)
        int numberOfcontracts = 35658;

        // Copak já vím, jestli se mrkev prodává ve velkým na "kg" nebo na "g"? ...připravil jsem to na "kg",
        // to by mělo stačit... ...samozřejmě s výsledkem v "t" počítám. :-)
        BigDecimal dealerTotalQntCarrotsSoldTonnes = new BigDecimal("11326.235948");

        // Tady nevím, podle čeho to počítaj, myslím, že palubní počítač v autě to dává na desetiny,
        // ale jestli to počítají podle ujetých kilometrů a účtenek, tak jsem to dal raději také
        // na šet desetinných míst.

        BigDecimal vehicleFuelConsumptionInLper100km = new BigDecimal("6.859623");
        // KONEC definice a naplnění potřebných proměnných


        // ZAČÁTEK provedení jednoduchého samotného výpočtu ke splnění domácího úkolu

        // TENTO KUS ZADÁNÍ ÚKOLU MUSÍM VYŘEŠIT NA KONZULTACI, dělal jsem vše možné, ale nedokázal jsem
        // do proměnné "dealerAverageNbCarrotsSoldPerContractInKg" zapsat výsledek bez zaokroulení
        // TOTO byl velkej ZÁSEK, asi na HODINU!!!, nepomohl ani ChatGPT - vzdal jsem to, nechávám to takto :-(
        // ...asi to souvisí s maximální velikostí POLE pro proměnnou BigDouble, ale NEVÍM (stále nuly a jedničky...)
        // ...to by mě pak ale zajímalo, ja se dělaj skutečný MATEMATICKÝ výpočty, kdy zlomek musí být fakt zlomkem?!
        // ...další pro mě řečnická otázka - JDE TO V JAVA? - BANKÁM TO JE Upr... jestli nejde...?
        // ...vědcům rozhodně NE!

        // ošetření nepatřičného dělení nulou a výstup pro případné další pokračování programu
        if (0 == numberOfcontracts) {
            zeroNOdivide = true;
        } else {
            dealerAverageNbCarrotsSoldPerContractInKg =
                    dealerTotalQntCarrotsSoldTonnes.divide(BigDecimal.valueOf(numberOfcontracts), 12,
                            RoundingMode.CEILING).multiply(BigDecimal.valueOf(1000)).stripTrailingZeros();
        }
        // KONEC provedení jednoduchého samotného výpočtu ke splnění domácího úkolu

        // ZAČÁTEK Výstupu
        System.out.println(" ");
        System.out.println(">CELKOVÉ PRODEJNÍ VÝSLEDKY DLE JEDNOTLIVÉHO OBCHDNÍKA V PRODEJI MRKVE< KE DNI "
                + todayDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("   OSOBNÍ ÚDAJE HODNOCENÉHO OBCHODNÍKA");
        System.out.println("              Jméno obchodníka: " + name + " " + surname);
        System.out.println("     Datum narození obchodníka: " +
                dateBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("                        Lokace: " + dealerCountry + " ve městě " + dealerCity);
        System.out.println("      IP adresa jeho připojení: " + dealerIPaddress[0] + "." + dealerIPaddress[1] + "."
                + dealerIPaddress[2] + "." + dealerIPaddress[3]);
        System.out.println("        SPZ vozidla obchodníka: " + dealerVehicleRgPlate);
        System.out.println("   STATISTIKA HODNOCENÉHO OBCHODNÍKA");
        System.out.println("Průměrná spotřeba jeho vozidla: " + (String.format("%.2f l dieslu / 100 km",
                vehicleFuelConsumptionInLper100km).replace(".", ",")));
        System.out.println(" K denšnímu dni sejdnal celkem: " + numberOfcontracts + " smluv");
        System.out.println("  K denšnímu dni prodal celkem: " + (String.format("%.2f tun",
                dealerTotalQntCarrotsSoldTonnes).replace(".", ",")) + " mrkve");
        System.out.println("JEHO PRŮMĚRNÁ PRODEJNOST MRKVE: " + (String.format("%.2f kg ",
                dealerAverageNbCarrotsSoldPerContractInKg).replace(".", ",")) + "/ jedna smlouva");
        // KONEC Výstupu
    }
}