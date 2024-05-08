package techacadmy;
import java.util.Scanner;

public class It_Calculator {


	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("Enter Taxable Income: ");
	        double TaxableIncome = scanner.nextDouble();
	        
	        double TaxPaidPerYear;
	        double TaxPayablePerMonth;
	        
	        if (TaxableIncome <= 25000) {
	            TaxPaidPerYear = 0;
	        } else if (TaxableIncome <= 50000) {
	            TaxPaidPerYear = TaxableIncome * 0.1;
	        } else if (TaxableIncome <= 75000) {
	            TaxPaidPerYear = TaxableIncome * 0.2;
	        } else {
	            TaxPaidPerYear = TaxableIncome * 0.3;
	        }
	        
	        TaxPayablePerMonth = TaxPaidPerYear / 12;
	        
	        System.out.println("Tax Paid Per Year: $" + TaxPaidPerYear);
	        System.out.println("Tax Payable Per Month: $" + TaxPayablePerMonth);
	        
	        scanner.close();
	    }
	}
	

