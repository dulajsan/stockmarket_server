package StockMarket;

/**
* StockMarket/StockServerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from StockMarket.idl
* Saturday, June 3, 2017 10:47:00 AM IST
*/

public final class StockServerHolder implements org.omg.CORBA.portable.Streamable
{
  public StockMarket.StockServer value = null;

  public StockServerHolder ()
  {
  }

  public StockServerHolder (StockMarket.StockServer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = StockMarket.StockServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    StockMarket.StockServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return StockMarket.StockServerHelper.type ();
  }

}
