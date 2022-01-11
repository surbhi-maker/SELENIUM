package Enum;

public interface EnumInterface {
	
	 public enum OrderingRestOperations {
		
		 
		 APPLICATION_AUTH_TOKEN("ApplicationAuthToken"),
		 REST_CALL_SEPARATOR("-------------------------------------------END Of REST CALL------------------------------------------------");
		 
		 private final String value;

			OrderingRestOperations(final String value) {
				this.value = value;
			}
			
			@Override
			public String toString() {
				return value;
			}
	 }
	
}
