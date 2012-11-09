package co.edu.unicesi.sama.client.model;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;

import co.edu.unicesi.sama.bo.BloqueBO;
import co.edu.unicesi.sama.bo.CompetenciaBO;

public class CompetenciaModel extends BaseModel implements Serializable {
public CompetenciaModel(){
		
	}
	
	public CompetenciaModel(int id, String nombre, String descripcion){
		
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
    public static CompetenciaModel toModelFromBO(CompetenciaBO bo)
    {
        CompetenciaModel cModel = new CompetenciaModel( );
        cModel.setId( bo.getId_Competencia());
        cModel.setNombre( bo.getNombre( ) );
        cModel.setDescripcion(bo.getDescripcion());
        
        return cModel;
    }
}
