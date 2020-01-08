package net.mertysr.hibernate.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

import net.mertysr.hibernate.model.comment.Comment;
public class Type {
	private final SelectVehicle  sVehicle;

	  public Type( final SelectVehicle sVehicle ) {
	    this.sVehicle = sVehicle;
	  }

	  public String SelectVehicle() {
		  final List< Comment > commentlist = new ArrayList< Comment >(); //Comment
		  for ( final Comment s : commentlist ) {
		      s.comment();
		    }
		  return sVehicle.selectVehicle();
	  }
}
