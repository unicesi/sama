package co.edu.unicesi.sama.client.model;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.CompetenciaTerminalBO;

/**
 * Constructor se encarga de agregar los parametros de una competencia especifica.
 * @param id -String- es el id de la competencia especifica.
 * @param nombre -String- es el nombre de la competencia especifica.
 * @param descripcion -String- es la descripción de la competencia especifica.
 */
public class CompetenciaTerminalModel extends BaseModel implements Serializable {

	/**
	 * Constructor.
	 */
	public CompetenciaTerminalModel(){
		
	}
	
	/**
	 * Constructor se encarga de agregar los parametros de una competencia especifica.
	 * @param id -String- es el id de la competencia especifica.
	 * @param nombre -String- es el nombre de la competencia especifica.
	 * @param descripcion -String- es la descripción de la competencia especifica.
	 */
	public CompetenciaTerminalModel(int id, String nombre, String descripcion){
		
		 set( "id", id );
	     set("nombre", nombre);
	     set("descripcion", descripcion);
		
	}
	
    public int getId( )
    {
        return (Integer) get("id");
    }
    
    public String getNombre( )
    {
        return (String) get( "nombre" );
    }    
    
    public String getDescripcion()
    {
    	return (String) get("descripcion");
    	
    }

    public void setId( int id )
    {
        set("id", id);
    }

    public void setNombre( String nombre )
    {
        set( "nombre", nombre );
    }     
    
    public void setDescripcion (String descripcion){
    	
    	set ("descripcion", descripcion);
    }
    public static CompetenciaTerminalModel toModelFromBO(CompetenciaTerminalBO bo)
    {
    	CompetenciaTerminalModel cModel = new CompetenciaTerminalModel( );
        cModel.setId( bo.getId_Competencia());
        cModel.setNombre( bo.getNombre( ) );
        cModel.setDescripcion(bo.getDescripcion());
        
        return cModel;
    }
}
