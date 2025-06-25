package net.firstzone.app;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }

    // multiply는 아직 구현되지 않음
    public int multiply(int a, int b) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int divide(int a, int b) {
        return a / b;
    }
    
    public Object f5(int su) {
		if(su%2 == 0 )
			return null;
		else
			return su+100;
	}
    
    
}

