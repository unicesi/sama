package co.edu.unicesi.sama.client.model;

import java.io.Serializable;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.MateriaBO;


import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * Esta clase Provee el modelo para crear una materia.
 */
public class MateriaModel extends BaseModel implements Serializable{

	/**
	 * Constructor.
	 */
	public MateriaModel(){
		
	}
	
	/**
	 * Constructor se encarga de agregar los parametros de una materia.
	 * @param id -String- es el id de la materia.
	 * @param nombre -String- es el nombre de la materia.
	 * @param descripcion -String- es la descripción de la materia.
	 */
	public MateriaModel(int id, String nombre, String descripcion){
		
		 set( "id", id );
	     set("nombre", nombre);
		
	}
	
    public String getId( )
    {
        return (String) get("id");
    }
    
    public String getNombre( )
    {
        return (String) get( "nombre" );
    }    
    
    public void setId( String id )
    {
        set("id", id);
    }

    public void setNombre( String nombre )
    {
        set( "nombre", nombre );
    }     
    
    public static MateriaModel toModelFromBO(MateriaBO bo)
    {
        MateriaModel cModel = new MateriaModel( );
        cModel.setId( bo.getIdMateria( ));
        cModel.setNombre( bo.getNombre( ) );        
        return cModel;
    }
}
