package com.protalento;

import com.protalento.Ejemplo.CRUD;
import com.protalento.Ejemplo.OpercionMatematica;
import com.protalento.Ejemplo.TipoSaludo;
import com.protalento.bean.BeanConDependencia;
import com.protalento.bean.Mybeans;
import com.protalento.componen.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //habilitar la configuración automática.
public class SpringBasicoApplication implements CommandLineRunner {
	/*CommandLineRunneres una interfaz utilizada para indicar
	 * que un bean debe ejecutarse cuando está contenido dentro de SpringApplicatio
	 */
	// inyectando dependencia

	private ComponentDependency componentDependency;
	private Mybeans mybeans;
	private BeanConDependencia beanConDependencia;
	private CRUD crud;
	private OpercionMatematica matematica;
	private TipoSaludo tipoSaludo;

	@Autowired //

	public SpringBasicoApplication(@Qualifier("componentTwoImple")ComponentDependency componentDepen,Mybeans mybeans,BeanConDependencia beanConDependencia, CRUD crud,OpercionMatematica matematica,TipoSaludo tipoSaludo) {
		/* cuando implementamos una dependecia para
		* varias clases tenemos que especificarle a spring cual utilizar
		* para eso hacemos uso de la anotacion @Qualifier y el nombre de la depndencia
		* */
		this.componentDependency = componentDepen;
		this.mybeans = mybeans;
		this.beanConDependencia = beanConDependencia;
		this.crud = crud;
		this.matematica = matematica;
		this.tipoSaludo = tipoSaludo;

	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBasicoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
     //   componentDependency.saludar();
	//	mybeans.print();
	//	beanConDependencia.resultadoSuma();
		crud.guardar();
		tipoSaludo.saludoDespedida();

	}
}
