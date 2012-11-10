package co.edu.unicesi.sama.client.model;

import java.io.Serializable;

import co.edu.unicesi.sama.bo.ProgramaBO;

import com.extjs.gxt.ui.client.data.BaseModel;

public class ProgramaModel extends BaseModel implements Serializable{

	public ProgramaModel(){
		
	}
	
	public ProgramaModel(int id, String nombre){
		
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
    
    public static ProgramaModel toModelFromBO(ProgramaBO bo)
    {
        ProgramaModel cModel = new ProgramaModel( );
        cModel.setId( bo.getIdPrograma( ));
        cModel.setNombre( bo.getNombre( ) );
        
        return cModel;
    }
}
