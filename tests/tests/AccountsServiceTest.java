package tests;

import org.junit.Test;

import com.cryptoRari.marketData.TimeService;
import com.cryptoRari.personal.AccountsService;

public class AccountsServiceTest {

	AccountsService accountsService;
	TimeService timeService;
	
	public AccountsServiceTest() {
		this.accountsService = new AccountsService();
		this.timeService = new TimeService();
	}
	
	@Test
	public void getAccountsTest() {
		String response = accountsService.getAccounts(timeService.getTime().getEpoch());
		
		System.out.println(response);
	}
}
