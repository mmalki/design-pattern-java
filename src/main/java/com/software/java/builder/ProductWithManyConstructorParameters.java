package com.software.java.builder;

public class ProductWithManyConstructorParameters {

	private final String at1;
	private final String at2;
	private final String at3;
	private final String at4;

	public static ProductBuilder builder(String at1){
		return new ProductBuilder(at1);
	}
	
	public static class ProductBuilder implements Builder<ProductWithManyConstructorParameters>{
		
		private final String at1;
		private String at2 = null;
		private String at3 = null;
		private String at4 = null;
		
		private ProductBuilder(String at1){
			this.at1 = at1;
		}
		
		public ProductBuilder withAttribut2(String at2){
			this.at2 = at2; 
			return this;
		}
		public ProductBuilder withAttribut3(String at3){
			this.at3 = at3; 
			return this;
		}
		public ProductBuilder withAttribut4(String at4){
			this.at4 = at4; 
			return this;
		}
		@Override
		public ProductWithManyConstructorParameters build() {
			// TODO Auto-generated method stub
			return new ProductWithManyConstructorParameters(this);
		}
		
	}

	public ProductWithManyConstructorParameters(ProductBuilder productBuilder) {
		this.at1 = productBuilder.at1;
		this.at2 = productBuilder.at2;
		this.at3 = productBuilder.at3;
		this.at4 =  productBuilder.at4;
	
	}

	public String getAt1() {
		return at1;
	}

	public String getAt2() {
		return at2;
	}

	public String getAt3() {
		return at3;
	}

	public String getAt4() {
		return at4;
	}

}
