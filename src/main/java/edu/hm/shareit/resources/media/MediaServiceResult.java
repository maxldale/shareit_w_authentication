package edu.hm.shareit.resources.media;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains all the status codes and messages needed for the MediaService.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MediaServiceResult {
    PARAMETER_MISSING(404, "At least one parameter is missing."),
    ACCEPTED(202, "Request accepted"),
    INVALID_ISBN(400, "Invalid ISBN"),
    INVALID_BARCODE(400, "Invalid Barcode"),
    DUPLICATE_ISBN(400, "ISBN already exists"),
    ISBN_NOT_FOUND(404, "ISBN does not exist"),
    ISBN_DOES_NOT_MATCH(400, "ISBN in URI and ISBN in JSON-Request do not match!"),
    INVALID_DISC(400, "Invalid Disc-Barcode"),
    DUPLICATE_DISC(400, "Disc-Barcode already exists"),
    DISC_NOT_FOUND(404, "Disc-Barcode does not exist"),
    DISC_DOES_NOT_MATCH(400, "Disc-Barcode in URI and Disc-Barcode in JSON-Request do not match!");

    private int code;
    private String status;

    /**
     * Custom constructor.
     * @param code The status code.
     * @param status The status message.
     */
    MediaServiceResult(int code, String status) {
        setCode(code);
        setStatus(status);
    }

    /**
     * Getter for the status code.
     *
     * @return the status code.
     */
    @JsonProperty
    public int getCode() {
        return code;
    }

    /**
     * Getter for the status message.
     *
     * @return the status message.
     */
    @JsonProperty
    public String getStatus() {
        return status;
    }

    /**
     * Setter for the status code.
     *
     * @param code the status code.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * setter for the status message.
     *
     * @param status the status message.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
