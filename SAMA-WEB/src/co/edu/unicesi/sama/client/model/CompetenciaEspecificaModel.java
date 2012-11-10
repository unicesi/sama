package co.edu.unicesi.sama.client.model;

import java.io.Serializable;


import co.edu.unicesi.sama.bo.CompetenciaEspecificaBO;

import com.extjs.gxt.ui.client.data.BaseModel;

public class CompetenciaEspecificaModel extends BaseModel implements Serializable {
public CompetenciaEspecificaModel(){
		
	}
	
	public CompetenciaEspecificaModel(int id, String nombre, String descripcion){
		
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
    public static CompetenciaEspecificaModel toModelFromBO(CompetenciaEspecificaBO b)
    {
    	CompetenciaEspecificaModel cModel = new CompetenciaEspecificaModel( );
        cModel.setId( b.getIdLineaDeCompetencia());
        cModel.setNombre( b.getNombre( ) );
        cModel.setDescripcion(b.getDescripcion());
        
        return cModel;
    }
}
