package edu.hm.shareit.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hm.shareit.models.mediums.Book;
import edu.hm.shareit.models.mediums.Disc;
import edu.hm.shareit.models.mediums.Medium;
import edu.hm.shareit.resources.MediaService;
import edu.hm.shareit.resources.MediaServiceImpl;
import edu.hm.shareit.resources.MediaServiceResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collection;

@Path("discs")
public class DiscRestApi {
    private final MediaService MEDIA_SERVICE = new MediaServiceImpl();

    @GET
    @Path("{barcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDisc(String barcode)  {
        Disc disc = MEDIA_SERVICE.getDisc(barcode);
        return Response.ok(disc).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscs() throws IOException {
        Collection<? extends Medium> discs = MEDIA_SERVICE.getDiscs();
        return Response.ok(discs).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postDisc(Disc disc) {
        MediaServiceResult result = MEDIA_SERVICE.addDisc(disc);
        return Response.ok(result).status(result.getCode()).build();
    }

    @PUT
    @Path("{barcode}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDisc(Disc disc, @PathParam("barcode") String barcode)  {
        MediaServiceResult result = MEDIA_SERVICE.updateDisc(disc, barcode);
        return Response.ok(result).status(result.getCode()).build();
    }
}