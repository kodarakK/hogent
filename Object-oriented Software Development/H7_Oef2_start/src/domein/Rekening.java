package domein;

public class Rekening
{
    private final long rekeningNr;
    private double saldo;
    protected String houder;
    private static final String DEFAULT_NAAM = "onbekend";
    private static final long DEFAULT_REKNR = 0L;

    public Rekening(long rekeningNr, String houder)
    {
        setHouder(houder);
        controleerRekeningNr(rekeningNr);
        this.rekeningNr = rekeningNr;
    }
    
    public Rekening() {
    	this(DEFAULT_REKNR, DEFAULT_NAAM);
    }

    private void controleerRekeningNr(long rekeningNr)
    {
        long eerste10 = rekeningNr / 100;
        int rest = (int) (rekeningNr % 100);

        if (!(eerste10 % 97 == rest || (eerste10 % 97 == 0 && rest == 97)))
        {
            throw new IllegalArgumentException("Rekeningnummer moet correct zijn");
        }
    }

    private void setHouder(String houder)
    {
        if (houder == null || houder.isBlank())
        {
            throw new IllegalArgumentException("Houder mag niet leeg zijn");
        }
        this.houder = houder;
    }

//    private void setRekeningNr(long rekeningNr)
//    {
//        controleerRekeningNr(rekeningNr);
//        this.rekeningNr = rekeningNr;
//    }

    
    public long getRekeningNr()
    {
        return rekeningNr;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public String getHouder()
    {
        return houder;
    }

    @Override
    public String toString()
    {
        long eerste3 = rekeningNr / 1000000000;
        long rest = rekeningNr % 100;
        long midden7 = (rekeningNr / 100) % 10000000;

        return String.format("%s%s %03d-%07d-%02d%n%s %s%n%s%.2f %s",
                "Rekening", " met rekeningnummer", eerste3, midden7, rest,
                "staat op naam van", this.getClass().getSimpleName(),
                "en bevat ", saldo, "euro");
    }

    public boolean stortOp(double bedrag)
    {
        if (bedrag > 0 && getSaldo()>bedrag)
        {
            saldo += bedrag;
            return true;
        }
        return false;
    }

    public boolean haalAf(double bedrag)
    {
        if (bedrag > 0)
        {
            saldo -= bedrag;
            return true;
        }

        return false;
    }

    public boolean schrijfBedragOverNaar(double bedrag, Rekening naarRek)
    {
        boolean succes = false;
        if (naarRek != null && haalAf(bedrag))
        {
            succes = naarRek.stortOp(bedrag);
            if (!succes)
            {
                stortOp(bedrag);
            }
        }
        return succes;
    }

} //einde klasse Rekening
