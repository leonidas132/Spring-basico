package com.protalento;

import com.protalento.Ejemplo.CRUD;
import com.protalento.Ejemplo.OpercionMatematica;
import com.protalento.Ejemplo.TipoSaludo;
import com.protalento.bean.BeanConDependencia;
import com.protalento.bean.MiBeanConProperties;
import com.protalento.bean.Mybeans;
import com.protalento.componen.ComponentDependency;
import com.protalento.entidad.Post;
import com.protalento.entidad.User;
import com.protalento.pojo.UserPojo;
import com.protalento.repository.PostRepositori;
import com.protalento.repository.UserRepositorie;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication //habilitar la configuración automática.
public class SpringBasicoApplication implements CommandLineRunner {
	private final Log LOGGER = LogFactory.getLog( SpringBasicoApplication.class);
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
	private MiBeanConProperties properties;
	private UserPojo userPojo;
	private UserRepositorie userRepositorie;
	private PostRepositori postRepositori;

	@Autowired // inyeccion de dependencia
	public SpringBasicoApplication(@Qualifier("componentTwoImple")ComponentDependency componentDepen,Mybeans mybeans,BeanConDependencia beanConDependencia, CRUD crud,OpercionMatematica matematica,TipoSaludo tipoSaludo,
								   MiBeanConProperties properties,UserPojo userPojo,UserRepositorie userRepositorie,PostRepositori postRepositori) {
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
		this.properties = properties;
		this.userPojo = userPojo;
        this.userRepositorie = userRepositorie;
		this.postRepositori = postRepositori;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBasicoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		getSave();



	}

	private  void getSave(){
	//	User user = new User("jose","jose@gmail.com", LocalDate.of(2000,03,20)); //el metodo of nos permite pasar un año, mes y dia
	//	User user2 = new User("maria","maria@gmail.com", LocalDate.of(1996,04,21));
		User user3 = new User("user01","jafe@gmail.com", LocalDate.of(2021,05,22));
		List<User> listaUser = Arrays.asList(user3);
		listaUser.stream().forEach(userRepositorie::save);
		LOGGER.debug(listaUser);

		Post post = new Post("pertenece a user3",user3);
		//Post post2 = new Post("pertenece a maria",user2);
		List<Post> listaPost = Arrays.asList(post);
		listaPost.stream().forEach(postRepositori::save);
	}

	public void ejemplosClaseAnteriores(){
		//   componentDependency.saludar();
		//	mybeans.print();
		//	beanConDependencia.resultadoSuma();
		crud.guardar();
		tipoSaludo.saludoDespedida();
		System.out.println(properties.function());
		System.out.println("Correo: "+ userPojo.getEmail() +" - "+" Password: "+userPojo.getPassword());
		LOGGER.error("esto es un error");
	}
}
