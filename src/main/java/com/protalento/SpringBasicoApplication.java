package com.protalento;

import com.protalento.Ejemplo.CRUD;
import com.protalento.Ejemplo.OpercionMatematica;
import com.protalento.Ejemplo.TipoSaludo;
import com.protalento.bean.BeanConDependencia;
import com.protalento.bean.MiBeanConProperties;
import com.protalento.bean.Mybeans;
import com.protalento.componen.ComponentDependency;

import com.protalento.entidad.User;
import com.protalento.pojo.UserPojo;
import com.protalento.repository.Crud;
import com.protalento.repository.PostRepositori;
import com.protalento.repository.UserRepositorie;
import com.protalento.services.UserService;
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
	/*CommandLineRunneres una interfaz utilizada para indicar
	 * que un bean debe ejecutarse cuando está contenido dentro de SpringApplicatio
	 */
	private final Log LOGGER = LogFactory.getLog( SpringBasicoApplication.class);

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
    private Crud crud2;

	private UserService userService;
	@Autowired // inyeccion de dependencia
	public SpringBasicoApplication(@Qualifier("componentTwoImple")ComponentDependency componentDepen,Mybeans mybeans,BeanConDependencia beanConDependencia, CRUD crud,OpercionMatematica matematica,TipoSaludo tipoSaludo,
								   MiBeanConProperties properties,UserPojo userPojo,UserRepositorie userRepositorie,Crud crud2,UserService userService) {
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
		this.crud2 = crud2;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBasicoApplication.class, args);

	}

	@Override
	public void run(String... args)  {
		getSave();
		//crud2.consultando("user1@gmail.com");
	//	crud2.consultando("user1@gmail.com");
	//	crud2.orderByName("usuario");
   //   crud2.getQueryById(3);
	//	crud2.getQueryWhitQueryMethods("usuario");
	//	crud2.getQueryinByEmailAndName("maranata1@gmail.com","maranata1");
	//	crud2.getQueryinWhitLike("%m%");
	//	crud2.getQueryNameOrEmail(null,"user1@gmail.com");
	//	userRepositorie.findByNameLikeOrderByIdDesc("maranata").stream().forEach(user -> LOGGER.info("USUARIOS ENCONTRADOS Y ORDENADOS: "+ user));
        LOGGER.info("USER QUERYING WHIT NAMED PARAMETERS: "+userRepositorie.getAllByBirthdayAndEmail( LocalDate.of(2005,06,02),"maranata@gmail.com"));
		saveWhitTransactional();
	}

	private void saveWhitTransactional(){

		User user = new User("usuarioText1",  "userText1@gmail.com", LocalDate.now()); //el metodo of nos permite pasar un año, mes y dia
		User user2 = new User("usuarioText12","userText2@gmail.com", LocalDate.now());
		User user3 = new User("usuariText3",  "userText3@gmail.com", LocalDate.now());
		User user4 = new User("usuarioText4", "userText3@gmail.com", LocalDate.now());
		User user5 = new User("maranatText5", "userText5@gmail.com", LocalDate.now());
		User user6 = new User("maranatText6", "userText6@gmail.com", LocalDate.now());
        List<User> users = Arrays.asList(user,user2,user3,user4,user5,user6);
		try{
			userService.getSaveTransactional(users);
		}catch (Exception e){
			LOGGER.error("controlando la exception "+ e);
		}
		userService.getAllUsers().stream().forEach(use -> LOGGER.info("USARIO REGISTRADOS: "+use));
	}
	private  void getSave(){
		User user = new User("usuario","user1@gmail.com", LocalDate.of(2000,10,20)); //el metodo of nos permite pasar un año, mes y dia
		User user2 = new User("usuario2","user2@gmail.com", LocalDate.of(1996,04,10));
		User user3 = new User("usuario","user3@gmail.com", LocalDate.of(2021,07,12));
		User user4 = new User("usuario4","user4@gmail.com", LocalDate.of(2020,07,22));
		User user5 = new User("maranata","maranata@gmail.com", LocalDate.of(2005,06,02));
		User user6 = new User("maranata1","maranata1@gmail.com", LocalDate.of(2021,05,22));
		List<User> listaUser = Arrays.asList(user,user2,user3,user4,user5,user6);
		listaUser.stream().forEach(userRepositorie::save);
		LOGGER.info(listaUser);

		//crud2.getDeleteById(user2);
		//userRepositorie.findByBirthdayBetween(LocalDate.of(1996,04,10),LocalDate.of(2005,06,02)).stream().forEach(useru -> LOGGER.info("CONSULTANDO LOS USUARIOS ENTRE UN RANGO DE FECHA" +useru));

		/*Post post = new Post("pertenece a user3",user3);
		Post post2 = new Post("pertenece a maria",user2);
		List<Post> listaPost = Arrays.asList(post,post2);
		listaPost.stream().forEach(postRepositori::save);*/
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
