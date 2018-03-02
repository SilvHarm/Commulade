package fr.silvharm.commulade.model.enu;


public enum PostTypeEnum {
	
	TOPO(1),
	SITE(2),
	SECTEUR(3),
	VOIE(4);
	
	private int type;
	
	
	PostTypeEnum(int type) {
		this.type = type;
	}
	
	
	public int getType() {
		return type;
	}
}
