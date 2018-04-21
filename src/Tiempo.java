//Project by Juan Torres G�mez

/*	Esta clase almacena la hora y la fecha simulada, as� como el clima y el proceso para calcularlo.
 * 	Tambi�n controla los elementos que se mostrar�n en la ventana de CLIMA
 */
public class Tiempo {
	private int minuto;
	private int hora;
	private int dia;
	private int mes;
	private int anyo;
	
	private int viento;	//en km/h
	private int sol;
	
	private int ticksToNextEvent;	//Cuando llegue a 0, el clima cambiar�. La variable se reestablecer� a un valor aleatorio.
	
	public Tiempo() {
		this.minuto = 00;
		this.hora = 00;
		this.dia = 1;
		this.mes = 1;
		this.anyo = 2018;
	}
	
	
	public void Step() {	//Se ejecuta por cada ciclo de reloj.
		minuto += 4;	//Cada ciclo de reloj, ser� 22 minutos.
		
		if(minuto >= 60) {
			minuto -= 60;
			hora++;
		}
		if(hora >= 24) {
			hora = 0;
			dia++;
		}
		if(dia > 31) {
			dia = 1;
			mes++;
		}
		if(mes > 12) {
			mes = 1;
			anyo ++;
		}
		Climawindow.lblFecha.setText(dateToString());
	}

	public String dateToString() {
		String minToReturn = minuto < 10 ? "0"+minuto : minuto+"";
		String horToReturn = hora < 10 ? "0"+hora : hora+"";
		String diaToReturn = dia < 10 ? "0"+dia: dia+"";
		String mesToReturn = mes< 10 ? "0"+mes: mes+"";
		String anyoToReturn = anyo< 10 ? "0"+anyo : anyo+"";
		
		return diaToReturn + "/" + mesToReturn + "/" + anyoToReturn + " - " + horToReturn + ":" + minToReturn;
	}
}