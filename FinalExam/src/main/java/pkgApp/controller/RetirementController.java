package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML
	private TextField txtAmountToSave;
	@FXML
	private TextField txtTotalAmountSaved;
	
	Retirement retirement = new Retirement();
			
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showNumericParameters(null);
	}
	
	private void showNumericParameters(Retirement retirement) {
		if(retirement != null) {
			txtYearsToWork.setText(Integer.toString(retirement.getiYearsToWork()));
			txtAnnualReturnWorking.setText(Double.toString(retirement.getiYearsToWork()));
			txtYearsRetired.setText(Integer.toString(retirement.getiYearsToWork()));
			txtAnnualReturnRetired.setText(Double.toString(retirement.getiYearsToWork()));
			txtRequiredIncome.setText(Double.toString(retirement.getiYearsToWork()));
			txtMonthlySSI.setText(Double.toString(retirement.getiYearsToWork()));
		}
		else {
			txtYearsToWork.clear();
			txtAnnualReturnWorking.clear();
			txtYearsRetired.clear();
			txtAnnualReturnRetired.clear();
			txtRequiredIncome.clear();
			txtMonthlySSI.clear();
			txtTotalAmountSaved.clear();
			txtAmountToSave.clear();
		}
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		
		txtYearsToWork.clear();
		txtAnnualReturnWorking.clear();
		txtYearsRetired.clear();
		txtAnnualReturnRetired.clear();
		txtRequiredIncome.clear();
		txtMonthlySSI.clear();
		txtTotalAmountSaved.clear();
		txtAmountToSave.clear();
	}
	
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		if (isInputValid()) {
			
			retirement.setiYearsToWork(Integer.parseInt(txtYearsToWork.getText()));
			retirement.setdAnnualReturnWorking(Double.parseDouble(txtAnnualReturnWorking.getText()));
			retirement.setiYearsRetired(Integer.parseInt(txtYearsRetired.getText()));
			retirement.setdAnnualReturnRetired(Double.parseDouble(txtAnnualReturnRetired.getText()));
			retirement.setdRequiredIncome(Double.parseDouble(txtRequiredIncome.getText()));
			retirement.setdMonthlySSI(Double.parseDouble(txtMonthlySSI.getText()));

			txtTotalAmountSaved.setText('$'+ Double.toString(retirement.TotalAmountSaved()));
			txtAmountToSave.setText('$' + Double.toString(retirement.AmountToSave()));
		}
	}
	
	private boolean isInputValid() {
		
		String errorMessage = "";
		
		//Check years to work
        if (txtYearsToWork.getText() == null || txtYearsToWork.getText().length() == 0) {
            errorMessage += "Invalid years to work!\n"; 
        }
        else {
        	//try to parse yearstowork into int
        	try {
        		if(Integer.parseInt(txtYearsToWork.getText()) < 0) {
                	errorMessage += "Invalid years to work, must be positive!\n";
                }
            } 
        	catch (NumberFormatException e) {
                errorMessage += "Invalid years to work (must be an integer)!\n"; 
            }
        }
        
        //Check annual return while working
        if (txtAnnualReturnWorking.getText() == null || txtAnnualReturnWorking.getText().length() == 0) {
            errorMessage += "Invalid working return!\n"; 
        }
        else {
        	//try to parse annual return working into double, check if it's in valid range
        	try {
        		if(Double.parseDouble(txtAnnualReturnWorking.getText()) < 0 || Double.parseDouble(txtAnnualReturnWorking.getText()) > 0.20) {
                	errorMessage += "Invalid working return, must be between 0.00 and 0.20!\n";
                }
            } 
        	catch (NumberFormatException e) {
                errorMessage += "Invalid working return, must be numeric input!\n"; 
            }
        }
        
        //Check years of retirement
        if (txtYearsRetired.getText() == null || txtYearsRetired.getText().length() == 0) {
            errorMessage += "Invalid years of retirement!\n"; 
        }
        else {
        	//try to parse yearsretired into int
        	try {
        		if(Integer.parseInt(txtYearsRetired.getText()) < 0) {
                	errorMessage += "Invalid years of retirement, must be positive!\n";
                }
            } 
        	catch (NumberFormatException e) {
                errorMessage += "Invalid years of retirement (must be an integer)!\n"; 
            }
        }
        
        //check annual return retired
        if (txtAnnualReturnRetired.getText() == null || txtAnnualReturnRetired.getText().length() == 0) {
            errorMessage += "Invalid retirement return!\n"; 
        }
        else {
        	//try to parse annual return retired into double, check to see if in valid range
        	try {
                if(Double.parseDouble(txtAnnualReturnRetired.getText()) < 0 || Double.parseDouble(txtAnnualReturnRetired.getText()) > 0.03) {
                	errorMessage += "Invalid retirement return, must be between 0.00 and 0.03!\n";
                }
            } 
        	catch (NumberFormatException e) {
                errorMessage += "Invalid retirement return, must be numeric input!\n"; 
            }
        }
        
        //test required income
        if (txtRequiredIncome.getText() == null || txtRequiredIncome.getText().length() == 0) {
            errorMessage += "Invalid required income!\n"; 
        }
    	else {
    	//try to parse required income into double
    		try {
    			if(Double.parseDouble(txtRequiredIncome.getText()) < 0) {
                	errorMessage += "Invalid required income, must be positive!\n";
                }
    		} 
    		catch (NumberFormatException e) {
    			errorMessage += "Invalid required income, must be numeric input!\n"; 
        	}
    	}
    
        //check monthlySSI
        if (txtMonthlySSI.getText() == null || txtMonthlySSI.getText().length() == 0) {
            errorMessage += "Invalid SSI payment!\n";
        }
        else {
        	//try to parse monthlySSI into double, check to see if in valid range
        	try {
        		if(Double.parseDouble(txtMonthlySSI.getText()) < 0 || Double.parseDouble(txtMonthlySSI.getText()) > 2642) {
                	errorMessage += "Invalid SSI payment, maximum of $2642/month!\n";
                }
            } 
        	catch (NumberFormatException e) {
                errorMessage += "Invalid SSI payment, must be numeric input!\n"; 
            }
        }
        
        //evaluate boolean
        if (errorMessage.length() == 0) {
            return true;
        } 
        
        else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid inputs");
            alert.setHeaderText("Please correct invalid inputs");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
	}
	
}
