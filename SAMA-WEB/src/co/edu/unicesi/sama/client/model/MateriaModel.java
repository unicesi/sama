package co.edu.unicesi.sama.client.model;

import java.io.Serializable;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.MateriaBO;


import com.extjs.gxt.ui.client.data.BaseModel;

public class MateriaModel extends BaseModel implements Serializable{

	public MateriaModel(){
		
	}
	
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
