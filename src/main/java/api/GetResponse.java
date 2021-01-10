package main.java.api;

import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("response")
public class GetResponse {

	
	@GET
	//@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Message(){
		return Response.ok("Hej").build();
	}
	
	
	@GET
	@Path("/kurskod/{kod}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Courses(@PathParam("kod") String courseCode){
		String App = new App().searchCourse(courseCode);
		return Response.ok(App).build();
	}
	
	@GET
	@Path("/kursid/{id}/{startDate}/{endDate}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response events(@PathParam("id") String courseId,@PathParam("startDate") String startDate, @PathParam("endDate") String endDate){
		ArrayList<getCourse> App = new App().searchCourseInfo(courseId,startDate,endDate);
		App.toString();
		return Response.ok(App).build();
	}
	@GET
	@Path("/lektid/{id}/{startDate}/{endDate}/{lektId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response clas(@PathParam("id") String courseId,@PathParam("startDate") String startDate, @PathParam("endDate") String endDate, @PathParam("lektId") String lektId){
		ArrayList<getCourse> App = new App().searchLektInfo(courseId,startDate,endDate, lektId);
		App.toString();
		return Response.ok(App).build();
	}
	
	@POST
	@Path("/postEvent/{title}/{start}/{end}/{date}/{descr}/{loc}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postEvent(@PathParam("title")String title,@PathParam("start")String start,
			@PathParam("end")String end,@PathParam("date")String date,@PathParam("descr")String descr,@PathParam("loc")String loc) throws Exception {
		System.out.println("test");
		App test = new App();
		
//		ArrayList<String> test3 = new ArrayList();
//		test3.set(9, titel);
		
		
				
		test.sendCanvas(title,start,end,date,descr,loc);
		
		return Response.ok().build();
		
	}
	
	@POST
	@Path("/postCanvas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postEventForm(@FormParam("title")String title,@FormParam("start")String start,
			@FormParam("end")String end,@FormParam("date")String date,@FormParam("descr")String descr,@FormParam("loc")String loc) throws Exception {
		System.out.println("test");
		App test = new App();
		
//		ArrayList<String> test3 = new ArrayList();
//		test3.set(9, titel);
		
		
				
		test.sendCanvas(title,start,end,date,descr,loc);
		
		return Response.created(URI.create("response/" + test)).build();
		
	}
	
	
}
