package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
import com.cryptoRari.entities.Account;
import com.cryptoRari.entities.Hold;
import com.cryptoRari.entities.Ledger;
import com.cryptoRari.marketData.TimeService;
import com.cryptoRari.personal.AccountsService;
import com.cryptoRari.utilities.Constants;
import com.cryptoRari.utilities.Environment;

public class AccountsServiceTest {

	AccountsService accountsService;
	TimeService timeService;
	
	public AccountsServiceTest() {
		this.accountsService = new AccountsService(
				Environment.API_KEY,
				Environment.PASSPHRASE,
				Environment.SECRET
				);
		this.timeService = new TimeService();
	}
	
	//Only works if you have account ID listed in Environments 
	@Test
	public void getAccountsTest() {
		
		ArrayList<Account> accountList = accountsService.getAccounts(
				timeService.getTime().getEpoch()
				);
		
		System.out.println(accountList.toString());
		
		assertTrue(accountList != null);
		assertTrue(accountList.size() > 0);
	}
	
	@Test
	public void getAccountHistory() {
		String accountId = Environment.BTC_ACCOUNT_ID;
		String epochTime = timeService.getTime().getEpoch();
		
		ArrayList<Ledger> accountHistory = accountsService.getAccountHistory(accountId, epochTime);
		
		System.out.println("Account history" + accountHistory);
		
		assertTrue(accountHistory != null);
	}
	
	@Test
	public void getHolds() {
		String accountId = Environment.BTC_ACCOUNT_ID;
		String epochTime = timeService.getTime().getEpoch();
		ArrayList<Hold> holdList = accountsService.getHolds(accountId, epochTime);
		
		System.out.println(holdList);
		
		assertTrue(holdList != null);
	}
}
