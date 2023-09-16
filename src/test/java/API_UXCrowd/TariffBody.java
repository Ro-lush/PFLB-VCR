package API_UXCrowd;

public class TariffBody {
    public Currency currency;
    public String name;
    public int ourTesterCount;
    public long price;
    public int theirTestsCount;

    public TariffBody(Currency currency, String name, int ourTesterCount, long price, int theirTestsCount) {
        this.currency = currency;
        this.name = name;
        this.ourTesterCount = ourTesterCount;
        this.price = price;
        this.theirTestsCount = theirTestsCount;
    }

    public TariffBody(){}
    public Currency getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public int getOurTesterCount() {
        return ourTesterCount;
    }

    public long getPrice() {
        return price;
    }

    public int getTheirTestsCount() {
        return theirTestsCount;
    }

    public enum Currency {
        USD, RUB
    }
}
