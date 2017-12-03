package entities;

public class Product {
	
	private String id;
	private String base_currency;
	private String quote_currency;
	private double base_min_size;
	private double base_max_size;
	private double quote_increment;
	
	public Product() {}
	
	public Product(String id, String base_currency, String quote_currency, double base_min_size, double base_max_size,
			double quote_increment) {
		super();
		this.id = id;
		this.base_currency = base_currency;
		this.quote_currency = quote_currency;
		this.base_min_size = base_min_size;
		this.base_max_size = base_max_size;
		this.quote_increment = quote_increment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBase_currency() {
		return base_currency;
	}

	public void setBase_currency(String base_currency) {
		this.base_currency = base_currency;
	}

	public String getQuote_currency() {
		return quote_currency;
	}

	public void setQuote_currency(String quote_currency) {
		this.quote_currency = quote_currency;
	}

	public double getBase_min_size() {
		return base_min_size;
	}

	public void setBase_min_size(double base_min_size) {
		this.base_min_size = base_min_size;
	}

	public double getBase_max_size() {
		return base_max_size;
	}

	public void setBase_max_size(double base_max_size) {
		this.base_max_size = base_max_size;
	}

	public double getQuote_increment() {
		return quote_increment;
	}

	public void setQuote_increment(double quote_increment) {
		this.quote_increment = quote_increment;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", base_currency=" + base_currency + ", quote_currency=" + quote_currency
				+ ", base_min_size=" + base_min_size + ", base_max_size=" + base_max_size + ", quote_increment="
				+ quote_increment + "]";
	}
	
	
	
	

}
