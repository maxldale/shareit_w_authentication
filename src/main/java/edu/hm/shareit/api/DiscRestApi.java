package edu.hm.shareit.api;

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

/**
 * REST Resource Class for the Disc API
 *
 * GET  /discs/{barcode}->  getDisc
 * GET  /discs          ->  getDiscs
 * POST /discs          ->  postDisc
 * PUT  /discs/{barcode}->  updateDisc
 */
@Path("discs")
public class DiscRestApi {
    //Field for the backend service
    private static MediaService MEDIA_SERVICE = new MediaServiceImpl();

    /**
     * Helper Method, used for setting MediaService (to allow for testing)
     * @param mediaService The MediaService to use
     */
    protected void setMediaService(MediaService mediaService){
        MEDIA_SERVICE = mediaService;
    }

    /**
     * GET (getDisc) Returns a specific disc, provided it exists
     * @param barcode The barcode for the book to get
     * @return The Response with the Json format for the disc
     */
    @GET
    @Path("{barcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDisc(@PathParam("barcode") String barcode)  {
        Disc disc = MEDIA_SERVICE.getDisc(barcode);
        return Response.ok(disc).build();
    }

    /**
     * GET (getDiscs Returns all discs
     * @return The Response with the Json array format for the discs
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscs() throws IOException {
        Collection<? extends Medium> discs = MEDIA_SERVICE.getDiscs();
        return Response.ok(discs).build();
    }

    /**
     * POST (postDisc) Posts a disc to the Media_Service
     * @param disc The disc to post
     * @return The Response from the MediaService
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postDisc(Disc disc) {
        MediaServiceResult result = MEDIA_SERVICE.addDisc(disc);
        return Response.ok(result).build();
    }

    /**
     * PUT (updateDisc) Updates a disc with the given barcode to the new values
     * @param disc The disc with the new values
     * @param barcode The barcode for the disc to replace
     * @return The Response from the MediaService
     */
    @PUT
    @Path("{barcode}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDisc(Disc disc, @PathParam("barcode") String barcode)  {
        MediaServiceResult result = MEDIA_SERVICE.updateDisc(disc, barcode);
        return Response.ok(result).build();
    }
}
