package alke_wallet;

public class Usuario {
	
	//Se ingresan los atributos que tiene cada usuario al momento de crear su cuente
	
	private String nombre;
	private String rut;
	private String correo;
	private String contraseña;
	
	//Metodo constructor 
	
	public Usuario(String nombre, String rut, String correo, String contraseña) {
		
		this.nombre = nombre;
		this.rut = rut;
		this.correo = correo;
		this.contraseña = contraseña;
		
	}
	

    // Getters para devolver los valores 
	
    public String getNombre() {
        return nombre;
    }
    
    public String getRut() {
    	return rut;
    }
    
    public String getCorreo() {
    	return correo;
    	
    }
    
    public String getContraseña() {
    	return contraseña;
    }
    
    public boolean validarLogin(String rut, String contraseña) {
        return this.rut.equals(rut) && this.contraseña.equals(contraseña);
    }

}
