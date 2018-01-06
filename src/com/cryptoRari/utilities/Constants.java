package com.cryptoRari.utilities;

public abstract class Constants {
	
	public static final String URL = "https://api-public.sandbox.gdax.com";
	//public static final String URL = "https://api.gdax.com";
	
	//Http Constants
	public static class HTTP {
		public static final String SCHEME = "https://";
		
		public static class Methods {
			public static final String GET = "GET";
			public static final String POST = "POST";
			public static final String DELETE = "DELETE";
		}

		public static class DataTypes {
			public static final String  JSON = "application/json";
		}
	}
	
	//GDAX Constants
	public static class GDAX {
		
		public static class MarketPaths {
			public static final String CURRENCIES = "/currencies";
			public static final String TIME = "/time";
			public static final String PRODUCTS = "/products";
			public static final String TICKER = "/ticker";
			public static final String BOOKLVL1 = "/book";
			public static final String BOOKLVL2 = "/book?level=2";
			public static final String TRADES = "/trades";
			public static final String STATS = "/stats";
			public static final String CANDLES = "/candles";
		}
		
		public static class PrivatePaths {
			public static final String ACCOUNTS = "/accounts";
			public static final String ACCOUNT_HISTORY = "/ledger";
			public static final String HOLDS = "/holds";
			public static final String ORDERS = "/orders";
		}
		
		public static class ProductIds {
			public static final String BTC_PRODUCT_ID = "/BTC-USD";
			public static final String ETH_PRODUCT_ID = "/ETH-USD";
			public static final String LTC_PRODUCT_ID = "/LTC-USD";
		}
		
		public static class Currencies {
			public static final String BITCOIN = "BTC-USD";
			public static final String ETHEREUM = "ETH-USD";
			public static final String LITECOIN = "LTC-USD";
		}

		public static class Orders {
			public static class Parameters {
				public static final String PRODUCT_ID = "product_id";
			}

			public static class Side {
				public static final String BUY = "buy";
				public static final String SELL = "sell";
			}

			public static class Type {
				public static final String LIMIT = "limit";
				public static final String MARKET = "market";
				public static final String STOP = "stop";
			}

			public class TimeInForce {
				public static final String GTC = "GTC";
				public static final String GTT = "GTT";
				public static final String IOC = "IOC";
				public static final String FOK = "FOK";
			}

			public class CancelAfter {
				public static final String MIN = "min";
				public static final String HOUR = "hour";
				public static final String DAY = "day";
			}

			public class Statuses {
				public static final String OPEN = "open";
				public static final String PENDING = "pending";
				public static final String ACTIVE = "active";
				public static final String DONE = "done";
				public final static String SETTLED = "settled";
				public final static String ALL = "all";
			}
		}
		
		public static class Headers {
			public static final String CB_ACCESS_KEY = "CB-ACCESS-KEY";
			public static final String CB_ACCESS_SIGN = "CB-ACCESS-SIGN";
			public static final String CB_ACCESS_TIMESTAMP = "CB-ACCESS-TIMESTAMP";
			public static final String CS_ACCESS_PASSPHRASE = "CB-ACCESS-PASSPHRASE";
			public static final String ACCEPT = "accept";
			public static final String CONTENT_TYPE = "content-type";
		}
	}
}
