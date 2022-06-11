package com.gsnotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import com.gsnotes.services.IModuleService;
import com.gsnotes.services.IPersonService;
import com.gsnotes.bo.Module;
import com.gsnotes.bo.Utilisateur;
import com.gsnotes.dao.IModuleDao;
@SpringBootApplication
@ComponentScan({"com.gsnotes.*"})
public class ApplicationLauncher implements CommandLineRunner{

	@Autowired
     IModuleDao pp;
	@Autowired
	IModuleService ser;

	public static void main(String[] args)  {
		SpringApplication.run(ApplicationLauncher.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Module m1=ser.AjouterModule(new Module("Java/javarta","jee"));
		Module m2=ser.getModuleByCode("jee");
		System.out.println("l'ajout est bien effectuer");	
		System.out.println(m2);
	}

}

