public class ContaCorrente extends Conta {
	private double limite;
	
	public ContaCorrente(double limite){
		this.limite = limite;
	
	}

	@Override
	public double getSaldo(){
		return (saldo + limite) - 0.0038*(saldo + limite);
	
	}


}
