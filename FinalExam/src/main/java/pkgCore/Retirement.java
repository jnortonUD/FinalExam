package pkgCore;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
	public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, 
			double dAnnualReturnRetired, double dRequiredIncome, double dMonthlySSI) {
		this.iYearsToWork = iYearsToWork;
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;
	}
	
	public Retirement() {
		// TODO Auto-generated constructor stub
	}

	public double AmountToSave()
	{
		//	Annuity calculation
		double r = dAnnualReturnWorking / 12; //interest rate per month
		double n = iYearsToWork * 12; //months of working
		double goal = this.TotalAmountSaved(); //savings needed
		double save = Math.round(goal/((Math.pow(1+r, n) - 1)/r)*100.0)/100.0;
		return save;
	}
	
	public double TotalAmountSaved()
	{
		//	Amortization calculation
		double r1 = dAnnualReturnRetired / 12; //interest rate per month
		double n1 = iYearsRetired * 12; //months retired
		double netSpend = dRequiredIncome - dMonthlySSI; //monthly spending
		double Savings = Math.round((netSpend)/((r1*Math.pow(1+r1, n1))/(Math.pow(1+r1, n1) - 1))*100.0)/100.0;
		return Savings;
	}

	public int getiYearsToWork() {
		return iYearsToWork;
	}

	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}

	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}

	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	public int getiYearsRetired() {
		return iYearsRetired;
	}

	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}

	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}

	public double getdRequiredIncome() {
		return dRequiredIncome;
	}

	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}

	public double getdMonthlySSI() {
		return dMonthlySSI;
	}

	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}
}
