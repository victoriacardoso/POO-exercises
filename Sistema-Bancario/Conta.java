public abstract class Conta {
	protected double saldo;
	
	public void depositar(double valor) {
		saldo+= valor;
	
	}
	
	public abstract double getSaldo();

}
