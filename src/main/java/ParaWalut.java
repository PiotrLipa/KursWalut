import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
    class ParaWalut {

    Map<String, Double> waluty = new HashMap<>();

    public ParaWalut() {
        waluty.put("PLNUSD", 0.20);
        waluty.put("USDPLN", 3.62);
        waluty.put("EURUSD", 1.28);
        waluty.put("USDEUR", 0.84);
        waluty.put("CHFUSD", 1.00);
        waluty.put("USDCHF", 1.00);
    }

    public double wynik(String nazwaWalut, double kwota) {
        if (kwota < 0) {
            OpisBledu nowy = new OpisBledu(kwota, "więksa liczba od tysiąca");
            throw new LiczbaMniejszaOdZera(nowy);
        }
        return waluty.get(nazwaWalut) * kwota;
    }
}
