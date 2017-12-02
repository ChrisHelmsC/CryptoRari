
public abstract class Constants {
	//Http Constants
	public static class HTTP {
		public static final String SCHEME = "https";
	}
	
	//GDAX Constants
	public static class GDAX {
		public static final String HOST = "api.gdax.com";
		public static final String SANDBOX_HOST = "api-public.sandbox.gdax.com";
		
		public static class MarketPaths {
			public static final String CURRENCIES = "/currencies";
			public static final String TIME = "/time";
			public static final String PRODUCTS = "/products";
			public static final String TICKER = "/ticker";
		}
		
		public static class PRODUCT_IDS {
			public static final String BTC_PRODUCT_ID = "/BTC-USD";
		}
		
		public static class Currencies {
			public static final String BITCOIN = "BTC";
		}
		
		public static class Headers {
			public static final String CB_ACCESS_KEY = "CB-ACCESS-KEY";
			public static final String CB_ACCESS_SIGN = "CB-ACCESS-SIGN";
			public static final String CB_ACCESS_TIMESTAMP = "CB-ACCESS-TIMESTAMP";
			public static final String CS_ACCESS_PASSPHRASE = "CB-ACCESS-PASSPHRASE";
		}
	}
}
