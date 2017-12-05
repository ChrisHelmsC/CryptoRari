package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
import com.cryptoRari.entities.Account;
import com.cryptoRari.marketData.TimeService;
import com.cryptoRari.personal.AccountsService;
import com.cryptoRari.utilities.Constants;
import com.cryptoRari.utilities.Environment;

public class AccountsServiceTest {

	AccountsService accountsService;
	TimeService timeService;
	
	public AccountsServiceTest() {
		this.accountsService = new AccountsService();
		this.timeService = new TimeService();
	}
	
	@Test
	public void getAccountsTest() {
		
		ArrayList<Account> accountList = accountsService.getAccounts(
				timeService.getTime().getEpoch(),
				Environment.API_KEY,
				Environment.PASSPHRASE,
				Environment.SECRET
				);
		
		System.out.println(accountList.toString());
		
		assertTrue(accountList != null);
		assertTrue(accountList.size() > 0);
	}
}
