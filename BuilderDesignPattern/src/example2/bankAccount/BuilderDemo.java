package example2.bankAccount;

public class BuilderDemo {
	private String field1;
	private String field2;
	private String field3;
	
	public static class BuilderDemoInner {
		private String field1;
		private String field2;
		private String field3;
		
		public BuilderDemoInner(String field1) {
			this.field1 = field1;
		}
		
		private String getField1( ) {
			return field1;
		}

		private void setField1(String field1) {
			this.field1 = field1;
		}

		private String getField2() {
			return field2;
		}

		private void setField2(String field2) {
			this.field2 = field2;
		}

		private String getField3() {
			return field3;
		}

		private void setField3(String field3) {
			this.field3 = field3;
		}
		
		public BuilderDemo build() {
			BuilderDemo builderDemo = new BuilderDemo();
			builderDemo.field1 = this.field1;
			builderDemo.field2 = this.field2;
			builderDemo.field3 = this.field3;
			return builderDemo;
		}
		
		private BuilderDemoInner withField1(String field1) {
			this.field1 = field1;
			return this;
		}
		
		private BuilderDemoInner withField2(String field2) {
			this.field2 = field2;
			return this;
		}
		
		private BuilderDemoInner withField3(String field3) {
			this.field3 = field3;
			return this;
		}
		
	}
	
	private BuilderDemo() {
		
	}
		
	private String getField1() {
		return field1;
	}

	private void setField1(String field1) {
		this.field1 = field1;
	}

	private String getField2() {
		return field2;
	}

	private void setField2(String field2) {
		this.field2 = field2;
	}

	private String getField3() {
		return field3;
	}

	private void setField3(String field3) {
		this.field3 = field3;
	}
	
	public static void main (String[] args) {
		BuilderDemo builderDemo = new BuilderDemo.BuilderDemoInner("field1")
		.withField1("field1")
		.withField2("field2")
		.withField3("field3")
		.build();
	}
}
