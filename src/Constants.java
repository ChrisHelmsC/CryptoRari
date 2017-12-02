
public class Constants {
	//Http Constants
	public class HTTP {
		public static final String SCHEME = "https";
	}
	
	//GDAX Constants
	public class GDAX {
		public static final String HOST = "https://api-public.sandbox.gdax.com";
		
		public class Paths {
			public static final String CURRENCIES = "/currencies";
		}
		
		public class Currencies {
			public static final String BITCOIN = "BTC";
		}
		
		public class Headers {
			public static final String CB_ACCESS_KEY = "CB-ACCESS-KEY";
			public static final String CB_ACCESS_SIGN = "CB-ACCESS-SIGN";
			public static final String CB_ACCESS_TIMESTAMP = "CB-ACCESS-TIMESTAMP";
			public static final String CS_ACCESS_PASSPHRASE = "CB-ACCESS-PASSPHRASE";
		}
	}
}
