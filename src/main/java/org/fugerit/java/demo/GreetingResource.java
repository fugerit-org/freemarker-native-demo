package org.fugerit.java.demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Path("/hello")
public class GreetingResource {

    private static final Logger log = LoggerFactory.getLogger(GreetingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }


    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/freemarker")
    public String helloFreeMarker() {
        return this.helloFreeMarker( null, null, null );
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/freemarker/{major}/{minor}/{patch}")
    public String helloFreeMarker(@PathParam("major") Integer major, @PathParam("minor") Integer minor, @PathParam("patch") Integer patch) {
        try (StringWriter buffer = new StringWriter()) {
            Version version = Configuration.getVersion();   // using latest version
            if ( major != null && minor != null && patch != null ) {
                version = new Version( major, minor, patch );
            }
            // creates FreeMarker configuration
            Configuration cfg = new Configuration( version );
            cfg.setClassForTemplateLoading(GreetingResource.class, "/freemarker-templates/");
            // creates data model
            HelloDataModel data = new HelloDataModel();
            data.setName( "FreeMarker Native Demo" );
            data.setVersion( version.toString() );
            Map<String, Object> input = new HashMap<>();
            input.put( "data", data );
            // process template
            Template template = cfg.getTemplate( "hello-world.ftl" );
            template.process( input, buffer );
            return buffer.toString();
        } catch (Exception e) {
            log.error( String.format( "Error on helloFreeMarker() : %s", e ), e );
            throw new WebApplicationException( Response.Status.INTERNAL_SERVER_ERROR );
        }
    }

}
