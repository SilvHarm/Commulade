package fr.silvharm.commulade.business.helper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.silvharm.commulade.model.bean.LongueurFormBean;
import fr.silvharm.commulade.model.bean.SecteurFormBean;
import fr.silvharm.commulade.model.bean.SiteFormBean;
import fr.silvharm.commulade.model.bean.SiteSearchFormBean;
import fr.silvharm.commulade.model.bean.TopoFormBean;
import fr.silvharm.commulade.model.bean.VoieFormBean;

public class FormVerificationHelper {
	
	private static final Logger logger = LogManager.getLogger();
	
	
	/**
	 * Verify if the SiteSearchFormBean properties have the format expected
	 * 
	 * @return true if the SiteSearchFormBean is valid or false if it's not
	 */
	public static Boolean siteSearch(SiteSearchFormBean formBean) {
		// if every properties are empty
		if ((formBean.getSiteName() + formBean.getMinHeight() + formBean.getMaxHeight() + formBean.getMinPointNumber()
				+ formBean.getMaxPointNumber() + formBean.getCotation()).isEmpty()) {
			logger.info("All properties of the Form are empty");
			
			return false;
		}
		
		if (formBean.getSiteName().length() > 48) {
			logger.info("siteName property length is unexpected");
			
			return false;
		}
		
		int i;
		try {
			// if form field wasn't left empty
			if (!formBean.getMinHeight().isEmpty()) {
				// test if field content is an Integer
				i = Integer.parseInt(formBean.getMinHeight());
				// test if value is unexpected
				if (i < 1 && 99 < i) {
					logger.info("minHeight property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getMaxHeight().isEmpty()) {
				i = Integer.parseInt(formBean.getMaxHeight());
				if (i < 2 && 100 < i) {
					logger.info("maxHeight property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getMinPointNumber().isEmpty()) {
				i = Integer.parseInt(formBean.getMinPointNumber());
				if (i < 1 && 99 < i) {
					logger.info("minPointNumber property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getMaxPointNumber().isEmpty()) {
				i = Integer.parseInt(formBean.getMaxPointNumber());
				if (i < 2 && 100 < i) {
					logger.info("maxPointNumber property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getCotation().isEmpty()) {
				i = Integer.parseInt(formBean.getCotation());
				if (i < 3 && 9 < i) {
					logger.info("cotation property value is unexpected");
					
					return false;
				}
			}
		}
		catch (NumberFormatException e) {
			logger.info("A property of the form who should have been an Integer wasn't one\n", e);
			
			return false;
		}
		
		
		return true;
	}
	
	
	/**
	 * Verify if the SiteFormBean properties have the format expected
	 * 
	 * @param siteForm
	 * @return true if the SiteFormBean is valid or false if it's not
	 */
	public static Boolean shareSite(SiteFormBean siteForm) {
		int i, j, k;
		String tempo;
		
		try {
			tempo = siteForm.getName();
			if (tempo.isEmpty() || tempo.length() > 50) {
				logger.info("A SiteFormBean's name property value is unexpected");
				
				return false;
			}
			
			tempo = siteForm.getPhotoName();
			if (tempo != null) {
				if (tempo.isEmpty()) {
					logger.info("A SiteFormBean's photoName property value is unexpected");
					
					return false;
				}
			}
			
			tempo = siteForm.getPhotoType();
			if (tempo != null) {
				if (tempo.isEmpty() || !(tempo.equals("image/jpeg") || tempo.equals("image/png"))) {
					logger.info("A SiteFormBean's photoType property value is unexpected");
					
					return false;
				}
			}
			
			tempo = siteForm.getPlace();
			if (tempo.isEmpty() || tempo.length() > 128) {
				logger.info("A SiteFormBean's place property value is unexpected");
				
				return false;
			}
			
			tempo = siteForm.getPathIndication();
			if (tempo.isEmpty() || tempo.length() > 256) {
				logger.info("A SiteFormBean's pathIndication property value is unexpected");
				
				return false;
			}
			
			
			// test siteForm's List<SecteurFormBean>
			List<SecteurFormBean> listSecteur = siteForm.getListSecteur();
			if (listSecteur != null) {
				for (i = 0; i < listSecteur.size(); i++) {
					SecteurFormBean secteur = listSecteur.get(i);
					
					if (secteur != null) {
						tempo = secteur.getName();
						if (tempo.isEmpty() || tempo.length() > 50) {
							logger.info("A SecteurFormBean name property value is unexpected");
							
							return false;
						}
						
						tempo = secteur.getPhotoName();
						if (tempo != null) {
							if (tempo.isEmpty()) {
								logger.info("A SecteurFormBean photoName property value is unexpected");
								
								return false;
							}
						}
						
						tempo = secteur.getPhotoType();
						if (tempo != null) {
							if (tempo.isEmpty() || !(tempo.equals("image/jpeg") || tempo.equals("image/png"))) {
								logger.info("A SecteurFormBean photoType property value is unexpected");
								
								return false;
							}
						}
						
						
						// test secteur's List<VoieFormBean>
						List<VoieFormBean> listVoie = secteur.getListVoie();
						if (listVoie != null) {
							for (j = 0; j < listVoie.size(); j++) {
								VoieFormBean voie = listVoie.get(j);
								
								if (voie != null) {
									tempo = voie.getName();
									if (tempo.isEmpty() || tempo.length() > 50) {
										logger.info("A VoieFormBean name property value is unexpected");
										
										return false;
									}
									
									
									// test voie's List<LongueurFormBean>
									List<LongueurFormBean> listLongueur = voie.getListLongueur();
									if (listVoie != null) {
										for (k = 0; k < listLongueur.size(); k++) {
											LongueurFormBean longueur = listLongueur.get(k);
											
											if (longueur != null) {
												tempo = longueur.getCotation();
												if (tempo.isEmpty() || tempo.length() > 10) {
													logger.info("A LongueurFormBean cotation property value is unexpected");
													
													return false;
												}
												
												try {
													tempo = longueur.getHeight();
													if (tempo.isEmpty()) {
														i = Integer.parseInt(tempo);
														if (i < 0 && 32000 < i) {
															logger.info("A LongueurFormBean height property value is unexpected");
															
															return false;
														}
													}
												}
												catch (NumberFormatException e) {
													logger.info("A property of the form who should have been an Integer wasn't one");
													
													return false;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		catch (NullPointerException e) {
			logger.info("A property of the SiteFormBean was null when it shouldn't have been");
			
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * Verify if the TopoFormBean properties have the format expected
	 * 
	 * @param topoForm
	 * @return true if the TopoFormBean is valid or false if it's not
	 */
	public static Boolean shareTopo(TopoFormBean topoForm) {
		
		
		return true;
	}
	
}
