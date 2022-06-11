package com.gsnotes.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsnotes.services.IElementService;
import com.gsnotes.services.IEnseignantService;
import com.gsnotes.services.IFiliereService;
import com.gsnotes.services.IModuleService;
import com.gsnotes.services.INiveauService;
import com.gsnotes.web.models.ElementModel;
import com.gsnotes.web.models.FiliereModel;
import com.gsnotes.web.models.ModuleModel;
import com.gsnotes.web.models.NiveauModel;
import com.gsnotes.bo.Element;
import com.gsnotes.bo.Enseignant;
import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Module;
import com.gsnotes.bo.Niveau;
@Controller
@RequestMapping("/cadreadmin")
public class CntrolleurDeGestionPedagogique {
	//Service de module
	@Autowired
	IModuleService modServ;
	//Service de filiere
	@Autowired
    IFiliereService filServ;
	//Service de Niveau
	@Autowired
	INiveauService niveauService;
	@Autowired
	//Service d'element
	IElementService elemService;
	@Autowired
	//Service d'Enseignant
	IEnseignantService ensService;
	public CntrolleurDeGestionPedagogique() {
		
		
	}
	//cette fonction sert à afficher le formulaire d'ajout d'un module
	@RequestMapping("/formView")
	public String formView(Model model ) {
		ModuleModel m = new ModuleModel();
		model.addAttribute("Modulemodel",m);
	    model.addAttribute("nivList",niveauService.getAllNiveau());
		List<Module> modules = modServ.getAllModule();
		List<ModuleModel> modelModule = new ArrayList<ModuleModel>();
		for (int i = 0; i < modules.size(); i++) {
			ModuleModel fm = new ModuleModel();
			BeanUtils.copyProperties((Module) modules.get(i), fm);
			modelModule.add(fm);
		}
        model.addAttribute("ModuleList", modelModule);
		return "/cadreadmin/form";
		
	}
	//c'est la fonction qui fait l'ajout
	@RequestMapping("/AjouterModule")
	public String AjouterModule(@Valid @ModelAttribute("Modulemodel") ModuleModel m,BindingResult bindingResult,
			Model model) {
		// En cas d'erreur de validation
				if (bindingResult.hasErrors()) {
					return "/cadreadmin/form";
				}
				Module module = new Module ();
				BeanUtils.copyProperties(m, module);
				System.out.println(module.toString());
				modServ.AjouterModule(module);
				return "redirect:/cadreadmin/formView";
	}
	//Affiche la liste des modules
	@RequestMapping("/listeModule")
	public String listeModule(Model model) {
		ModuleModel m = new ModuleModel();
		model.addAttribute("Modulemodel",m);
		List<Module> modules = modServ.getAllModule();
		List<ModuleModel> modelModule = new ArrayList<ModuleModel>();
		for (int i = 0; i < modules.size(); i++) {
			ModuleModel fm = new ModuleModel();
			BeanUtils.copyProperties((Module) modules.get(i), fm);
			modelModule.add(fm);
		}
		model.addAttribute("ModuleList", modelModule);
		return "/cadreadmin/listeModule";
	}
	//cette fonction fait l update de module
	@RequestMapping(value = "UpdateModule/{idModule}", method = RequestMethod.GET)
	public String UpdateModule(@PathVariable int idModule, Model model) {
		// On recoit comme paramètre l'id de module à mettre à jour
				Module m =modServ.getModuleById(Long.valueOf(idModule));
				// On construit le modèle
				ModuleModel mm = new ModuleModel();
				BeanUtils.copyProperties(m,mm);
				model.addAttribute("Modelmodel", mm);
				System.out.println(mm.toString());
				List<Module> modules = modServ.getAllModule();
				List<ModuleModel> modelModule = new ArrayList<ModuleModel>();
				for (int i = 0; i < modules.size(); i++) {
					ModuleModel fm = new ModuleModel();
					BeanUtils.copyProperties((Module) modules.get(i), fm);
					modelModule.add(fm);
				}
				model.addAttribute("moduleList", modelModule);
				model.addAttribute("nivList",niveauService.getAllNiveau());

		return "/cadreadmin/updateModule";
		
	}
	@RequestMapping("/UpdateModule/UpdateModuleAll")
   public String UpdateModuleAll(@Valid @ModelAttribute("Modelmodel") ModuleModel m, BindingResult bindingResult,
			Model model) {
		System.out.println(m.getTitre());
		Module module = new Module ();
		BeanUtils.copyProperties(m,module);
		modServ.ModierModule(module);
		System.out.println(module.toString());
		System.out.println("afaaaaaaaaaaaaaak");

	return "redirect:/cadreadmin/formView";   
		
	
}
	@RequestMapping(value = "SupprimerModule/{idModule}", method = RequestMethod.GET)

	public String SupprimerModule(@PathVariable int idModule, Model model) {
				Module mod =modServ.getModuleById(Long.valueOf(idModule));
				modServ.deleteModule(Long.valueOf(idModule));
				ModuleModel m = new ModuleModel();
				model.addAttribute("Modulemodel",m);
				List<Module> modules = modServ.getAllModule();
				List<ModuleModel> modelModule = new ArrayList<ModuleModel>();
				for (int i = 0; i < modules.size(); i++) {
					ModuleModel fm = new ModuleModel();
					BeanUtils.copyProperties((Module) modules.get(i), fm);
					modelModule.add(fm);
					}
				model.addAttribute("moduleList", modelModule);
		return "redirect:/cadreadmin/formView";
		
	}
	@RequestMapping("/chercherMod")
	public String ChercherMod(Model model) {
		ModuleModel m= new ModuleModel();
		model.addAttribute("Modulerechmodel",m);
		return "/cadreadmin/FormChercheMod";
		
	}
	@RequestMapping("/ChercherModule")
    public String consulterMod(@Valid @ModelAttribute("Modulerechmodel") ModuleModel f,BindingResult bindingResult,
			Model model) {
 		    System.out.println(f.getCode());
			Module c=modServ.getModuleByCode(f.getCode());
			System.out.println(c.getTitre());
			model.addAttribute("modulecherche",c);
    	return ("/cadreadmin/FormChercheMod");
    }
	@RequestMapping(value = "listeElement/{idModule}", method = RequestMethod.GET)

	public String listeElementAModule(@PathVariable int idModule, Model model) {
				Module m =modServ.getModuleById(Long.valueOf(idModule));
				ModuleModel mm = new ModuleModel();
				BeanUtils.copyProperties(m,mm);
				model.addAttribute("Modelmodel", mm);
				model.addAttribute("listeElementAModule",mm.getElements());

		return "/cadreadmin/listeElementAModule";
		
	}
	
	@RequestMapping("/formFiliereView")
	public String formFiliereView(Model model ) {
		FiliereModel f = new FiliereModel();
		model.addAttribute("Filieremodel",f);
		List<Filiere> filieres = filServ.getAllFiliere();
		List<FiliereModel> modelFiliere = new ArrayList<FiliereModel>();
		for (int i = 0; i < filieres.size(); i++) {
			FiliereModel fm = new FiliereModel();
			BeanUtils.copyProperties((Filiere) filieres.get(i), fm);
			modelFiliere.add(fm);	
		}
		model.addAttribute("filiereList", modelFiliere);
		System.out.println(modelFiliere);
		List<Enseignant> l1= ensService.getAllEnseignant();
		model.addAttribute("listEns", l1);
		return "/cadreadmin/formFilere";
		
		
	}
	@RequestMapping("/AjouterFiliere")
	public String AjouterFiliere(@Valid @ModelAttribute("Filieremodel") FiliereModel f,BindingResult bindingResult,
			Model model) {
				if (bindingResult.hasErrors()) {
					return "/cadreadmin/formFiliere";
				}
				Filiere filiere = new Filiere ();
				BeanUtils.copyProperties(f, filiere);
				System.out.println(filiere.getEnseignant());
				filServ.AjouterFiliere(filiere);
				return "redirect:/cadreadmin/formFiliereView";
		
	}
	@RequestMapping(value = "UpdateFiliere/{idFiliere}", method = RequestMethod.GET)

	public String UpdateFiliere(@PathVariable int idFiliere, Model model) {
				Filiere fl =filServ.getFiliereById(Long.valueOf(idFiliere));
				FiliereModel f = new FiliereModel();
				BeanUtils.copyProperties(fl,f);
				model.addAttribute("Filieremodel", f);
				System.out.println(f.toString());
				List<Filiere> filieres = filServ.getAllFiliere();
				List<FiliereModel> modelFiliere = new ArrayList<FiliereModel>();
				for (int i = 0; i < filieres.size(); i++) {
					FiliereModel fm = new FiliereModel();
						BeanUtils.copyProperties((Filiere) filieres.get(i), fm);
						modelFiliere.add(fm);
				}
				List<Enseignant> l1= ensService.getAllEnseignant();
				model.addAttribute("listEns", l1);
				model.addAttribute("filiereList", modelFiliere);
		return "/cadreadmin/updateFiliere";
		
	}
	@RequestMapping("/UpdateFiliere/UpdateFiliereAll")
   public String UpdateFiliereAll(@Valid @ModelAttribute("Filieremodel") FiliereModel f, BindingResult bindingResult,
			Model model) {
		Filiere filiere = new Filiere ();
		BeanUtils.copyProperties(f, filiere);
		System.out.println(filiere.getEnseignant());
		filServ.ModierFiliere(filiere);
	return "redirect:/cadreadmin/formFiliereView";   
		
	
}
	@RequestMapping("/listFil")
	public String listFil(Model model) {
		FiliereModel f = new FiliereModel();
		model.addAttribute("Filieremodel",f);
		List<Filiere> filieres = filServ.getAllFiliere();
		List<FiliereModel> modelFiliere = new ArrayList<FiliereModel>();

		for (int i = 0; i < filieres.size(); i++) {
			FiliereModel fm = new FiliereModel();
				BeanUtils.copyProperties((Filiere) filieres.get(i), fm);
				modelFiliere.add(fm);
			
		}

		model.addAttribute("filiereList", modelFiliere);
		return "/cadreadmin/ListFiliere";
	}
	@RequestMapping(value = "SupprimerFiliere/{idFiliere}", method = RequestMethod.GET)

	public String SupprimerFiliere(@PathVariable int idFiliere, Model model) {
				Filiere fl =filServ.getFiliereById(Long.valueOf(idFiliere));
				filServ.deleteFiliere(Long.valueOf(idFiliere));
				FiliereModel f = new FiliereModel();
				model.addAttribute("Filieremodel",f);
				List<Filiere> filieres = filServ.getAllFiliere();
				List<FiliereModel> modelFiliere = new ArrayList<FiliereModel>();
				for (int i = 0; i < filieres.size(); i++) {
					FiliereModel fm = new FiliereModel();
						BeanUtils.copyProperties((Filiere) filieres.get(i), fm);
						modelFiliere.add(fm);
					
				}

				model.addAttribute("filiereList", modelFiliere);
				System.out.println(modelFiliere);
		return "/cadreadmin/ListFiliere";
		
	}
	@RequestMapping("/chercherfil")
	public String chercherFiliere(Model model) {
	FiliereModel f = new FiliereModel();
		model.addAttribute("Filiererechmodel",f);
		return "/cadreadmin/FormChercheFil";
		
	}
	@RequestMapping("/cherFil")
    public String consulter(@Valid @ModelAttribute("Filiererechmodel") FiliereModel f,BindingResult bindingResult,
			Model model) {
			Filiere c =filServ.getFiliereByCodeFiliere(f.getCodeFiliere());
			model.addAttribute("filerecherche",c);
    	return ("/cadreadmin/FormChercheFil");
    }
	@RequestMapping(value = "listeNiveau/{idFiliere}", method = RequestMethod.GET)

	public String listeNiveauAFiliere(@PathVariable int idFiliere, Model model) {
				Filiere m =filServ.getFiliereById(Long.valueOf(idFiliere));
				FiliereModel mm = new FiliereModel();
				BeanUtils.copyProperties(m,mm);
				model.addAttribute("Filieremodel", mm);
				model.addAttribute("listeNiveauAFiliere",mm.getNiveaux());

		return "/cadreadmin/listeNiveauAFiliere";
		
	}
	@RequestMapping("/formNiveauView")
	public String formViewNiveau(Model model ) {
		NiveauModel n = new NiveauModel();
		model.addAttribute("NiveauModel",n);
		List<Niveau> niveaux = niveauService.getAllNiveau();
		List<NiveauModel> modelniveaux = new ArrayList<NiveauModel>();
		for (int i = 0; i < niveaux.size(); i++) {
			NiveauModel Nm  = new NiveauModel();
				BeanUtils.copyProperties((Niveau) niveaux.get(i), Nm);
				modelniveaux.add(Nm);
		}
		List<Filiere> l1= filServ.getAllFiliere();
		model.addAttribute("listFil", l1);
		model.addAttribute("NiveauList", modelniveaux);
		return "/cadreadmin/formNiveau";
		
	}
	@RequestMapping("/AjouterNiveau")
	public String AjouterModule(@Valid @ModelAttribute("NiveauModel") NiveauModel m,BindingResult bindingResult,
			Model model) {
				if (bindingResult.hasErrors()) {
					return "/cadreadmin/formNiveau";
				}
				Niveau niveau = new Niveau ();
				BeanUtils.copyProperties(m, niveau);
				System.out.println(niveau.toString());
				niveauService.AjouterNiveau(niveau);

				return "redirect:/cadreadmin/formNiveauView";
		
	}
	@RequestMapping(value = "UpdateNiveau/{idNiveau}", method = RequestMethod.GET)

	public String UpdateNiveau(@PathVariable int idNiveau, Model model) {
		Niveau n =niveauService.getNiveauById(Long.valueOf(idNiveau));
		        NiveauModel Nm = new NiveauModel();
				BeanUtils.copyProperties(n,Nm);
				model.addAttribute("NiveauModel", Nm);
				List<Niveau> niveaux = niveauService.getAllNiveau();
				List<NiveauModel> modelniveaux = new ArrayList<NiveauModel>();
				for (int i = 0; i < niveaux.size(); i++) {
					NiveauModel N  = new NiveauModel();
					
						BeanUtils.copyProperties((Niveau) niveaux.get(i), N);
						modelniveaux.add(N);
					
				}
				List<Filiere> l1= filServ.getAllFiliere();
				model.addAttribute("listFil", l1);
				
				model.addAttribute("NiveauList", modelniveaux);

		return "/cadreadmin/updateNiveau";
		
	}
	@RequestMapping("/UpdateNiveau/UpdateNiveauAll")
   public String UpdateNiveauAll(@Valid @ModelAttribute("NiveauModel") NiveauModel n, BindingResult bindingResult,
			Model model) {

		Niveau niveau = new Niveau ();
		BeanUtils.copyProperties(n, niveau);
		

		niveauService.ModierNiveau(niveau);
		
		return "redirect:/cadreadmin/formNiveauView";
  
		
	
}
	@RequestMapping("/ListeNiveaux")
	public String listeNiveaux(Model model) {
		NiveauModel n = new NiveauModel();
		model.addAttribute("NiveauModel",n);
		List<Niveau> niveaux = niveauService.getAllNiveau();
		List<NiveauModel> modelniveaux = new ArrayList<NiveauModel>();
		for (int i = 0; i < niveaux.size(); i++) {
			NiveauModel Nm  = new NiveauModel();
				BeanUtils.copyProperties((Niveau) niveaux.get(i), Nm);
				modelniveaux.add(Nm);
			
		}

		model.addAttribute("NiveauList", modelniveaux);
		return "/cadreadmin/ListeNiveaux";
		
	}
	@RequestMapping(value = "SupprimerNiveau/{idNiveau}", method = RequestMethod.GET)

	public String SupprimerNiveau(@PathVariable int idNiveau, Model model) {
				Niveau fl =niveauService.getNiveauById(Long.valueOf(idNiveau));
				niveauService.deleteNiveau(Long.valueOf(idNiveau));
				NiveauModel n = new NiveauModel();
				model.addAttribute("NiveauModel",n);
				List<Niveau> niveaux = niveauService.getAllNiveau();
				List<NiveauModel> modelniveaux = new ArrayList<NiveauModel>();
				for (int i = 0; i < niveaux.size(); i++) {
					NiveauModel Nm  = new NiveauModel();
						BeanUtils.copyProperties((Niveau) niveaux.get(i), Nm);
						modelniveaux.add(Nm);
				}

				model.addAttribute("NiveauList", modelniveaux);
		return "/cadreadmin/ListeNiveaux";
		
	}
	@RequestMapping("/chercherNiveau")
	public String chercherNiveau(Model model) {
		NiveauModel n = new NiveauModel();
	
		model.addAttribute("NiveauChercheModel",n);
		return "/cadreadmin/FormChercheNiv";
		
	}
	@RequestMapping("/cherNiv")
    public String consulterNiveau(@Valid @ModelAttribute("NiveauChercheModel") NiveauModel nn,BindingResult bindingResult,
			Model model) {
		
		
			Niveau n =niveauService.getFiliereByAlias(nn.getAlias());
			model.addAttribute("NiveauCherchee",n);
			
	
    	return ("/cadreadmin/FormChercheNiv");
    }
	//Element
	@RequestMapping("/viewElement")
	public String AfficherElem(Model model) {
		ElementModel m= new ElementModel();
		model.addAttribute("Elementmodel",m);
		List<Enseignant> l1= ensService.getAllEnseignant();
		model.addAttribute("listEns", l1);
		List<Module> l2=modServ.getAllModule();
		model.addAttribute("listMod", l2);
		model.addAttribute("ElementList",elemService.getAllElement());
		return "/cadreadmin/formElement";
		
	}
	@RequestMapping("/AjouterElement")
	public String AjouterElement(@Valid @ModelAttribute("Elementmodel") ElementModel e,BindingResult bindingResult,
			Model model) {
		
				Element element = new Element ();
				BeanUtils.copyProperties(e, element);
				
				elemService.AjouterElement(element);
                
				return "redirect:/cadreadmin/viewElement";
		
	}
	@RequestMapping(value = "UpdateElement/{idMatiere}", method = RequestMethod.GET)

	public String UpdateElement(@PathVariable int idMatiere, Model model) {
		Element e=elemService.getElementById(Long.valueOf(idMatiere));
		
				ElementModel el = new ElementModel();
				BeanUtils.copyProperties(e,el);
				model.addAttribute("Elementmodel", el);
				model.addAttribute("ElementList",elemService.getAllElement());

				List<Enseignant> l1= ensService.getAllEnseignant();
				model.addAttribute("listEns", l1);
				List<Module> l2=modServ.getAllModule();
				model.addAttribute("listMod", l2);

		return "/cadreadmin/updateElement";
		
	}
	@RequestMapping("/UpdateElement/UpdateElementAll")
   public String UpdateElementAll(@Valid @ModelAttribute("ElementModel") ElementModel e, BindingResult bindingResult,
			Model model) {

		Element element = new Element ();
		BeanUtils.copyProperties(e, element);
		
		elemService.ModifierElement(element);
		
		return "redirect:/cadreadmin/viewElement";
  
		
	
}
	@RequestMapping(value = "SupprimerElement/{idMatiere}", method = RequestMethod.GET)

	public String SupprimerElement(@PathVariable int idMatiere, Model model) {
				Element el=elemService.getElementById(Long.valueOf(idMatiere));
				elemService.deleteElement(Long.valueOf(idMatiere));
				model.addAttribute("ElementList",elemService.getAllElement());
				List<Enseignant> l1= ensService.getAllEnseignant();
				model.addAttribute("listEns", l1);
				List<Module> l2=modServ.getAllModule();
				model.addAttribute("listMod", l2);
				return "redirect:/cadreadmin/viewElement";
		
	}
	@RequestMapping("/ListeElement")
	public String ListeElement(Model model) {
		ElementModel n = new ElementModel();
		model.addAttribute("elemntModel",n);
		List<Element> elements = elemService.getAllElement();
		List<ElementModel> modelElements = new ArrayList<ElementModel>();
		for (int i = 0; i < elements.size(); i++) {
			ElementModel el  = new ElementModel();
				BeanUtils.copyProperties((Element) elements.get(i), el);
				modelElements.add(el);
			
		}

		model.addAttribute("ElementList", modelElements);
		return "/cadreadmin/ListeElement";
		
	}
	@RequestMapping("/showConsult")
	public String ConsulterElement(Model model) {
		ElementModel e=new ElementModel();
		model.addAttribute("elemModel",e);
		model.addAttribute("ElementList",elemService.getAllElement());
		return "/cadreadmin/chercherElement";
	}
	@RequestMapping("/ConsulterElement")
   public String ChercherElement(@Valid @ModelAttribute("elemModel") ElementModel nn,BindingResult bindingResult,
			Model model) {
		Element e=elemService.getElementByCode(nn.getCode());
        model.addAttribute("elementChercher",e);
		return "/cadreadmin/chercherElement";
   }

}
