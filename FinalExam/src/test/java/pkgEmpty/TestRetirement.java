package pkgEmpty;

import static org.junit.Assert.*;
import org.junit.Test;
import pkgCore.Retirement;

public class TestRetirement {

	@Test
	public void TestCalulations()
	{
		Retirement retirement = new Retirement(40,0.07,20,0.02,10000,2642);
		assertTrue(retirement.AmountToSave() == 554.13);
		assertTrue(retirement.TotalAmountSaved() == 1454485.55);
	}
}
