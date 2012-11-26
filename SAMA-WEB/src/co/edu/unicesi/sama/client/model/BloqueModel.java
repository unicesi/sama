package co.edu.unicesi.sama.client.model;

import java.io.Serializable;

import co.edu.unicesi.sama.bo.BloqueBO;


import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * Esta clase Provee el modelo para crear un bloque.
 */
public class BloqueModel extends BaseModel implements Serializable{

	/**
	 * Constructor
	 */
	public BloqueModel(){
		
	}
	
	/**
	 * Constructor se encarga de agregar los parametros de un bloque
	 * @param id -String- es el id del bloque
	 * @param nombre -String- es el nombre del bloque
	 * @param descripcion -String- es la descripción del bloque
	 */
	public BloqueModel(int id, String nombre, String descripcion){
		
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
    public static BloqueModel toModelFromBO(BloqueBO bo)
    {
        BloqueModel cModel = new BloqueModel( );
        cModel.setId( bo.getIdBloque( ));
        cModel.setNombre( bo.getNombre( ) );
        cModel.setDescripcion(bo.getDescripcion());
        
        return cModel;
    }
}
