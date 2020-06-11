
package software;
/**
 * This class is used to set balance and do some operations like Withdraw and deposit . 
 * @author كريم
 */
public class Ewallet
{
    public double Balance = 1000;
    /**
     * Used to set the balance in ewallet .
     * @param B it is data type double .
     */
    public void Set_Balance( double B)
    {
        Balance = B ;
    }
    /**
     * Used to get the balance from ewallet .
     * @return the balance from ewallet .
     */
    public double Get_Balance ()
    {
        return Balance ;
    }
    /**
     * this method used to withdraw the balance from ewallet .
     * @param cash this is the money is withdrawal from ewallet and it is data type double .
     */
    public void Withdraw ( double cash )
    {

            Balance -= cash ;

    }
    /**
     * this method used to deposit the balance to ewallet .
     * @param cash this is the money is deposited to ewallet and it is data type double .
     */
    public void Deposite ( double cash )
    {

        Balance += cash ;
    }
}